import java.util.HashSet;


public class FruitBasket {
	static HashSet<Long> taken = new HashSet<>(40 * 40* 40 * 40);
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		long total = 0;//n * (long) Math.pow(2, n - 1);
		long[] ws = new long[n];
		for(int i = 0; i < n; i++) {
			ws[i] = io.getLong();
			total += ws[i] * Math.pow(2, n - 1);
		}
		
		for(int i = 0; i < n; i++) {
			total -= getRem(ws[i], ws, getBitset(0L, i));
		}
		
		io.println(total);
		io.close();
	}


	private static long getRem(long weight, long[] ws, long bitset) {
		if(weight >= 200 || taken.contains(bitset))
			return 0;
		
		taken.add(bitset);
		long ret = weight;
		for(int i = 0; i < ws.length; i++) {
			if(get(bitset, i))
				continue;
			ret += getRem(weight + ws[i], ws, getBitset(bitset, i));
		}
		return ret;
	}


	private static boolean get(long bitset, int i) {
		return (bitset & (1L << i)) != 0;
	}


	private static long getBitset(long bitSet, int i) {
		return bitSet | (1L << i);
	}
	
}

/*

4
50 60 70 120

40
50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50 50

1099511626214000
*/