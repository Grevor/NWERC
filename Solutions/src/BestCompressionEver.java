
public class BestCompressionEver {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		long min = io.getLong();
		long target = io.getLong();
		
		target = 1L << (target + 1);
		target--;
		
		io.println(min > target ? "NO" : "YES");
		
		io.close();
	}
}
