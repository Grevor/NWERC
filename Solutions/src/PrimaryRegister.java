
public class PrimaryRegister {
	public static final long number = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19 - 1;
	public static final long[] numbers = { 2, 3, 5,7,11,13,17,19};
	private static final long[] numberz = {1, 2, 6, 30, 210, 2310, 30030, 510510};
	public static void main(String[] args) {
		Kattio io = new Kattio();
		long n = 0;
		//long[] numberz = calc(numbers);
		for(int i = 0; i < 8; i++)
			n += io.getLong() * numberz[i];
		
		io.println(number - n);
		
		io.close();
	}
	private static long[] calc(long[] numbers2) {
		long[] ns = new long[numbers2.length];
		for(int i = 0; i < numbers2.length; i++) {
			long n = 1;
			for(int j = 0; j < i; j++)
				n *= numbers2[j];
			ns[i] = n;
		}
		return ns;
	}
}
/*
 0 0 4 6 10 12 16 18
 
 
 1 2 4 6 10 12 16 18
 
 
 
 0 0 0 0 0 0 0 0
 
*/