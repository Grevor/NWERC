
public class MatrixInverse {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int cc = 0;
		while(io.hasMoreTokens()) {
			cc++;
			int a = io.getInt(), b = io.getInt(), c = io.getInt(), d = io.getInt();
			
			long det = a * d - c * b;
			
			io.println("Case " + cc + ":");
			io.println((d / det) + " " + (-b/det));
			io.println((-c/det) + " " + (a/det));
		}
		io.close();
	}
}
/*

1 0
0 1

30 29
1 1

-7 -16
4 9


*/