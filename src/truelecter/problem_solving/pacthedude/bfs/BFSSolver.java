package truelecter.problem_solving.pacthedude.bfs;

import java.util.ArrayList;
import java.util.Arrays;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.action.*;
import truelecter.problem_solving.pacthedude.bfs.state.*;

public class BFSSolver extends truelecter.problem_solving.BFSSolver {

    public BFSSolver(WorldState start) {
    	   super(Arrays.asList(new Action[] { new EatDiamondAction(), new MoveDownAction(), new MoveUpAction(),
                   new MoveLeftAction(), new MoveRightAction() }), start);
    }

    @Override
    public boolean goalReached(State state) {
        return state instanceof DiamondEatenState;
    }

}
