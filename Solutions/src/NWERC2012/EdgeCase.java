package NWERC2012;

import io.Kattio;
import java.math.BigInteger;

public class EdgeCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		BigInteger previous = BigInteger.valueOf(3);
		BigInteger current = BigInteger.valueOf(4);
		for (int i=3; i<n; i++) {
			BigInteger next = current.add(previous);
			previous = current;
			current = next;
		}
		io.print(current.toString());
		io.close();
	}

}