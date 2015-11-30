
public class CandyDistribution {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		int t = io.getInt();
		for (int tt = 0; tt < t; tt++) {
			int k = io.getInt();
			int c = io.getInt();
			try {
				if (c == 1) {
					if (k < 10e9) {
						io.println(k+1);
						continue;
					}
				}
				else {
					long y = gcdRevy(c,k);
					if (y <= 1000000000) {
						io.println(y);
						continue;
					}
				}
			} 
			catch(RuntimeException e) {}
			io.println("IMPOSSIBLE");
		}
		io.close();
		// 1 = c*y - k*x
		//solve(10,7);
		//solve(37,10);
		//solve(37,10);
		//solve(7,10);
		//solve(23,1337);
		//solve(42,123454321);
		//solve(999999937, 142857133);
	}
	
	static void solve(int a, int b) {
		System.out.println("1 = "+a+"*"+gcdRevy(a,b)+"-"+b+"*"+gcdRevx(a, b));
	}
	
	
	
	/**
	 * Solves 1 = a*y-b*x and returns y
	 * @param a
	 * @param b
	 * @return y
	 */
	static long gcdRevy(long a, long b) {
		long r = a % b;
		if (r == 1)
			return 1;
		if (r == 0) {
			throw new RuntimeException();
		}
		long yprim = gcdRevy(b, r);
		long xprim = (b*yprim - 1) / r;
		return b - xprim;
	}
	
	/**
	 * Solves 1 = a*y-b*x and returns x
	 * @param a
	 * @param b
	 * @return x
	 */
	static long gcdRevx(long a, long b) {
		long r = a % b;
		if (r == 1)
			return a/b;
		if (r == 0) {
			throw new RuntimeException();
		}
		long xprim = gcdRevx(b, r);
		long yprim = (1 + r*xprim) / b;
		return a - (yprim +(a/b)*xprim);
	}
	
	// 37 = 10 * 3 + 7 
	// 10 = 7 * 1 + 3
	// 7 = 3 * 2 + 1
	// 3 = 1 * 3 + 0
	
	// 1 = 7*1 - 3*2
	// 1 = 7*1 - (10 - 7*1)*2 = 7*3 - 10*2 = 10*(-2) - 7*(-3) = 10*5 - 7*7
	// 1 = 10*5 - (37 - 10*3)*7 = 10 * 26 - 37 * 7 = 37 * (-7) - 10 * (-26) = 37 * 3 - 10 * 11 
	
}

/*
5
10 5
10 7
1337 23
123454321 42
999999937 142857133
*/