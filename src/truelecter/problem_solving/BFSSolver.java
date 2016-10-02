package truelecter.problem_solving;

import java.util.List;
import java.util.Queue;

import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;
import voidstorm.LinkedQueue;

public abstract class BFSSolver extends Solver {

    public BFSSolver(Iterable<Action> actions, State start) {
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

        LinkedQueue<State> states = new LinkedQueue<>();
        states.enqueue(currentState);

        State finish = null;
        long totalActions = 0;

        while (!states.isEmpty()) {
            totalActions++;
            State current = states.dequeue();
            if (goalReached(current)) {
                finish = current;
                break;
            }
            List<State> newStates = performActions(current);
            for (State state : newStates) {
                states.enqueue(state);
            }
        }
        System.out.println(totalActions);
        return finish;
    }

}
