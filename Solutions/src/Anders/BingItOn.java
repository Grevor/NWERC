package Anders;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;


public class BingItOn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		LinkedList<String>[] words = new LinkedList[26];
		for (int i = 0; i < words.length; i++){
			words[i] = new LinkedList<String>();
		}
		
		for (int i = 0; i < num; i++){
			String line = sc.nextLine();
			int count = 0;
			int temp = line.charAt(0) - 'a';
			if (table.containsKey(line)){
				count = table.get(line);
			}
			/*for (String word : words[temp]) {
				if (word.length() >= line.length() &&  word.substring(0, line.length()).compareTo(line) == 0) {
					count++;
				}
			}*/
			if (line.length() < 33){
				String sub = "";
				for (int j = 0; j < line.length(); j++){
					sub += line.charAt(j);
					if (table.containsKey(sub)){
						table.put(sub,table.get(sub) + 1);
					}else{
						table.put(sub,1);
					}
				}
			}else{
				words[temp].add(line);
			}
			System.out.println(count);
		}
		
		sc.close();
	}

}
