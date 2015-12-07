import java.util.BitSet;


public class QueenI {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		while(true) {
			int x = io.getInt();
			int y = io.getInt();
			int n = io.getInt();
			if(n == 0 && x == 0 && y == 0)
				break;
			
			run(io, x, y, n);
		}
		
		io.close();
	}

	private static void run(Kattio io, int x, int y, int n) {
		BitSet lines = new BitSet(y), columns = new BitSet(x), dd = new BitSet(x + y), du = new BitSet(x + y);
		
		for(int i = 0; i < n; i++) {
			int xx = io.getInt() - 1, yy = io.getInt() - 1;
			lines.set(yy);
			columns.set(xx);
			dd.set(yy - xx + x);
			du.set(xx + yy);
		}
		
		int places = 0;
		for(int i = 0; i < x; i++)
			for(int j = 0; j < y; j++) {
				boolean taken =
						lines.get(j) 
						|| columns.get(i)
						|| dd.get(j - i + x)
						|| du.get(i + j);
				if(!taken)
					places++;
			}
		
		io.println(places);
	}
	
}

/*
8 8 2
4 5
5 5
0 0 0
*/