
public class Apaxian {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		String name = io.getWord();
		char c = name.charAt(0);
		StringBuilder builder = new StringBuilder(name.length());
		builder.append(c);
		for(int i = 1; i < name.length(); i++) {
			char cc = name.charAt(i);
			if(c == cc)
				continue;
			c = cc;
			builder.append(cc);
		}
		
		io.println(builder.toString());
		io.close();
	}
}
