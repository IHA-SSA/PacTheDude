package voidstorm.actions;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import voidstorm.AStarState;
import xolmes.WorldUtils;

public class MoveRightAction implements Action {

	@Override
    public State perform(State current) {
        if (!(current instanceof AStarState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        AStarState state = (AStarState) current;
        state.mark(state.getPacmanLocation().right());
        return new AStarState(state, this, state.getPacmanLocation().right(), state.getG()+1);
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof AStarState) {
            AStarState world = (AStarState) current;
            return WorldUtils.rightIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y)
                    && !world.marked(world.getPacmanLocation().right());
        }
        return false;
    }
}
