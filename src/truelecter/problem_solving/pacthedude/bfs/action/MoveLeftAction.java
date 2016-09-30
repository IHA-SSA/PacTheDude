package truelecter.problem_solving.pacthedude.bfs.action;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState;
import xolmes.WorldUtils;

public class MoveLeftAction implements Action {

    @Override
    public State perform(State current) {
        if (!(current instanceof WorldState)) {
            throw new IllegalArgumentException("Can't move not in world");
        }
        WorldState state = (WorldState) current;
        state.mark(state.getPacmanLocation().left());
        return new WorldState(state, this, state.getPacmanLocation().left());
    }

    @Override
    public boolean applicable(State current) {
        if (current instanceof WorldState) {
            WorldState world = (WorldState) current;
            return WorldUtils.leftIsClear(world.getWorld(), world.getPacmanLocation().x, world.getPacmanLocation().y)
                    && !world.marked(world.getPacmanLocation().left());
        }
        return false;
    }

}
