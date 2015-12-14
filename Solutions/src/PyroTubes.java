import java.util.ArrayList;
import java.util.HashSet;

public class PyroTubes {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		HashSet<Integer> hs = new HashSet<>(250000);
		ArrayList<Integer> as = new ArrayList<>(250000);
		
		while(true) {
			int n = io.getInt();
			if(n == -1)
				break;
			
			hs.add(n);
			as.add(n);
		}
		
		for(int n : as) {
			int num = 0;
			for(int i = 0; i < 18; i++) {
				if(bit(n, i) == 0) {
					int m = flip(n, i);
					if(hs.contains(m))
						num++;
					
					num += zero(hs, m, i);
					num += all(hs, m, i, n);
				}
			}
			io.println(n + ":" + num);
		}
		io.close();
	}

	private static int all(HashSet<Integer> hs, int m, int i, int n) {
		i++;
		int c = 0;
		for(; i < 18; i++) {
			int num = flip(m, i);
			if(n < num && hs.contains(num))
				c++;
		}
		return c;
	}

	private static int zero(HashSet<Integer> hs, int m, int i) {
		int c = 0;
		for(int j = 0; j < i; j++) {
			if(bit(m, j) == 0)
				continue;
			
			int flip = flip(m, j);
			if(hs.contains(flip))
				c++;
		}
		return c;
	}

	private static int flip(int n, int i) {
		return n ^ (1 << i);
	}

	private static int bit(int n, int i) {
		return (n & (1 << i));
	}
}

/*
1
3
8
10
25
-1


2083
15093
15285
25147
31413
47797
49723
55989
58171
60085
95670
-1


*/