
public class WordsForNumbers {
	static final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static final String[] ones = {"", "one","two","three","four","five","six","seven", "eight","nine"};
	static final String[] actuals = new String[100];
	
	static {
		actuals[0] = "zero";
		for(int i = 1; i < 10; i++)
			actuals[i] = ones[i];
		actuals[10] = "ten";
		actuals[11] = "eleven";
		actuals[12] = "twelve";
		actuals[13] = "thirteen";
		actuals[14] = "fourteen";
		actuals[15] = "fifteen";
		actuals[16] = "sixteen";
		actuals[17] = "seventeen";
		actuals[18] = "eighteen";
		actuals[19] = "nineteen";
		for(int i = 20; i < 100; i++) {
			if(i % 10 == 0) {
				actuals[i] = tens[i / 10];
				continue;
			}
			actuals[i] = tens[i / 10] + "-" + ones[i % 10];
		}
	}
	
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(io.hasMoreTokens())
			run(io);
		
		io.close();
	}
	
	private static void run(Kattio io) {
		String s = io.getWordLine();
		String[] splits = s.split(" ");
		boolean first = false;
		for(String ss : splits) {
			if(first)
				io.print(" ");
			
			String g = ss;
			if(Character.isDigit(ss.charAt(0)))
				g = actuals[Integer.parseInt(g)];
			
			if(!first)
				g = PCase(g);
			
			first = true;
			io.print(g);
		}
		io.println();
	}

	static String PCase(String s) { return s.substring(0,1).toUpperCase() + s.substring(1); }
}
