
public class TextEncryption {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		while(run(io));
		
		io.close();
	}

	private static boolean run(Kattio io) {
		int n = io.getInt();
		if(n == 0) return false;
		String actual = io.getWordLine().replaceAll(" ", "").toUpperCase();
		char[] enc = new char[actual.length()];
		int offset = 0;
		
		int c = 0;
		
		while(c < enc.length) {
			for(int i = offset; i < enc.length; i +=n) {
				enc[i] = actual.charAt(c);
				c++;
			}
			offset++;
		}
		io.println(enc);
		return true;
	}
}

/*
1
CTU Open Programming Contest
2
CTU Open Programming Contest
7
This is a secret message that noone should ever see Lets encrypt it
15
text too short
0


CMTMUIONPGECNOPNRTOEGSRTA
TESNUECHCAOLERIRGODLYSEENEEPITTEVTTSMHSESIAEAHRETSSTOSN
TEXTTOOSHORT



*/