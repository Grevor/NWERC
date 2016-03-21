
public class EstimatingCircle {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		double r = io.getDouble();
		double tot = io.getDouble();
		double hit = io.getDouble();
		
		if(r == 0.0 && tot == 0.0 && hit == 0.0) return false;
		
		double estimate = (hit / tot) * r * r * 4;
		
		io.println((r * r * Math.PI) + " " + estimate);
		
		return true;
	}
}
