
public class Modulo {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int[] gg = new int[42];
		
		for(int i = 0; i < 10; i++)
			gg[io.getInt() % 42]++;
		
		int n = 0;
		for(int i = 0; i < 42; i++) {
			if(gg[i] != 0)
				n++;
		}
		
		io.println(n);
		io.close();
	}
}
