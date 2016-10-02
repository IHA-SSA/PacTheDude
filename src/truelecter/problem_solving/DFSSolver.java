package truelecter.problem_solving;

import java.util.List;
import java.util.Queue;

import tools.LinkedStack;
import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;

public abstract class DFSSolver extends Solver {

    public DFSSolver(Iterable<Action> actions, State start) {
        super(actions, start);
    }

    @Override
    public double price(Queue<State> route) {
        return route.size();
    }

    @Override
    public abstract boolean goalReached(State state);

    @Override
    public State solve() {
        LinkedStack<State> states = new LinkedStack<>();
        states.push(currentState);

        State finish = null;
        long totalActions = 0;

        while (!states.isEmpty()) {
            totalActions++;
            State current = states.pop();
            if (goalReached(current)) {
                finish = current;
                break;
            }
            List<State> newStates = performActions(current);
            for (State state : newStates) {
                states.push(state);
            }
        }
        System.out.println(totalActions);
        return finish;
    }

}
