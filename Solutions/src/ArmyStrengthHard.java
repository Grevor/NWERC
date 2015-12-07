import java.util.Comparator;
import java.util.PriorityQueue;


public class ArmyStrengthHard {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		
		int t = io.getInt();
		for(int i = 0; i < t; i++)
			run(io);
		
		io.close();
	}
	
	private static void run(Kattio io) {
		PriorityQueue<Integer> mech = new PriorityQueue<>(100000);
		PriorityQueue<Integer> god = new PriorityQueue<>(100000);
		int n = io.getInt();
		int m = io.getInt();
		
		for(int i = 0; i < n; i++)
			god.add(io.getInt());
		
		for(int i = 0; i < m; i++)
			mech.add(io.getInt());
		
		while(!god.isEmpty() && !mech.isEmpty()) {
			int gc = god.peek();
			int mc = mech.peek();
			if(mc > gc)
				god.poll();
			else
				mech.poll();
		}
		
		String ans = "uncertain";
		if(!god.isEmpty())
			ans = "Godzilla";
		if(!mech.isEmpty())
			ans = "MechaGodzilla";
		
		io.println(ans);
	}
}

/*
3

1 1
1
1

3 2
1 3 2
5 5

2 2
1 10
5 11


***


*/