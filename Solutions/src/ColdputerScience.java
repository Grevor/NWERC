
public class ColdputerScience {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		int num = 0;
		for(int i = 0; i < n; i++)
			num += io.getInt() < 0 ? 1 : 0;
			
		io.println(num);
		io.close();
	}
}
