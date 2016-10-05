package voidstorm.actions;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import voidstorm.AStarState;
import xolmes.WorldUtils;

public class MoveLeftAction implements Action {

    @Override
    public State perform(State current) {
        if (!(current instanceof AStarState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        AStarState state = (AStarState) current;
        state.mark(state.getPacmanLocation().left());
        return new AStarState(state, this, state.getPacmanLocation().left(), state.getG()+1);
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof AStarState) {
            AStarState world = (AStarState) current;
            return WorldUtils.leftIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y)
                    && !world.marked(world.getPacmanLocation().left());
        }
        return false;
    }

}
