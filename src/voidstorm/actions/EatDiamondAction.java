package voidstorm.actions;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.DiamondEatenState;
import voidstorm.AStarState;

public class EatDiamondAction implements Action {

    @Override
    public State perform(State current) {
        return new DiamondEatenState(current, this);
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof AStarState){
            AStarState world = (AStarState) current;
            return world.getDiamondLocation().equals(world.getPacmanLocation());
        }
        return false;
    }

}
