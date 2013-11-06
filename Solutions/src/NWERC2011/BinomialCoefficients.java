package NWERC2011;
import io.Kattio;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 * @author David
 */
public class BinomialCoefficients {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		int nTestCases = io.getInt();
		LinkedList<Coefficient> solutions = new LinkedList<Coefficient>();
		for (int i = 0; i < nTestCases; i++) {
			long m = io.getLong();
			int numberOfSolutions = getSolutions(m, solutions);
			printSolutions(numberOfSolutions, solutions, io);
		}
		io.close();
	}

	private static void printSolutions(int numberOfSolutions, LinkedList<Coefficient> solutions, Kattio io) {
		io.print(numberOfSolutions+"\n");
		while(!solutions.isEmpty()) {
			io.print(solutions.pop());
		}
		io.print("\n");
	}

	private static int getSolutions(final long m, final LinkedList<Coefficient> solutions) {
		// k == 1
		solutions.push(new Coefficient(m,1));
		int numberOfSolutions = solutions.peek().numberOfRepresentations();
		// k == 2
		if (m>=6) {
			double d = Math.sqrt(1+8*m);
			long x = (long)d;
			if (d == x && (x & 1) == 1) { //check if d is an integer and odd
				long n = (1+x)>>1;
				solutions.push(new Coefficient(n,2));
				numberOfSolutions += solutions.peek().numberOfRepresentations();
			}
			// k >= 3
			BigInteger namnare = BigInteger.valueOf(2);
			for (int k = 3; k < m/2; k++) {
				namnare = namnare.multiply(BigInteger.valueOf(k));
				long n = k*2;
				BigInteger taljare = BigInteger.valueOf(1);
				for (long j=n; j>n-k; j--) {
					taljare = taljare.multiply(BigInteger.valueOf(j));
				}
				
				long kvot = taljare.divide(namnare).longValue();
				if (kvot>m) {
					break;
				}
				while (kvot < m) {
					n++;
					if (kvot % (n-k) == 0) {
						kvot /= (n-k);
						kvot *= n;
					}
					else {
						kvot *= n/(n-k);
					}
				}
				if (kvot == m) {
					solutions.push(new Coefficient(n, k));
					numberOfSolutions += solutions.peek().numberOfRepresentations();
				}
			}
		}
		return numberOfSolutions;
	}
	
	public static class Coefficient {
		public final long n, k;
		public Coefficient(final long n, final long k) {
			this.n = n;
			this.k = k;
		}
		
		public int numberOfRepresentations() {
			if ((n & 1)==0 && (n>>1)==k)
				return 1;
			else
				return 2;
		}
		
		public String toString() {
			if  (numberOfRepresentations()==1){
				return "("+n+", "+k+") ";
			}
			else {
				return "("+n+", "+k+") ("+n+", "+(n-k)+") ";
			}
		}
	}
}
