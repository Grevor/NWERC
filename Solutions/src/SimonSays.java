
public class SimonSays {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.getInt();
		
		while(n-->0) {
			String s = io.getWordLine();
			if(s.startsWith("Simon says"))
				io.println(s.substring(10));
		}
		io.close();
	}
}
