
public class Zamboni {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int r = io.getInt();
		int c = io.getInt();
		int i = r - io.getInt();
		int j = io.getInt() - 1;
		long n = io.getLong();
		char[][] ice = new char[r][c];
		for(int k = 0; k < r; k++)
			for(int h = 0; h < c; h++)
				ice[k][h] = '.';
		
		int rem = r * c;
		int endx = (int) ((j + getx(n)) % c);
		int endy = (int) ((i + gety(n)) % r);
		if(endy < 0)
			endy += r;
		if(endx < 0)
			endx +=c;
		
		int max = Math.max(c, r);
		int numSteps = max * 4;
		for(long nn = 0; nn < Math.min(max * 4, n);) {
			long x = j + getx(nn);
			long y = i + gety(nn);
			char color = (char) ('A' + (nn % 26));
			nn++;
			long lx = j + getx(nn);
			long ly = i + gety(nn);
			
			if(nn % 2 == 0) {
				rem -= setx(ice, x,y,lx,ly,color,r,c);
			} else {
				rem -= sety(ice, x, y, lx, ly, color, r,c);
			}
		}
		for(long nn = Math.max(0, n - numSteps); nn < n;) {
			long x = j + getx(nn);
			long y = i + gety(nn);
			char color = (char) ('A' + (nn % 26));
			nn++;
			long lx = j + getx(nn);
			long ly = i + gety(nn);
			
			if(nn % 2 == 0) {
				rem -= setx(ice, x,y,lx,ly,color,r,c);
			} else {
				rem -= sety(ice, x, y, lx, ly, color, r,c);
			}
		}
		
//		while(n > 0 && rem > 0) {
//			long x = j + getx(n);
//			long y = i + gety(n);
//			char color = (char) ('A' + ((n - 1) % 26));
//			n--;
//			long lx = j + getx(n);
//			long ly = i + gety(n);
//			
//			if(n % 2 == 0) {
//				rem -= sety(ice, x, y, lx, ly, color, c, r);
//			} else {
//				rem -= setx(ice, x,y,lx,ly,color,c,r);
//			}
//		}
		
		
		ice[endy][endx] = '@';
		
		for(int k = r - 1; k >= 0; k--) {
			for(int h = 0; h < c; h++)
				io.append(ice[k][h]);
			io.println();
		}
		io.close();
	}
	
	private static int setx(char[][] ice, long x, long y, long lx, long ly, char color, int r, int c) {
		int removed = 0;
		long start = Math.min(x, lx);
		long end = Math.max(x, lx);
		int yy = (int) (y % r);
		if(yy < 0)
			yy += r;
		if(end - start >= c - 1)
			for(int i = 0; i < c; i++) {
				if(ice[yy][i] == '.')
					removed++;
				ice[yy][i] = color;
			}
		else {
			int st = (int) (start % c);
			if(st < 0)
				st += c;
			int en = (int) (st + (end - start));
			for(int i = st; i <= en; i++) {
				if(ice[yy][i % c] == '.')
					removed++;
				ice[yy][i % c] = color;
			}
		}
		return removed;
	}
	
	private static int sety(char[][] ice, long x, long y, long lx, long ly, char color, int r, int c) {
		int removed = 0;
		long start = Math.min(y, ly);
		long end = Math.max(y, ly);
		int xx = (int) (x % c);
		if(xx < 0)
			xx+=c;
		
		if(end - start >= r - 1)
			for(int i = 0; i < r; i++) {
				if(ice[i][xx] == '.')
					removed++;
				ice[i][xx] = color;
			}
		else {
			int st = (int) (start %r);
			if(st < 0)
				st += r;
			
			int en = (int) (st + (end - start));
			for(int i = st; i <= en; i++) {
				if(ice[i % r][xx] == '.')
					removed++;
				ice[i % r][xx] = color;
			}
		}
		return removed;
	}

	public static long getx(long s) {
		long rem = s % 4;
		if(rem == 2 || rem == 3)
			return 2 * ((s + 2)/4);
		return -2 * (s / 4);
	}
	
	public static long gety(long s) {
		long rem = s % 4;
		if(rem == 1 || rem == 2)
			return 2 * (s/4) + 1;
		return -1 * (s + 1) / 2;
	}
}


/*

5 5 3 3 4

.....
..BBC
..A.C
....C
@DDDD


5 5 3 3 7








30 30 1 1 2000000

IFKFOFSFWFAFFFFFFFFFFFYFUFQFMF
LLLLOLSLWLALLLLLLLLLLLYLULQLML
IBKBOBSBWBABBBBBBBBBBBYBUBQBMB
PPPPPPSPWPAPPPPPPPPPPPYPUPQPPP
IXKXOXSXWXAXXXXXXXXXXXYXUXQXMX
TTTTTTTTWTATTTTTTTTTTTYTUTTTTT
ITKTOTSTWTATTTTTTTTTTTYTUTQTMT
XXXXXXXXXXAXXXXXXXXXXXYXXXXXXX
IPKPOPSPWPAPPPPPPPPPPPYPUPQPMP
BBBBBBBBBBBBBBBBBBBB@BBBBBBBBB
ILKLOLSLWLALLLLLLLLLMLYLULQLML
IXKXOXSXWXAXKXGXEXIXMXYXUXQXMX
IHKHOHSHWHAHKHHHHHIHMHYHUHQHMH

*/