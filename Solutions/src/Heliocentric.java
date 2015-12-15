
public class Heliocentric {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int c = 1;
		while(io.hasMoreTokens())
			run(io, c++);
		
		io.close();
	}

	private static void run(Kattio io, int c) {
		final int md = 687;
		final int ed = 365;
		int e = io.getInt();
		int m = io.getInt();
		int de = ed - e;
		int dm = md - m;
		
		de %= ed;
		dm %= md;
		
		long days = 0;
		if(de > dm) {
			days +=dm;
			while((e + days) % ed != 0 || (m + days) % md != 0)
				days += md;
		} else {
			days +=de;
			while((e + days) % ed != 0 || (m + days) % md != 0)
				days += ed;
		}
		
		io.println("Case " + c + ": " + days);
	}
}

/*
0 0
364 686
360 682
0 1
1 0


*/