//package voidstorm;
//
//import java.util.Comparator;
//import java.util.Stack;
//
//import tools.Graph;
//
//public class AStar {
//	private AStarState start, goal;
//	private boolean[] marked;
//	private MinPQ<AStarState> openSet;
//	private LinkedQueue<AStarState> path;
//	private Graph g;
//	private boolean hasPath = true;
//	
//	public AStar (AStarState start, AStarState goal, Graph world){
//		this.start = start;
//		this.goal = goal;
//		marked = new boolean[world.V()];
//		g = world;
//		path = new LinkedQueue<AStarState>();
//		openSet = new MinPQ<AStarState>(world.V(), new Comparator<AStarState>(){
//
//			@Override
//			public int compare(AStarState arg0, AStarState arg1) {
//				// TODO Auto-generated method stub
//				if (arg0.f < arg1.f) return -1;
//				if( arg0.f > arg1.f) return 1;
//				return 0;
//			}
//			
//		});
//	
//		astar();
//	}
//
//	private void astar() {
//		// TODO Auto-generated method stub
//		marked[start.p] = true;
//		start.g = 0;
//		start.h = heuristicCostEstimate(start.p, goal.p);
//		start.f = start.g + start.h;
//		
//		openSet.insert(start);
//		
//		while(!openSet.isEmpty()){
//			AStarState x = openSet.min();
//			if (x == goal) return;
//			
//			openSet.delMin();
//			marked[x.p] = true;
//			for(int y : g.adj(x.p)){
//				if (marked[y]) continue;
//				
//				int tentative_g_score = x.g + 1;
//
//				AStarState kek = null;
//				boolean has = false;
//				for(AStarState check : openSet){
//					if(check.p == y){
//						kek = check; 
//						has = true;
//						break;
//					}
//				}
//				
//				boolean tentative_is_better = true;
//				if(!has) {
//					kek = new AStarState(y, heuristicCostEstimate(y, goal.p), tentative_g_score);
//					openSet.insert(kek);
//				}
//				else {
//					if(tentative_g_score >  kek.g)
//						tentative_is_better = false;
//				}
//				
//				if(tentative_is_better){
//					kek.parent = x;
//					
//				}
//			}
//		}
//		
//	}
//	
//	public AStarState getFinish(){return goal;}
//	
//	public static Stack<Integer> getPath(AStarState start, AStarState finish){
//		Stack<Integer> path = new Stack<>();
//		AStarState cur = finish;
//		while (cur != null){
//			path.push(cur.p);
//			cur = cur.parent;
//		}
//		return path;
//	}
//	
//	private int heuristicCostEstimate(int s, int g){
//		int res = 0;
//		
//		return res;
//	}
//	
//	
//	
//}
