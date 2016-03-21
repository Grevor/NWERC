
public class TheEasiestProblem {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0) return false;
		int m = 11;
		int sum = digitSum(n);
		for(int i = 11; i <= 100; i++) {
			if(sum == digitSum(n * i)) { m = i; break; }
		}
		io.println(m);
		return true;
	}
	
	static int digitSum(int n) {
		int s = 0;
		while(n > 0) {
			s += n % 10;
			n /= 10;
		}
		return s;
	}
}
