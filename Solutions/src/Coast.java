import java.util.LinkedList;


public class Coast {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		int m = io.getInt();
		
		byte[][] map = new byte[n][m];
		
		for(int i = 0; i < n; i++) {
			String l = io.getWord();
			for(int j = 0; j < m; j++)
				map[i][j] = (byte) (l.charAt(j) - '0');
		}
		
		int shoreLine = 0;
		int y = 0;
		for(int i = 0; i < m; i++)
			if(map[y][i] == 0)
				shoreLine += flood(map, y, i, n, m);
			else if(map[y][i] == 1)
				shoreLine++;
		y = n - 1;
		for(int i = 0; i < m; i++)
			if(map[y][i] == 0)
				shoreLine += flood(map, y, i, n, m);
			else if(map[y][i] == 1)
				shoreLine++;
		
		int x = 0;
		for(int i = 0; i < n; i++)
			if(map[i][x] == 0)
				shoreLine += flood(map, i, x, n, m);
			else if(map[i][x] == 1)
				shoreLine++;
		x = m - 1;
		for(int i = 0; i < n; i++)
			if(map[i][x] == 0)
				shoreLine += flood(map, i, x, n, m);
			else if(map[i][x] == 1)
				shoreLine++;
		
		
//		for(int i = 0; i < n; i++)
//			for(int j = 0; j  < m; j++) {
//				if(map[i][j] == 1)
//					shoreLine += shore(map, i, j, n, m);
//			}
//		
		io.println(shoreLine);
		io.close();
	}
	
	//static int get(int x, int y, int n) { return y * n + x; }
	//static byte getMap(byte[] map, int )

//	private static int shore(byte[][] map, int y, int x, int n, int m) {
//		int s = 0;
//		s += getShore(map, y + 1, x, n, m) ? 1 : 0;
//		s += getShore(map, y - 1, x, n, m) ? 1 : 0;
//		s += getShore(map, y, x + 1, n, m) ? 1 : 0;
//		s += getShore(map, y, x - 1, n, m) ? 1 : 0;
//		return s;
//	}
//
//	private static boolean getShore(byte[][] map, int y, int x, int n, int m) {
//		if(x < 0 || x >= m || y < 0 || y >= n)
//			return true;
//		else
//			return map[y][x] == 2;
//	}

	private static int flood(byte[][] map, int y, int x, int n, int m) {
		LinkedList<P> queue = new LinkedList<>();
		queue.add(new P(x, y));
		
		int coast = 0;
		while(!queue.isEmpty()) {
			P p = queue.poll();
			if(map[p.y][p.x] == 2)
				continue;
			map[p.y][p.x] = 2; 
			
			coast += addIfNeeded(queue, map, p.x + 1, p.y, n, m);
			coast += addIfNeeded(queue, map, p.x, p.y + 1, n, m);
			coast += addIfNeeded(queue, map, p.x - 1, p.y, n, m);
			coast += addIfNeeded(queue, map, p.x, p.y - 1, n, m);
		}
		return coast;
	}
	
	static int addIfNeeded(LinkedList<P> queue, byte[][] map, int x, int y, int n, int m) {
		byte b = get(map, x, y, n, m);
		if(b == 0) {
			queue.add(new P(x, y));
		} else if(b == 1){
			return 1;
		}
		return 0;
	}
	
	private static byte get(byte[][] map, int x, int y, int n, int m) {
		if(x < 0 || x >= m || y < 0 || y >= n)
			return 2;
		else
			return map[y][x];
	}

	private static class P {
		int x, y;
		public P(int xx, int yy) { x = xx; y = yy; }
	}
}

/*
5 6
011110
010110
111000
000010
000000

3 3
010
101
010

3 3
101
010
101


5 5
11111
10001
10101
10001
11111

*/