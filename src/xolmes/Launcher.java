package xolmes;

import java.util.ArrayList;
import java.util.HashMap;

import tools.Graph;
import truelecter.problem_solving.Action;
import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.action.EatDiamondAction;
import truelecter.problem_solving.pacthedude.bfs.action.MoveDownAction;
import truelecter.problem_solving.pacthedude.bfs.action.MoveLeftAction;
import truelecter.problem_solving.pacthedude.bfs.action.MoveRightAction;
import truelecter.problem_solving.pacthedude.bfs.action.MoveUpAction;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState.Location;
import voidstorm.solver.AstarSolver;
import voidstorm.AStarState;
import voidstorm.LinkedQueue;
import xolmes.checkers.actions.MoveUpLeft;
import xolmes.checkers.actions.MoveUpRight;
import xolmes.tools.*;

public class Launcher {

	private HashMap<String, Graph> maps;
	private HashMap<String, Solver> solvers;
	private HashMap<String, WorldAbstractClass> worlds;


	private ArrayList<Action> actions;
	private final static String map = "PTD_map_01";
	private final static String name_of_solver = "AStar";


	public Launcher() {

	}

	public static void main(String[] args) {

		Launcher l = new Launcher();
		WorldAbstractClass w = null;

		// GRAPHS
		l.maps = new HashMap<String, Graph>();
		l.maps.put("PTD_map_01", new Graph("labirinth_test.txt"));
		l.maps.put("Checkers_map_01", new Graph("Checkers_map_01.txt"));

		// GAMES
		l.worlds = new HashMap<String, WorldAbstractClass>();
		l.worlds.put("PTD_World", new World());
		l.worlds.put("Checkers_World", new World_checkers());

		l.actions = new ArrayList<Action>();
		
		switch (map) {
		case "PTD_map_01":
			w = l.worlds.get("PTD_World");
			l.actions.add(new MoveDownAction());
			l.actions.add(new MoveLeftAction());
			l.actions.add(new MoveRightAction());
			l.actions.add(new MoveUpAction());
			l.actions.add(new EatDiamondAction());
			break;
		case "Checkers_map_01":
			w = l.worlds.get("Checkers_World");
			l.actions.add(new MoveUpLeft());
			l.actions.add(new MoveUpRight());
			l.actions.add(new EatDiamondAction());
			break;
		default:
			break;
		}
		w.start();

		// SET LOCATINS
		Location heroLoc = new Location(0, l.maps.get(map).Y()-1);
		Location aimLoc = new Location(l.maps.get(map).X()-3, 0);

		// SOLVERS
		l.solvers = new HashMap<String, Solver>();
		l.initSolvers(l.maps.get(map), heroLoc, aimLoc);

		LinkedQueue<Integer> toDraw = l.solve(name_of_solver);
		if (w != null && toDraw!=null) {
			w.visualize(toDraw, l.maps.get(map), heroLoc.x, heroLoc.y,
					aimLoc.x, aimLoc.y);
		}

	}

	private void initSolvers(Graph world, Location heroLoc, Location aimLoc) {
		WorldState startingState = new WorldState(null, null, heroLoc, aimLoc,
				world);
		
		solvers.put("BFS", new BFSSolver(startingState,actions));
		solvers.put("DFS", new DFSSolver(startingState,actions));
		
		//INIT A* HERE
		State start = new AStarState(null, null, heroLoc, aimLoc,
				world, 0);
		solvers.put("AStar", new AstarSolver(start));
	}

	private LinkedQueue<Integer> solve(String solver_name) {

		State finish = solvers.get(solver_name).solve();

		if (finish != null) {
			System.out.println("Solution found!");
			LinkedQueue<State> path = BFSSolver.path(finish);
			System.out.println(path.size());
			LinkedQueue<Integer> toDraw = new LinkedQueue<>();
			for (State s : path) {
				if (s instanceof WorldState) {
					WorldState state = (WorldState) s;
					toDraw.enqueue(state.getPacmanLocation().x
							+ state.getPacmanLocation().y * maps.get(map).X());
				}
				else if (s instanceof AStarState) {
					AStarState state = (AStarState) s;
					toDraw.enqueue(state.getPacmanLocation().x
							+ state.getPacmanLocation().y * maps.get(map).X());
				}
			}
			return toDraw;
		} else {
			System.out.println("Unable to find solution!");
			return null;
		}

	}
	
	
}
