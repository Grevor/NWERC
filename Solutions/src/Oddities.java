
public class Oddities {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.getInt();
		while(n-- >0) {
			int m = io.getInt();
			io.println(m +  ((Math.abs(m) % 2) == 0 ? " is even" : " is odd"));
		}
		
		io.close();
	}
}
