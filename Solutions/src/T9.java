import java.util.TreeMap;


public class T9 {
	String[] ss = new String[] {
			"2", "22", "222",
			"3","33","333",
			"4","44","444",
			"5","55","555",
			"6","66","666",
			"7","77","777", "7777",
			"8","88","888",
			"9","99","999", "9999"
	};
	
	static TreeMap<Character, B> btn = new TreeMap<>();
	
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		btn.put('a', new B('a', 2));
		btn.put('d', new B('d', 3));
		btn.put('g', new B('g', 4));
		btn.put('j', new B('j', 5));
		btn.put('m', new B('m', 6));
		btn.put('p', new B('p', 7));
		btn.put('t', new B('t', 8));
		btn.put('w', new B('w', 9));
		btn.put(' ', new B(' ', 0));
		
		int n = io.getInt();
		for(int i = 0; i < n; i++)
			run(io);
		
		
		io.close();
	}

	private static void run(Kattio io) {
		String s = io.getWordLine();
		
		int b = -100;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			B bb = btn.floorEntry(c).getValue();
			if(b == bb.n)
				io.append(' ');
			
			for(int j = bb.s; j <= c; j++)
				io.append(Integer.toString(bb.n));
			
			b = bb.n;
		}
		io.println();
	}
	
	private static class B {
		char s;
		int n;
		
		public B(char c, int m) {
			s = c;
			n = m;
		}
	}
}

/*

4
hi
yes
foo  bar
hello world

*/