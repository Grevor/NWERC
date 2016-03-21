
public class DiceGame {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int gunnar = io.getInt() + io.getInt() + io.getInt() + io.getInt();
		int emma = io.getInt() + io.getInt() + io.getInt() + io.getInt();
		
		if(gunnar > emma) io.println("Gunnar");
		else if(gunnar < emma) io.println("Emma");
		else io.println("Tie");
		
		io.close();
	}
}
