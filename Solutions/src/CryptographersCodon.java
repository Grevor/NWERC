
public class CryptographersCodon {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		String chip = io.getWord();
		String per = "PER";
		int num = 0;
		for(int i = 0; i < chip.length(); i++) {
			if(chip.charAt(i) != per.charAt(i % 3))
				num++;
		}
		
		io.println(num);
		io.close();
	}
}
