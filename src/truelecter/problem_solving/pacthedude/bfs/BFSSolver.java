package truelecter.problem_solving.pacthedude.bfs;

import java.util.List;
import java.util.Queue;

import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.bfs.action.*;
import truelecter.problem_solving.pacthedude.bfs.state.*;
import voidstorm.LinkedQueue;

public class BFSSolver extends Solver {

    public BFSSolver(WorldState start) {
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

    public static LinkedQueue<State> path(State finishing) {
        LinkedQueue<State> path = new LinkedQueue<>();
        path.enqueue(finishing);
        while (finishing != null) {
            path.enqueue(finishing.getPreviousState());
            finishing = finishing.getPreviousState();
        }
        return path;
    }

    @Override
    public State solve() {
        addAction(new EatDiamondAction());
        addAction(new MoveDownAction());
        addAction(new MoveUpAction());
        addAction(new MoveLeftAction());
        addAction(new MoveRightAction());

        LinkedQueue<State> worldStates = new LinkedQueue<>();
        worldStates.enqueue(currentState);

        State finish = null;
        long totalActions = 0;
        
        while (!worldStates.isEmpty()) {
            totalActions++;
            State current = worldStates.dequeue();
            if (goalReached(current)) {
                finish = current;
                break;
            }
            List<State> states = performActions(current);
            for (State state : states) {
                worldStates.enqueue(state);
            }
        }
        System.out.println(totalActions);
        return finish;
    }

}
