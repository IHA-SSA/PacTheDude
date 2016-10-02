package voidstorm.solver;

import java.util.Arrays;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.DiamondEatenState;
import voidstorm.AStarSolver;
import voidstorm.AStarState;
import voidstorm.actions.*;

public class AstarSolver extends AStarSolver {

	public AstarSolver(State start) {
		super(Arrays.asList(new Action[] { new EatDiamondAction(), new MoveDownAction(), new MoveUpAction(),
                new MoveLeftAction(), new MoveRightAction() }), start);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean goalReached(State state) {
		return state instanceof DiamondEatenState;
	}

	

}
