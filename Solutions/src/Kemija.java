import java.util.HashSet;


public class Kemija {
	static final HashSet<Character> cc = new HashSet<>();
	
	static {
		cc.add('a');
		cc.add('e');
		cc.add('i');
		cc.add('o');
		cc.add('u');
	}
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		String code = io.getWordLine();
		StringBuilder b = new StringBuilder(code.length());
		for(int i = 0; i < code.length(); i++) {
			char c = code.charAt(i);
			b.append(c);
			if(cc.contains(c)) i += 2;
		}
		io.println(b.toString());
		io.close();
	}
}
