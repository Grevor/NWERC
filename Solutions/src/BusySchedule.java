import java.util.Arrays;


public class BusySchedule {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		
		io.close();
	}
	
	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0) return false;
		
		int[] numbers = new int[n];
		
		for(int i = 0; i < n; i++)
			numbers[i] = get(io);
		
		Arrays.sort(numbers);
		
		for(int i = n - 1; i >= 0; i--)
			print(numbers[i], io);
		
		io.println();
		return true;
	}

	static int get(Kattio io) {
		String d = io.getWord();
		String s = io.getWord();
		String[] t = d.split(":");
		int num = Integer.parseInt(t[0]) * 60;
		num += Integer.parseInt(t[1]);
		if(s.equals("p.m."))
			num += 12 * 60;
		return num;
	}
	
	static void print(int n, Kattio io) {
		boolean am = n <= 12 * 60;
		if(!am) n -= 12 * 60;
		
		int h = n / 60;
		if(h == 0) h = 12;
		
		int min = n % 60;
		
		io.println(h + ":" + min + " " + (am ? "a.m." : "p.m."));
	}
}