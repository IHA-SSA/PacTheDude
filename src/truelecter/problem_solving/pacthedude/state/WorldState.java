package truelecter.problem_solving.pacthedude.state;

import tools.Graph;
import truelecter.problem_solving.Action;
import truelecter.problem_solving.State;

public class WorldState extends State {
    private Location pacLocation;
    private Location diamondLocation;
    private Graph world;
    private boolean[] markedVertex;

    public WorldState(WorldState prev, Action prevAction, Location pacmanLocation) {
        this(prev, prevAction, pacmanLocation, prev.diamondLocation, prev.world);
    }

    public WorldState(WorldState prev, Action prevAction, Location pacmanLocation, Location diamondLocation,
            Graph world) {
        super(prev, prevAction);
        pacLocation = pacmanLocation;
        this.diamondLocation = diamondLocation;
        this.world = world;
        if (prev != null) {
            markedVertex = prev.markedVertex;
        } else {
            markedVertex = new boolean[world.V()];
        }
    }

    public Location getPacmanLocation() {
        return pacLocation;
    }

    public Location getDiamondLocation() {
        return diamondLocation;
    }

    public Graph getWorld() {
        return world;
    }

    public boolean marked(int x, int y) {
        return markedVertex[x + y * world.X()];
    }

    public boolean marked(Location l) {
        return marked(l.x, l.y);
    }

    public void mark(int x, int y) {
        markedVertex[x + y * world.X()] = true;
    }

    public void mark(Location l) {
        mark(l.x, l.y);
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
