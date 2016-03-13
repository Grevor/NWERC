
public class BackslashProblem {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(io.hasMoreTokens()) {
			int interpretations = io.getInt();
			String line = io.getWordLine();
			StringBuilder b = new StringBuilder(1000);
			for(int i = 0; i < line.length(); i++) {
				b.append(getChar(interpretations, line.charAt(i)));
			}
			io.println(b.toString());
		}
		
		
		io.close();
	}
	
	private static String getChar(int interpretations, char charAt) {
		if (!isEscape(charAt))
			return Character.toString(charAt);
		return getSlashes(interpretations, charAt);
	}

	private static String getSlashes(int interpretations, char c) {
		//int n = 0;
		int n = 1 << interpretations;
		n--;
		//for(int i = 0; i < interpretations; i++) {
		//	n += (n + 1);
		//}
		StringBuilder b = new StringBuilder(n);
		for(int i = 0; i < n; i++)
			b.append('\\');
		b.append(c);
		return b.toString();
	}

	private static boolean isEscape(char c) {
		return ('!' <= c && c <= '*') || ('[' <= c && c <= ']');
	}
}

/*
1
this is a 'test'
2
/:-)


*/