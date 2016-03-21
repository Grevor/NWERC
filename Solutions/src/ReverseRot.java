
public class ReverseRot {
	static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0)
			return false;
		
		String msg = io.getWord();
		StringBuilder b = new StringBuilder(msg.length());
		for(int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);
			int cc = Character.isAlphabetic(c) ? c - 'A' : c == '_' ? 26 : 27;
			int ccc = (cc + n) % 28;
			b.append(alpha.charAt(ccc));
		}
		b.reverse();
		io.println(b.toString());
		
		return true;
	}
}
