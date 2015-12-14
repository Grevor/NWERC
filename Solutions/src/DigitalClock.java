
public class DigitalClock {
	static final String fh = "+---+";
	static final String dh = "+   +";
	static final String lh = "+    ";
	static final String rh = "    +";
	
	static final String ll = "|    ";
	static final String rl = "    |";
	static final String dl = "|   |";
	
	static final String[] one = {
		rh,
		rl,rl,
		rh,
		rl,rl,
		rh
	};
	
	static final String[] two = {
			fh,
			rl,rl,
			fh,
			ll,ll,
			fh
		};
	
	static final String[] three = {
			fh,
			rl,rl,
			fh,
			rl,rl,
			fh
		};
	
	static final String[] four = {
			dh,
			dl,dl,
			fh,
			rl,rl,
			rh
		};
	
	static final String[] five = {
			fh,
			ll,ll,
			fh,
			rl,rl,
			fh
		};
	
	static final String[] six = {
			fh,
			ll,ll,
			fh,
			dl,dl,
			fh
		};
	
	static final String[] seven = {
			fh,
			rl,rl,
			rh,
			rl,rl,
			rh
		};
	
	static final String[] eight = {
			fh,
			dl,dl,
			fh,
			dl,dl,
			fh
		};
	
	static final String[] nine = {
			fh,
			dl,dl,
			fh,
			rl,rl,
			fh
		};
	
	static final String[] zero = {
			fh,
			dl,dl,
			dh,
			dl,dl,
			fh
		};
	
	static final String[][] numbers = {
			zero, one, two, three, four, five, six, seven, eight, nine
	};
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		String t = io.getWord();
		if(t.equals("end"))
			return false;
		
		int h1 = t.charAt(0) - '0';
		int h2 = t.charAt(1) - '0';
		int m1 = t.charAt(3) - '0';
		int m2 = t.charAt(4) - '0';
		
		for(int i = 0; i < 7; i++) {
			io.append(numbers[h1][i]);
			io.append("  ");
			io.append(numbers[h2][i]);
			io.append("  ");
			io.append((i == 2 || i == 4) ? "o" : " ");
			io.append("  ");
			io.append(numbers[m1][i]);
			io.append("  ");
			io.append(numbers[m2][i]);
			io.println();
		}
		io.println();
		io.println();
		return true;
	}
}
