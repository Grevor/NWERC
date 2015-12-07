
public class IntegerLists {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int t = io.getInt();
		
		for(int i =0; i < t; i++)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		String p = io.getWord();
		int n = io.getInt();
		String l = io.getWord();
		
		int start = 0;
		int end = n;
		boolean r = false;
		
		int pl = p.length();
		for(int i = 0; i < pl; i++) {
			char c = p.charAt(i);
			if(c == 'R') {
				r = !r;
				continue;
			}
			
			if(r)
				end--;
			else
				start++;
			
			if(end < start) {
				io.println("error");
				return;
			}
		}
		
		if(end == start) {
			io.println("[]");
			return;
		}
		end--;
		
		int s = 0;
		int e = l.length() - 1;
		for(int i = 0; i < start; i++)
			s = l.indexOf(',', s + 1);
		
		if(s == -1)
			s = 0;
//		s++;
		
		e = s;
		for(int i = start; i <= end; i++)
			e = l.indexOf(',', e + 1);
		
		if(e == -1)
			e = l.length() - 1;
		
		s++;
		//e--;
		
		io.append("[");
		if(r)
			io.append(reverse(l, s, e, end - start));
		else
			io.append(l, s, e);
		io.println("]");
	}

	private static CharSequence reverse(String l, int s, int e, int num) {
		StringBuilder b = new StringBuilder();
		
		int c = e;
		for(int i = 0; i <= num; i++) {
			e = c;
			c = l.lastIndexOf(',', c - 1);
			if(c == -1)
				c = 0;
			
			for(int j = c + 1; j < e; j++) {
				b.append(l.charAt(j));
			}
			if(i != num)
				b.append(',');
		}
		
		return b;
	}
}

/*
4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]


6
DD
2
[1,2]
RDD
2
[1,2]
D
1
[1]
RD
1
[1]
R
1
[1]
R
2
[1,2]


4
DRDDRR
4
[1,2,3,4]
D
0
[]
DR
2
[1,2]
RRRDRDR
4
[11,22,33,44]


5
DDDD
3
[11,22,33]
DRDRDRD
3
[11,22,33]
DDD
3
[11,22,33]
DRDRDR
3
[11,22,33]
RDDDD
3
[11,22,33]
RR
3
[11,22,33]


5
R
1
[123]
RD
3
[123,124,125]
DR
3
[123,124,125]
DDR
3
[123,124,125]
RDD
3
[123,124,125]


*/
