package xolmes.tools;

import java.util.ArrayList;
import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.*;

public class BFSSolver extends truelecter.problem_solving.BFSSolver {

    public BFSSolver(WorldState start, ArrayList<Action> list) {
    	   super(list, start);
    }

    @Override
    public boolean goalReached(State state) {
        return state instanceof DiamondEatenState;
    }

}
