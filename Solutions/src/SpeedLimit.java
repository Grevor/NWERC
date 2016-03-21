
public class SpeedLimit {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == -1) return false;
		int miles = 0;
		int h = 0;
		while(n-- > 0) {
			int km = io.getInt();
			int t = io.getInt() - h;
			h += t;
			miles += km * t;
		}
		io.println(miles + " miles");
		return true;
	}
}
