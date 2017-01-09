package Anders;
import java.util.Hashtable;
import java.util.Scanner;


public class Bela {
	
	static String[] keys= {"A","K","Q","J","T","9","8","7"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hands = sc.nextInt();
		String color = sc.next();
		sc.nextLine();
		int value = 0;
		int[] values = {11,4,3,20,10,14,0,0};
		int[] lowVlues = {11,4,3,2,10,0,0,0};
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		Hashtable<String, Integer> lowTable = new Hashtable<String, Integer>();
		for (int i = 0; i < keys.length; i++ ){
			table.put(keys[i], values[i]);
			lowTable.put(keys[i], lowVlues[i]);
		}

		for (int i = 0; i < hands*4; i++){
			String card = sc.nextLine();
			char num = card.charAt(0);
			char cardColor = card.charAt(1);
			if (color.charAt(0) == cardColor){
				value += table.get(String.valueOf(num));
			}else{
				value += lowTable.get(String.valueOf((num)));
			}
		}
		System.out.println(value);
		sc.close();
	}
}


/*
2 S
TH
9C
KS
QS
JS
TD
AD
JH
*/