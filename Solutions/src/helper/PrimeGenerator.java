package helper;

import io.Kattio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class PrimeGenerator {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Long> primes = new ArrayList<>(100000);
		Kattio io = new Kattio(System.in, new FileOutputStream("primes_out.txt"));
		long n = io.getLong();
		
		calc(primes, n);
		io.println(primes);
		io.close();
	}

	private static void calc(ArrayList<Long> primes, long n) {
		primes.add(2L);
		n = ((long)Math.sqrt(n)) + 1;
		for(long i = 3; i < n; i+=2) {
			boolean prime = true;
			long sq = (long)Math.sqrt(i) + 1;
			for(long p : primes) {
				if(p > sq)
					break;
				
				if(i % p == 0) {
					prime = false;
					break;
				}
			}
			if(prime)
				primes.add(i);
		}
	}
}
