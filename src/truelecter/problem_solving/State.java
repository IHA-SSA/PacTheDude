package truelecter.problem_solving;

public abstract class State {
    private State prev;
    private Action lastAction;
    
    public State(){
        this(null, null);
    }
    
    public State(State previous, Action lastAction){
        prev = previous;
        this.lastAction = lastAction;
    }
    
    public State getPreviousState(){
        return prev;
    }
    
    //Last performed action
    public Action getLastAction(){
        return lastAction;
    }
    
}
