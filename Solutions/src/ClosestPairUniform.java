import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;


public class ClosestPairUniform {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		while(run(io))
			;
		
		io.close();
	}
	public static boolean run(Kattio io) {
		
		int n = io.getInt();
		if(n == 0)
			return false;
		QT tree = new QT(n);
		ArrayList<Double> points = new ArrayList<>(n);
		for(int i = 0; i < n; i++) {
			Double p = new Double(io.getDouble(), io.getDouble());
			points.add(p);
			tree.add(p);
		}
		
		Double p1 = null;
		Double p2 = null;
		double dist = java.lang.Double.POSITIVE_INFINITY;
		
		for(Double s : points) {
			Double p = tree.findClosest(s);
			double d = s.distance(p);
			if(dist > d) {
				p1 = s;
				p2 = p;
				dist = d;
			}
		}
		
		io.println(p1.x + " " + p1.y + " " + p2.x + " " + p2.y);
		return true;
	}
	
	private static class QT {
		int xx, yy;
		N[][] bins;
		double size = 1 / 200;
		static final double shift = 100000;
		
		public void add(Double p) {
			double x = p.x + shift;
			double y = p.y + shift;
			int binx = (int) (x * size);
			int biny = (int) (y * size);
			if(bins[binx][biny] == null)
				bins[binx][biny] = new N();
			bins[binx][biny].points.add(p);
		}
		
		public QT(int n ) {
			double factor = n / 100000.0;
			xx = (int) Math.ceil(Math.sqrt(1000000 * factor));
			yy = xx;
			size = xx / 200000.0;
			bins = new N[xx][yy];
			//for(int i = 0; i < xx; i++)
			//	for(int j = 0; j < yy; j++)
			//		bins[i][j] = new N();
		}
		
		public Point2D.Double findClosest(Double p) {
			double x = p.x + shift;
			double y = p.y + shift;
			int binx = (int) (x * size);
			int biny = (int) (y * size);
			
			Double point = findClosest(p, binx, biny);
			Double p2 = findClosestCircle(p, binx, biny, 1);
			
			if(point == null && p2 == null) {
				int i = 2;
				while(point == null) {
					point = findClosestCircle(p, binx, biny, i);
					i++;
				}
				return point;
			} 
			
			return point == null ? p2 : point;
			
		}
		

		private Double findClosestCircle(Double p, int binx, int biny, int i) {
			int x1 = binx - i;
			int x2 = binx + i;
			int y1 = biny - i;
			int y2 = biny + i;
			
			Double point = null;
			double dist = java.lang.Double.POSITIVE_INFINITY;
			
			if(isInRange(y1))
				for(int x = Math.max(0, x1); x < Math.min(xx, x2); x++) {
					Double n = findClosest(p, y1, x);
					if(n == null)
						continue;
					double d = n.distance(p);
					if(dist >d) {
						point = n;
						dist = d;
					}
				}
			
			if(isInRange(y2))
				for(int x = Math.max(0, x1); x < Math.min(xx, x2); x++) {
					Double n = findClosest(p, y2, x);
					if(n == null)
						continue;
					double d = n.distance(p);
					if(dist >d) {
						point = n;
						dist = d;
					}
				}
			
			if(isInRange(x1))
				for(int y = Math.max(0, y1); y < Math.min(yy, y2); y++) {
					Double n = findClosest(p, y, x1);
					if(n == null)
						continue;
					double d = n.distance(p);
					if(dist >d) {
						point = n;
						dist = d;
					}
				}
			
			if(isInRange(x2))
				for(int y = Math.max(0, y1); y < Math.min(yy, y2); y++) {
					Double n = findClosest(p, y, x2);
					if(n == null)
						continue;
					double d = n.distance(p);
					if(dist >d) {
						point = n;
						dist = d;
					}
				}
			
			return point;
		}

		private boolean isInRange(int y1) {
			return 0 <= y1 && y1 < yy;
		}

		private Double findClosest(Double p, int binx, int biny) {
			Double n = null;
			double dist = java.lang.Double.POSITIVE_INFINITY;
			if(bins[binx][biny] == null)
				return null;
			
			for(Double pp : bins[binx][biny].points) {
				if(pp == p)
					continue;
				double d = pp.distanceSq(p);
				if(dist > d) {
					dist = d;
					n = pp;
				}
			}
			return n;
		}
	}
	private static class N {
		ArrayList<Double> points = new ArrayList<>();
	}
}

/*

2
1.12 0
0 0.51
3
158 12
123 15
1859 -1489
3
21.12 -884.2
18.18 43.34
21.12 -884.2
0


*/