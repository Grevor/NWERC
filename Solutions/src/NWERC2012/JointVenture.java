package NWERC2012;
import java.util.ArrayList;
import java.util.Arrays;
import io.Kattio;

public class JointVenture {

	public static void main(String args[]) {
		Kattio io = new Kattio(System.in, System.out);
		
		long holeSize = io.getInt() * 10000000;
		int pieces = io.getInt();
		long[] allPieces = new long[pieces];
		for(int i = 0; i < pieces; i++) {
			allPieces[i] = io.getLong();
		}
		Arrays.sort(allPieces);
		
		int little = 0;
		int big = allPieces.length - 1;
		while(little != big) {
			long ans = allPieces[little] + allPieces[big];
			if( ans == holeSize) {
				io.println("yes " + allPieces[little] + " " + allPieces[big]);
				io.close();
				return;
			}
			else if(ans < holeSize) {
				little++;
			}
			else {
				big--;
			}
		}
		
		io.println("danger");
		io.close();
	}
}
