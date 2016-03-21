
public class AlphabetSpam {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		String all = io.getWordLine();
		int w = 0, u = 0, l = 0, s = 0;
		for(int i = 0; i < all.length(); i++) {
			char c = all.charAt(i);
			if(c == '_') w++;
			else if (Character.isAlphabetic(c))
				if(Character.isLowerCase(c))
					l++;
				else u++;
			else s++;
		}
		
		double total = all.length();
		io.println(w / total);
		io.println(l / total);
		io.println(u / total);
		io.println(s / total);
		
		io.close();
	}
}
