package truelecter.problem_solving;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import voidstorm.LinkedQueue;

//http://cs.lmu.edu/~ray/notes/problemsolving/
public abstract class Solver {
    // Current state
    protected State currentState;

    // Set of states
    // Do we need it?
    // private Set<State> states = new HashSet<>();

    // Set of actions
    private Set<Action> actions = new HashSet<>();

    public Solver(State start) {
        this.currentState = start;
    }

    protected void addAction(Action a) {
        actions.add(a);
    }

    // Path cost function
    public abstract double price(Queue<State> route);

    // Goal test function
    public abstract boolean goalReached(State state);

    public static LinkedQueue<State> path(State finishing) {
        LinkedQueue<State> path = new LinkedQueue<>();
        path.enqueue(finishing);
        while (finishing != null) {
            path.enqueue(finishing.getPreviousState());
            finishing = finishing.getPreviousState();
        }
        return path;
    }

    public abstract State solve();

    public State getCurrentState() {
        return currentState;
    }

    /**
     * Performs all applicable actions to current state
     * 
     * @return List of possible states
     */
    public List<State> performActions(State state) {
        List<State> res = new LinkedList<>();
        for (Action a : actions) {
            if (a != null && a.applicable(state)) {
                res.add(a.perform(state));
            }
        }
        return res;
    }

}