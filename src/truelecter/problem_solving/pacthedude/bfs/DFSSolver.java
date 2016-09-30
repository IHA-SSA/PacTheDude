package truelecter.problem_solving.pacthedude.bfs;

import java.util.List;
import java.util.Queue;

import tools.LinkedStack;
import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.action.*;
import truelecter.problem_solving.pacthedude.bfs.state.*;

public class DFSSolver extends Solver {

    public DFSSolver(WorldState start) {
        super(start);
    }

    @Override
    public double price(Queue<State> route) {
        return route.size();
    }

    @Override
    public boolean goalReached(State state) {
        return state instanceof DiamondEatenState;
    }

    @Override
    public State solve() {
        addAction(new EatDiamondAction());
        addAction(new MoveDownAction());
        addAction(new MoveUpAction());
        addAction(new MoveLeftAction());
        addAction(new MoveRightAction());

        LinkedStack<State> worldStates = new LinkedStack<>();
        worldStates.push(currentState);

        State finish = null;
        long totalActions = 0;
        
        while (!worldStates.isEmpty()) {
            totalActions++;
            State current = worldStates.pop();
            if (goalReached(current)) {
                finish = current;
                break;
            }
            List<State> states = performActions(current);
            for (State state : states) {
                worldStates.push(state);
            }
        }
        System.out.println(totalActions);
        return finish;
    }

}
