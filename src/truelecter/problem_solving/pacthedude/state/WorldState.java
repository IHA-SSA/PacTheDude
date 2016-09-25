package truelecter.problem_solving.pacthedude.state;

import tools.Graph;
import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;

public class WorldState extends State {
    private Location pacLocation;
    private Location diamondLocation;
    private Graph world;

    public WorldState(WorldState prev, Action prevAction, Location pacmanLocation){
        this(prev, prevAction, pacmanLocation, prev.diamondLocation, prev.world);
    }
    
    public WorldState(WorldState prev, Action prevAction, Location pacmanLocation, Location diamondLocation, Graph world) {
        super(prev, prevAction);
        pacLocation = pacmanLocation;
        this.diamondLocation = diamondLocation;
        this.world = world;
    }

    public Location getPacmanLocation() {
        return pacLocation;
    }

    public Location getDiamondLocation() {
        return diamondLocation;
    }
    
    public Graph getWorld(){
        return world;
    }

    public static class Location {
        public int x, y;

        public Location() {
            this(0, 0);
        }

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Location left() {
            return new Location(x - 1, y);
        }

        public Location right() {
            return new Location(x + 1, y);
        }

        public Location up() {
            return new Location(x, y - 1);
        }

        public Location down() {
            return new Location(x, y + 1);
        }

        public boolean equals(Location l) {
            return l.x == x && l.y == y;
        }
    }
}
