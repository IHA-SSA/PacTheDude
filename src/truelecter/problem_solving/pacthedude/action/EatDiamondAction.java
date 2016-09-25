package truelecter.problem_solving.pacthedude.action;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.state.DiamondEatenState;
import truelecter.problem_solving.pacthedude.state.WorldState;

public class EatDiamondAction implements Action {

    @Override
    public State perform(State current) {
        return new DiamondEatenState(current, this);
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof WorldState){
            WorldState world = (WorldState) current;
            return world.getDiamondLocation().equals(world.getPacmanLocation());
        }
        return false;
    }

}
