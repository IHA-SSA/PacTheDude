package xolmes.checkers.actions;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState;
import xolmes.WorldUtils;

public class MoveUpLeft implements Action{

	@Override
    public State perform(State current) {
        if (!(current instanceof WorldState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        WorldState state = (WorldState) current;
        state.mark(state.getPacmanLocation().upLeft());
        return new WorldState(state, this, state.getPacmanLocation().upLeft());
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof WorldState) {
            WorldState world = (WorldState) current;
            return WorldUtils.upLeftIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y)
                    && !world.marked(world.getPacmanLocation().upLeft());
        }
        return false;
    }

}
