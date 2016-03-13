import java.util.ArrayDeque;
import java.util.BitSet;


public class Beacons {
	public static int[] bx;
	public static int[] by;
	public static int[] mx;
	public static int[] my;
	public static int[] mr;
	
	public static int[] graph;
	public static BitSet connected;
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		int m = io.getInt();
		
		bx = new int[n];
		by = new int[n];
		
		mx = new int[m];
		my = new int[m];
		mr = new int[m];
		
		for(int i = 0; i < n; i++){
			bx[i] = io.getInt();
			by[i] = io.getInt();
		}
		
		for(int i = 0; i < m; i++){
			mx[i] = io.getInt();
			my[i] = io.getInt();
			int r = io.getInt();
			mr[i] = r * r;
		}
		
		connected = new BitSet(n * n);
		graph = new int[n];
		
		ArrayDeque<Integer> points = new ArrayDeque<>();
		int graphs = 0;
		for(int i = 0; i < n; i++)
			points.add(i);
		while(!points.isEmpty()) {
			int p = points.pop();
			if(graph[p] == 0) {
				graphs++;
				graph[p] = graphs;
			}
			
			for(int i = 0; i < n; i++){
				if(graph[i] != 0)
					continue;
				
				if(canSee(p,i)) {
					graph[i] = graphs;
					points.push(i);
				}
			}
		}
		
		io.println(graphs - 1);
		
		io.close();
	}
	

//	private static int getIndex(int gn, int i, int j) {
//		return gn * j + i;
//	}


	public static boolean canSee(int b1, int b2) {
		int b1x = bx[b1];
		int b1y = by[b1];
		int b2x = bx[b2];
		int b2y = by[b2];
		for(int m = 0; m < mx.length; m++){
			float dist = getPointLineSegmentDist(mx[m], my[m], b1x, b1y, b2x, b2y);
			if(dist < mr[m])
				return false;
		}
		return true;
	}
	
	public static float getPointLineSegmentDist(float x, float y, float x1, float y1, float x2, float y2) {
		  float A = x - x1;
		  float B = y - y1;
		  float C = x2 - x1;
		  float D = y2 - y1;

		  float dot = A * C + B * D;
		  float len_sq = C * C + D * D;
		  float param = -1;
		  if (len_sq != 0) //in case of point instead of valid line segment.
		      param = dot / len_sq;

		  float xx, yy;

		  if (param < 0) { // If projected outside the segment closest to the first endpoint.
		    xx = x1;
		    yy = y1;
		  }
		  else if (param > 1) { // If projected outside the segment closest to the second endpoint.
		    xx = x2;
		    yy = y2;
		  }
		  else { // Projected on the segment, find closest.
		    xx = x1 + param * C;
		    yy = y1 + param * D;
		  }

		  float dx = x - xx;
		  float dy = y - yy;
		  return dx * dx + dy * dy;
	}
}


/*
6 3
1 8
5 4
7 7
9 2
16 6
17 10
4 7 2
6 3 1
12 6 3


4 4
0 4
8 4
4 0
4 8
2 2 1
6 2 1
2 6 1
6 6 1

*/