
public class IRepeatMyself {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int t = io.getInt();
		
		for(int i = 0; i < t; i++)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		String line = io.getWordLine();
		
		for(int i = 1; i <= line.length(); i++) {
			String p = line.substring(0, i);
			int n = (int) Math.ceil(line.length() / (double)i);
			StringBuilder b = new StringBuilder();
			for(int j = 0; j <n; j++)
				b.append(p);
			
			if(b.toString().startsWith(line)) {
				io.println(i);
				return;
			}
		}
		
	}
}
