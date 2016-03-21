import java.util.Arrays;


public class Peg {
	static char[][] state = new char[20][20];
	static final int OFF = 2;
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		for(int i = 0; i < 20; i++)
			Arrays.fill(state[i], ' ');
		
		for(int i = 0; i < 7; i++) {
			String s = io.getWordLine();
			for(int j = 0; j < s.length(); j++)
				state[i + OFF][j + OFF] = s.charAt(j);
		}
		
		int moves = 0;
		for(int i = OFF; i < 20 - OFF; i++)
			for(int j = OFF; j < 20 - OFF; j++) {
				moves += getMoves(i,j);
			}
		
		io.println(moves);
		io.close();
	}

	private static int getMoves(int i, int j) {
		char c = state[i][j];
		char cc = state[i + 1][j];
		char ccc = state[i + 2][j];
		int num = 0;
		if(c == 'o' && cc == 'o' && ccc == '.')
			num++;
		
		c = state[i][j];
		cc = state[i - 1][j];
		ccc = state[i - 2][j];
		if(c == 'o' && cc == 'o' && ccc == '.')
			num++;
		
		c = state[i][j];
		cc = state[i][j - 1];
		ccc = state[i][j - 2];
		if(c == 'o' && cc == 'o' && ccc == '.')
			num++;
		
		c = state[i][j];
		cc = state[i][j + 1];
		ccc = state[i][j + 2];
		if(c == 'o' && cc == 'o' && ccc == '.')
			num++;
		
		return num;
	}
}
