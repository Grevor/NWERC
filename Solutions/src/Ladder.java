
public class Ladder {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		double h = io.getDouble();
		double v = io.getDouble();
		
		double ans = h / Math.sin((v / 180) * Math.PI);
		
		io.println((long)Math.ceil(ans));
		
		io.close();
	}
}
