import java.util.HashMap;
import java.util.TreeSet;


public class TouchscreenKeyboard {
	static final HashMap<Character, Integer> xs = new HashMap<>();
	static final HashMap<Character, Integer> ys = new HashMap<>();
	
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		final String f = "qwertyuiop";
		final String s = "asdfghjkl";
		final String t = "zxcvbnm";
		add(f, 0);
		add(s, 1);
		add(t, 2);
		
		int tt = io.getInt();
		for(int i = 0; i < tt; i++) {
			run(io);
		}
		
		io.close();
	}


	private static void run(Kattio io) {
		String base = io.getWord();
		int n = io.getInt();
		TreeSet<Match> matches = new TreeSet<>();
		
		for(int i = 0; i < n; i++) {
			String w = io.getWord();
			matches.add(new Match(dist(w,base), w));
		}
		
		for(Match m : matches)
			io.println(m.s + " " + m.n);
	}
	
	
	
	private static class Match implements Comparable<Match> {
		long n;
		String s;
		public Match(long nn, String w) { n = nn; s = w; }
		@Override
		public int compareTo(Match m) {
			if(n == m.n)
				return s.compareTo(m.s);
			return (int) (n - m.n);
		}
	}
	
	
	


	private static void add(String f, int n) {
		for(int i = 0; i < f.length(); i++) {
			char c = f.charAt(i);
			ys.put(c, n);
			xs.put(c, i);
		}
	}
	
	private static long dist(String word, String base) {
		long ans = 0;
		for(int i = 0; i < word.length(); i++)
			ans += dist(word.charAt(i), base.charAt(i));
		return ans;
	}
	private static long dist(char a, char b) {
		return Math.abs(xs.get(a) - xs.get(b)) + Math.abs(ys.get(a) - ys.get(b));
	}
}

