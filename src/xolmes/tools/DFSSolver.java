package xolmes.tools;

import java.util.ArrayList;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.DiamondEatenState;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState;

public class DFSSolver extends truelecter.problem_solving.DFSSolver {

    public DFSSolver(WorldState start, ArrayList<Action> list) {
        super(list , start);
    }

    @Override
    public boolean goalReached(State state) {
        return state instanceof DiamondEatenState;
    }

}