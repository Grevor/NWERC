import java.util.Arrays;
import java.util.HashMap;


public class SynchingLists {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0) return false;
		
		int[] first = new int[n];
		int[] firstOrdered = new int[n];
		int[] secondOrdered = new int[n];
		
		for(int i = 0; i < n; i++) {
			first[i] = io.getInt();
			firstOrdered[i] = first[i];
		}
		for(int i = 0; i < n; i++)
			secondOrdered[i] = io.getInt();
		
		Arrays.sort(firstOrdered);
		Arrays.sort(secondOrdered);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++)
			map.put(firstOrdered[i], secondOrdered[i]);
		
		for(int i = 0; i < n; i++)
			io.println(map.get(first[i]));
		
		io.println();
		return true;
	}
}
