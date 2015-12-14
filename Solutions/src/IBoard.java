
public class IBoard {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(io.hasMoreTokens())
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		String line = io.getWordLine();
		int zeroes = 0, ones = 0;
		for(int i =0;i  < line.length(); i++) {
			int c = line.charAt(i);
			for(int j = 0; j < 7; j++) {
				if(get(c,j))
					ones++;
				else
					zeroes++;
			}
		}
		
		if(ones % 2 == 1 || zeroes % 2 == 1)
			io.println("trapped");
		else
			io.println("free");
	}

	private static boolean get(int c, int j) {
		return (c &(1<<j)) != 0;
	}
}
/*

Keep up the good work.
iBoard Rules!!
qwerty

*/