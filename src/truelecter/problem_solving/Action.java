package truelecter.problem_solving;

public interface Action {
    public State perform(State current);
    public boolean applicable(State current);
}
