import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;


public class Subway {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		ArrayList<ArrayList<Point>> lines = new ArrayList<>();
		Point house = new Point(io.getDouble(), io.getDouble());
		Point school = new Point(io.getDouble(), io.getDouble());
		
		int points = 2;
		
		while(io.hasMoreTokens()) {
			ArrayList<Point> line = new ArrayList<>();
			while(true) {
				double x = io.getDouble();
				double y = io.getDouble();
				if(x == -1 && y == -1)
					break;
				line.add(new Point(x, y));
				points++;
			}
			lines.add(line);
		}
		
		double edges[][] = new double[points][points];
		for(int j = 0; j < points; j++)
			for(int k = 0; k < points; k++) {
				edges[j][k] = Double.MAX_VALUE;
			}
		HashMap<Point, Integer> pim = new HashMap<>();
		HashMap<Integer, Point> ipm = new HashMap<>();
		
		pim.put(house, 0);
		pim.put(school, 1);
		ipm.put(0,  house);
		ipm.put(1,  school);
		
		int i = 2;
		ArrayList<Point> all = new ArrayList<>();
		
		for(ArrayList<Point> l : lines) {
			for(Point p : l) {
				int ind = i++;
				pim.put(p, ind);
				ipm.put(ind, p);
				all.add(p);
			}
		}
		// house/school to all others.
		for(Point p : all) {
			double distH = dist(house.x, house.y, p.x,p.y)/10 * 3.6;
			double distS = dist(school.x, school.y, p.x,p.y)/10 * 3.6;
			edges[0][pim.get(p)] = distH;
			edges[pim.get(p)][0] = distH;
			edges[1][pim.get(p)] = distS;
			edges[pim.get(p)][1] = distS;
		}
		//school<->house
		double distHS = dist(house.x, house.y, school.x, school.y) / 10 * 3.6;
		edges[0][1] = distHS;
		edges[1][0] = distHS;
		
		// subway (faster)
		for(ArrayList<Point> l : lines) {
			Point prev = null;
			for(Point p : l) {
				if(prev == null) {
					prev = p;
					continue;
				}
				Point jp = prev;
				Point kp = p;
				int ij = pim.get(jp);
				int ik = pim.get(kp);
				
				double dist = dist(jp.x, jp.y, kp.x, kp.y)/40 * 3.6;
				
				edges[ij][ik] = dist;
				edges[ik][ij] = dist;
				prev = p;
			}
		}
		//all other connections(walk)
		for(int j = 0; j < points; j++)
			for(int k = 0; k < points; k++) {
				if(j == k || edges[j][k] != Double.MAX_VALUE)
					continue;
				
				Point jp = ipm.get(j);
				Point kp = ipm.get(k);
				double dist = dist(jp.x, jp.y, kp.x, kp.y)/10 * 3.6;
				
				edges[j][k] = dist;
				edges[k][j] = dist;
				
			}

		double seconds = dijkstra(edges);
		seconds /= 60;
		seconds = Math.round(seconds);
		io.println((long)seconds);
		io.close();
	}
	
	private static double dijkstra(double[][] edges) {
		double[] dist = new double[edges[0].length];
		boolean visited[] = new boolean[dist.length];
		for(int i = 0; i < dist.length; i++)
			dist[i] = Double.MAX_VALUE;
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		dist[0] = 0;
		queue.add(new Node(0, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int n = node.node;
			if(n == 1)
				return dist[1];
			
			if(visited[n])
				continue;
			
			visited[n] = true;
			for(int i = 1; i < dist.length; i++) {
				if(visited[i])
					continue;
				double altDist = dist[n] + edges[n][i];
				if(altDist < dist[i]) {
					queue.add(new Node(i, altDist));
					dist[i] = altDist;
				}
			}
		}
		throw new Error();
	}

	static double dist(double x, double y, double a, double b) {
		a = a - x;
		b = b - y;
		return Math.sqrt(a*a + b*b);
	}
	
	private static class Point {
		public double x,y;
		public Point(double x, double y) {
			this.x = x; this.y = y;
		}
	}
	
	private static class Node implements Comparable<Node> {
		public int node;
		double cost;
		public Node(int node, double cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(cost, o.cost);
		}
		
		
	}
}


/*
0 0 10000 1000
0 200 5000 200 7000 200 -1 -1
2000 600 5000 600 10000 600 -1 -1

0 0 50 50
10000 100000 100 100 -1 -1
1000 10000 100 100 -1 -1
1000 10000 100 100 -1 -1

 */
