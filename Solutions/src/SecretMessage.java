
public class SecretMessage {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.getInt();
		while(n-- >0) run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		String s = io.getWordLine();
		int n = getN(s.length());
		char[][] m = new char[n][n];
		StringBuilder b = new StringBuilder(s.length());
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				int c = j + i * n;
				char cc = c < s.length() ? s.charAt(c) : '*';
				m[i][j] = cc;
			}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++) {
				char c = m[n - 1 - j][i];
				if(c == '*') continue;
				b.append(c);
			}
		
		io.println(b.toString());
	}

	private static int getN(int length) {
		int sq = (int) Math.sqrt(length);
		if(sq * sq < length) sq++;
		return sq;
	}
}
