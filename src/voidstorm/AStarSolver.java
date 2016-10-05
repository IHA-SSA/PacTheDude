package voidstorm;


import java.util.List;
import java.util.Queue;

import truelecter.problem_solving.Action;
import truelecter.problem_solving.Solver;
import truelecter.problem_solving.State;

public abstract class AStarSolver extends Solver {

	public AStarSolver(Iterable<Action> actions, State start) {
        super(actions, start);
    }

    @Override
    public double price(Queue<State> route) {
        return route.size();
    }
    int kek = 0;
    @Override
    public abstract boolean goalReached(State state);

    @Override
    public State solve() {

        MinPQ<State> states = new MinPQ<>(); //openSet
        states.insert(currentState);

        State finish = null;
        long totalActions = 0;
        int glmin = 999;

        while (!states.isEmpty()) {
            totalActions++;
            AStarState current = (AStarState)states.delMin();
            if(current != null) finish = current;
            if (goalReached(current)) {
                finish = current;
                break;
            }
            List<State> newStates = performActions(current);
            AStarState lcmin = current;
            for (State state : newStates) {
            	if(state instanceof AStarState){
            		if(glmin >= ((AStarState)state).getF()){
            			lcmin = ((AStarState)state);
            			glmin = ((AStarState)state).getF();
            		}
            			states.insert(lcmin);
            	}
            }	
        }
        System.out.println(totalActions);
        return finish;
    }

}
