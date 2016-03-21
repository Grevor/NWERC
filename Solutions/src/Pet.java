
public class Pet {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int c = -1, m = -1;
		for(int i = 1; i <= 5; i++) {
			int n = io.getInt() + io.getInt() + io.getInt() + io.getInt();
			if(n > m){ m = n; c = i; }
		}
		io.println(c+" "+m);
		io.close();
	}
}
