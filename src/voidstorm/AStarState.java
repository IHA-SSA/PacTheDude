package voidstorm;

import tools.Graph;
import truelecter.problem_solving.*;
import truelecter.problem_solving.pacthedude.bfs.state.WorldState.Location;

public class AStarState extends State implements Comparable<AStarState> {
	private Location pacLocation;
	private Location diamondLocation;
	private Graph world;
	private boolean[] markedVertex;
	private int f, g, h;

	public AStarState(AStarState prev, Action prevAction, Location pacmanLocation, int path) {
		this(prev, prevAction, pacmanLocation, prev.diamondLocation, prev.world, path);

	}

	public AStarState(){}
	
	public AStarState(AStarState prev, Action prevAction, Location pacmanLocation, Location diamondLocation,
			Graph world, int path) {
		super(prev, prevAction);
		pacLocation = pacmanLocation;
		this.diamondLocation = diamondLocation;
		this.world = world;
		if (prev != null) {
			markedVertex = prev.markedVertex;
		} else {
			markedVertex = new boolean[world.V()];
		}
		g = path;

		h = heuristicCostEstimate(pacmanLocation, diamondLocation);
		f = h;

	}

	public int heuristicCostEstimate(Location s, Location g) {
		int res = 0;
		res += Math.abs(g.x - s.x) + Math.abs(g.y - s.y); 
		
		return res;
	}

	public int getF() {
		return f;
	}
	
	public int getG(){return g;}

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

	@Override
	public int compareTo(AStarState arg0) {
		// TODO Auto-generated method stub
		if (f < arg0.f) return 1;
		if(f > arg0.f) return -1;
		return 0;
	}

	/*public static class Location {
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
	}*/
}
