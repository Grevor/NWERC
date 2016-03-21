
public class LineThemUp {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		boolean set = false;
		double sign = 0;
		n--;
		String last = io.getWord();
		while(n-- >0) {
			String s = io.getWord();
			double ns = Math.signum(last.compareTo(s));
			if(!set) {
				set = true;
				sign = ns;
				last = s;
				continue;
			}
			if(ns != sign) {
				io.println("NEITHER");
				io.close();
				return;
			}
			last = s;
		}
		
		io.println(sign == -1.0 ? "INCREASING" : "DECREASING");
		io.close();
	}
}
