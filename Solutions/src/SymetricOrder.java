import java.util.ArrayDeque;


public class SymetricOrder {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int i = 0;
		while(run(io, ++i));
		
		io.close();
	}

	private static boolean run(Kattio io, int p) {
		int n = io.getInt();
		if(n == 0) return false;
		io.println("SET " + p);
		ArrayDeque<String> stack = new ArrayDeque<>();
		for(int i = 0; i < n; i++)
			if(i % 2 == 0) io.println(io.getWord());
			else stack.push(io.getWord());
		
		for(String s : stack)
			io.println(s);
		
		return true;
	}
}
