package truelecter.problem_solving.pacthedude;

import acm.program.GraphicsProgram;
import tools.Graph;
import truelecter.problem_solving.State;
import truelecter.problem_solving.pacthedude.state.WorldState;
import truelecter.problem_solving.pacthedude.state.WorldState.Location;
import voidstorm.LinkedQueue;
import xolmes.World;

public class BFSSolverVisualizer extends GraphicsProgram {
    
    public void run() {
        Graph world = new Graph("labirinth_test.txt");
        Location pacmanLocation = new Location(0, 9);
        Location diamondLocation = new Location(0, 5);
        WorldState startingState = new WorldState(null, null, pacmanLocation, diamondLocation, world);

        BFSSolver solver = new BFSSolver(startingState);
        State finish = solver.solve();
        
        if (finish != null) {
            System.out.println("Solution found!");
            LinkedQueue<State> path = BFSSolver.path(finish);
            System.out.println(path.size());
            
            LinkedQueue<Integer> toDraw = new LinkedQueue<>();
            for (State s : path) {
                if (s instanceof WorldState) {
                    WorldState state = (WorldState) s;
                    toDraw.enqueue(state.getPacmanLocation().x + state.getPacmanLocation().y * world.X());
                }
            }

            World w = new World();
            w.visualize(toDraw, world, pacmanLocation.x, pacmanLocation.y, diamondLocation.x, diamondLocation.y);
        } else {
            System.out.println("Unable to find solution!");
        }
    }

}
