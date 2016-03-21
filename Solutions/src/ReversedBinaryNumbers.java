
public class ReversedBinaryNumbers {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int number = io.getInt();
		int high = highestOneBit(number);
		int rev = 0;
		for(int i = 0; i <= high; i++) {
			rev |= ((number & (1 << i)) >> i) << (high - i);
		}
		
		io.println(rev);
		io.close();
	}

	private static int highestOneBit(int number) {
		for(int i = 31; i >= 0; i--)
			if((number & (1 << i)) != 0) return i;
		
		return 0;
	}
}
