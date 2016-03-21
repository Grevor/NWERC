

public class ImThinkingOfANumber {
	static final String lt = "less than";
	static final String gt = "greater than";
	static final String div = "divisible by";
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0)
			return false;
		long max = Long.MAX_VALUE;
		long min = 0;
		long divisor = 1;
		
		for(int i = 0; i < n; i++) {
			String s = io.getWord() + " " + io.getWord();
			long number = io.getLong();
			switch(s) {
			case lt:
				max = Math.min(number, max);
				break;
			case gt:
				min = Math.max(min, number);
				break;
			case div:
				long gcd = GCD(Math.max(divisor, number), Math.min(divisor, number));
				number /= gcd;
				divisor *= number;
				break;
			}
		}
		
		if(max == Long.MAX_VALUE) {
			io.println("infinite");
			return true;
		}
		
		min++;
		
		int num = 0;
		for(long i = min % divisor == 0 ? min : ((min / divisor) + 1) * divisor; i < max; i += divisor) {
			if(num != 0)
				io.print(' ');
			io.print(i);
			num++;
		}
		
		io.println(num == 0 ? "none" : "");
		return true;
	}
	
	static long GCD(long a, long b) {
		return b == 0 ? a : GCD(b, a%b);
	}
	
}
/*


3
less than 100
divisible by 3
divisible by 7
3
greater than 6
less than 9
divisible by 3
3
divisible by 1
greater than 6
greater than 500
3
less than 101
divisible by 10
divisible by 25
2
less than 10
divisible by 1
1
less than 10
0



*/