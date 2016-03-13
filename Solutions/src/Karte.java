import java.util.BitSet;


public class Karte {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		BitSet P = new BitSet(20);
		BitSet K = new BitSet(20);
		BitSet H = new BitSet(20);
		BitSet T = new BitSet(20);
		
		String all = io.getWord();
		for(int i = 0; i < all.length(); i += 3) {
			char suite = all.charAt(i);
			int num = (all.charAt(i + 1) - '0') * 10 + all.charAt(i + 2) - '0';
			BitSet set = null;
			switch (suite) {
			case 'P':
				set = P;
				break;
			case 'K':
				set = K;
				break;
			case 'H':
				set = H;
				break;
			case 'T':
				set = T;
				break;
				
			default:
				throw new Error();
			}
			if(set.get(num)) {
				io.println("GRESKA");
				io.close();
				System.exit(0);
			}
			set.set(num);
		}
		
		io.println(calc(P) + " " + calc(K) + " " + calc(H) + " " + calc(T));
		
		io.close();
	}

	private static int calc(BitSet h) {
		return 13 - h.cardinality();
	}
}
/*
P01K02H03H04


H02H10P11H02


P10K10H10T01


*/