
public class Eligibility {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		while(n-->0) {
			String name = io.getWord();
			int studies = Integer.parseInt(io.getWord().substring(0,4));
			int born = Integer.parseInt(io.getWord().substring(0,4));
			int courses = io.getInt();
			
			io.print(name + " ");
			
			if(studies >= 2010 || born >= 1991) io.println("eligible");
			else if(courses > 40) io.println("ineligible");
			else io.println("coach petitions");
		}
		
		io.close();
	}
}
