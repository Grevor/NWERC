
public class Tri {
	static char o1 = ' ', o2 = ' ';
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int a = io.getInt();
		int b = io.getInt();
		int c = io.getInt();
		if(!check(a,b,c)) {
			check(b,c,a);
			char t = o1;
			o1 = o2;
			o2 = t;
		}
		
		io.print(a);
		io.print(o1);
		io.print(b);
		io.print(o2);
		io.println(c);
		
		
		io.close();
	}
	
	static boolean check(int a, int b, int c) {
		if(a / b == c) set('/', '=');
		if(a * b == c) set('*', '=');
		if(a + b == c) set('+', '=');
		if(a - b == c) set('-', '=');
		return o1 != ' ';
	}

	private static void set(char c, char d) { o1 = c; o2 = d; }
}
