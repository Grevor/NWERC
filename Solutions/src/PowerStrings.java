import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class PowerStrings {
	public static void main(String[] args) {
		ArrayList<Integer> primes = calcPrimes(2000000);
		Kattio io = new Kattio();
		String s = io.getWord();
		while(!s.equals(".")) {
			run(s, io, primes);
			s = io.getWord();
		}
		io.close();
	}

	private static void run(String s, Kattio io, ArrayList<Integer> primes) {
		ArrayList<Integer> primeFactors = new ArrayList<>();
		HashSet<Integer> prim = new HashSet<>();
		int[] lengths;
		int length = s.length();
		
		for(int p : primes) {
			if(length % p == 0)
				primeFactors.add(p);
		}
		
		getAll(prim, primeFactors, length, 1);
		prim.add(1);
		
		lengths = new int[prim.size()];
		int ii = 0;
		for(int p : prim)
			lengths[ii++] = p;
		
		Arrays.sort(lengths);
		
		for(int i = 0; i < lengths.length; i++) {
			String sub = s.substring(0, lengths[i]);
			int l = lengths[i];
			int iters = s.length() / l;
			boolean b = true;
			for(int j = 0; j < iters; j++) {
				if(!s.regionMatches(l * j, sub, 0, l)) {
					b = false;
					break;
				}
			}
			
			if(b) {
				//We have found the smallest number (IE the greatest n)
				io.println(iters);
				return;
			}
		}
		
		io.println(1);
	}

	private static void getAll(HashSet<Integer> prim,
			ArrayList<Integer> primeFactors, int length, int f) {
		for(int p : primeFactors) {
			int num = f * p;
			if(num <= length && length % num == 0) {
				prim.add(num);
				getAll(prim, primeFactors, length, num);
			}
		}
	}
	
	

	private static ArrayList<Integer> calcPrimes(int m) {
		m = (int) Math.ceil(Math.sqrt(m));
		ArrayList<Integer> p = new ArrayList<>();
		p.add(2);
		for(int i = 3; i <= m; i += 2) {
			boolean prime = true;
			for(int pp : p)
				if(i % pp == 0) {
					prime = false;
					break;
				}
			if(prime)
				p.add(i);
		}
		return p;
	}
}

/*
abcd
aaaa
ababab
.


*/