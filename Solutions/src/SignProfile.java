

public class SignProfile {
	public static double dx1, dx2;
	public static double c1, c2,c3,c4;
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
		
	}

	private static boolean run(Kattio io) {
		c1 = io.getDouble();
		c2 = io.getDouble();
		c3 = io.getDouble();
		c4 = io.getDouble();
		
		if(c4 == 0)
			if(c3 == 0)
				if(c2 == 0)
					if(c1 == 0)
						return false;
					else
						one(io);
				else
					two(io);
			else
				three(io);
		else
			four(io);
		
		return true;
	}
	
	public static void four(Kattio io) {
		if(!pq(c2,c3 * 2,c4 * 3) || !isOnDifferentSides(get(dx1), get(dx2))) {
			if(c4 < 0)
				io.println("+-");
			else
				io.println("-+");
			return;
		}
		
		if(c4 < 0)
			io.println("+-+-");
		else
			io.println("-+-+");
	}
	
	public static void three(Kattio io) {
		if(!pq(c1,c2,c3)) {
			if(c3 < 0)
				io.println("-");
			else
				io.println("+");
			return;
		}
		
		if(c3 < 0)
			io.println("-+-");
		else
			io.println("+-+");
		return;
	}
	
	public static void two(Kattio io) {
		if(c2 < 0)
			io.println("+-");
		else
			io.println("-+");
	}
	
	public static void one(Kattio io) {
		if(c1 < 0)
			io.println("-");
		else
			io.println("+");
	}
	
	private static boolean isOnDifferentSides(double x1, double x2) {
		double s1 = Math.signum(x1);
		double s2 = Math.signum(x2);
		if(s1 == 0 || s2 == 0)
			return false;
		return s1 != s2;
	}
	private static double get(double x) { return c1 + c2 * x + c3 * x*x + c4 * x*x*x; }
	
	private static boolean pq(double c2, double c3, double c4) {
		double dc1 = c2;
		double dc2 = c3;
		double dc3 = c4;
		
		double p = dc2 / dc3;
		double q = dc1 / dc3;
		
		double sq = (p * p / 4) - q;
		if(sq < 0)
			return false;
		sq = Math.sqrt(sq);
		
		double middle = -p/2;
		dx1 = middle + sq;
		dx2 = middle - sq;
		return true;
	}
}
/*

-1 -3 4 -1
-1 0 -5 5
-0.2 0 1 0
0 0 0 0



*/