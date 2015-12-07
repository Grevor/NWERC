import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


public class Collapse {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.getInt();
		
		N[] ns = new N[n];
		
		for(int i = 0; i < n; i++)
			ns[i] = new N();
		
		HashSet<Integer> collapse = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			N node = ns[i];
			node.t = io.getLong();
			int k = io.getInt();
			for(int kk = 0; kk < k; kk++) {
				int giver = io.getInt() - 1;
				int g = io.getInt();
				node.s += g;
				ns[giver].rs.put(i, g);
			}
		}
		
		collapse.add(0);
		
		while(!collapse.isEmpty()) {
			int nn = collapse.iterator().next();
			collapse.remove(nn);
			N node = ns[nn];
			if(node.collapsed)
				continue;
			
			node.collapsed = true;
			
			for(Entry<Integer,Integer> e : node.rs.entrySet()) {
				int cn = e.getKey();
				
				N child = ns[cn];
				if(child.collapsed)
					continue;
				
				child.s -= e.getValue();
				if(child.s < child.t) {
					collapse.add(cn);
				}
			}
		}
		
		long rem = 0;
		for(N nn : ns)
			if(!nn.collapsed)
				rem++;
		
		io.println(rem);
		io.close();
	}
	
	private static class N {
		HashMap<Integer, Integer> rs = new HashMap<>();
		boolean collapsed = false;
		long t;
		long s;
	}
}
/*
4
0 0
25 3 1 10 3 10 4 10
10 1 2 10
10 1 2 10


4
0 0
20 3 1 10 3 10 4 10
10 1 2 10
10 1 2 10
*/