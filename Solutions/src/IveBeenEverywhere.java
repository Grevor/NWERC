import java.util.HashSet;


public class IveBeenEverywhere {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int t = io.getInt();
		
		while(t-- > 0)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		int n = io.getInt();
		HashSet<String> places = new HashSet<>();
		while(n-- > 0) places.add(io.getWord());
		io.println(places.size());
	}
}
