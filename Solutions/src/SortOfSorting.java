import java.util.ArrayList;
import java.util.TreeMap;


public class SortOfSorting {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(true) {
			int n = io.getInt();
			TreeMap<String, ArrayList<String>> strings = new TreeMap<>();
			if(n == 0)
				break;
			
			for(int i = 0;i  < n; i++)
				add(io.getWord(), strings);
			
			for(ArrayList<String> ss : strings.values())
				for(String s : ss)
					io.println(s);
			
			io.println();
		}
		
		io.close();
	}
	
	static void add(String s, TreeMap<String, ArrayList<String>> strings) {
		String m = s.substring(0, Math.min(2, s.length()));
		if(!strings.containsKey(m))
			strings.put(m, new ArrayList<String>());
		
		strings.get(m).add(s);
	}
}

/*

3
Mozart
Beethoven
Bach
5
Hilbert
Godel
Poincare
Ramanujan
Pochhammmer
0


*/