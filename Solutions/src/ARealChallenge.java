
public class ARealChallenge {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		double a = io.getDouble();
		
		double c = Math.sqrt(a) * 4;
		io.println(c);
		
		io.close();
	}
}
