package xolmes;

import tools.Graph;
import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.BFSSolver;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState.Location;
import voidstorm.LinkedQueue;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World w = new World();
		w.start();
		Graph world = new Graph("labirinth_test.txt");
        Location pacmanLocation = new Location(0, 18);
        Location diamondLocation = new Location(16, 0);
        WorldState startingState = new WorldState(null, null, pacmanLocation, diamondLocation, world);
        
       
	   
        Solver solver = new BFSSolver(startingState);
        State finish = solver.solve();

        if (finish != null) {
            System.out.println("Solution found!");
            LinkedQueue<State> path = BFSSolver.path(finish);
            System.out.println(path.size());
            LinkedQueue<Integer> toDraw = new LinkedQueue<>();
            for (State s : path) {
                if (s instanceof WorldState) {
                    WorldState state = (WorldState) s;
                    toDraw.enqueue(state.getPacmanLocation().x + state.getPacmanLocation().y * world.X());
                }
            }
            w.visualize(toDraw, world, pacmanLocation.x, pacmanLocation.y, diamondLocation.x, diamondLocation.y);
        } else {
            System.out.println("Unable to find solution!");
        }
		
	}

}
