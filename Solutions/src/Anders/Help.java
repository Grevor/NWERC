package Anders;
import java.util.Scanner;
import java.util.Hashtable;


public class Help{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int problems = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < problems; i++){

			String prahse1 = sc.nextLine();
			String prahse2 = sc.nextLine();
			String[] prahseArray1 = prahse1.split(" ");
			String[] prahseArray2 = prahse2.split(" ");
			if (prahseArray1.length != prahseArray2.length){
				System.out.println("-");
				continue;
			}
			Hashtable<String, Integer> table = new Hashtable<String, Integer>();
			String[] stringTranslation = new String[110];

			int tempId = 1;
			boolean okey = true;
			for (int j = 0; j < prahseArray1.length; j++){
				int selected = 0;
				if (prahseArray1[j].charAt(0) == '<'){
					if (table.containsKey(prahseArray1[j])){
						selected = table.get(prahseArray1[j]);
					}else{
						if (prahseArray2[j].charAt(0) == '<' && table.containsKey(prahseArray2[j])){
							table.put(prahseArray1[j],table.get(prahseArray2[j]));
						}else{
							table.put(prahseArray1[j],tempId);
							selected = tempId;
							tempId++;
						}
					}
				}
				if (prahseArray2[j].charAt(0) == '<'){
					if (selected != 0){
						if (table.containsKey(prahseArray2[j])){
							int value = table.get(prahseArray2[j]);
							if (selected != value){
								if (stringTranslation[selected] == null || stringTranslation[value] == null || stringTranslation[selected] != stringTranslation[value]){
									if (stringTranslation[selected] == null){
										stringTranslation[selected] = stringTranslation[value];
									}else{
										stringTranslation[value] = stringTranslation[selected];
									}
									table.put(prahseArray2[j],table.get(selected));
								}else{
									okey = false;
									break;
								}
							}
						}else{
							table.put(prahseArray2[j],table.get(selected));
						}
					}else{
						if (table.containsKey(prahseArray2[j])){
							selected = table.get(prahseArray2[j]);
						}else{
							table.put(prahseArray2[j],tempId);
							selected = tempId;
							tempId++;
						}
					}
				}
				if (prahseArray1[j].charAt(0) != '<' && selected != 0){
					if (stringTranslation[selected] != null && stringTranslation[selected] != prahseArray1[j]){
						okey = false;
						break;
					}
					stringTranslation[selected] = prahseArray1[j];
				}
				if (prahseArray2[j].charAt(0) != '<' && selected != 0){
					if (stringTranslation[selected] != null && stringTranslation[selected] != prahseArray2[j]){
						okey = false;
						break;
					}
					stringTranslation[selected] = prahseArray2[j];	
				}
				selected = 0;
			}
			if (okey == false){
				System.out.println("-");
				continue;
			}
			String result = "";
			for (int j = 0; j < prahseArray1.length; j++){
				if (prahseArray1[j].charAt(0) == '<' ){
					result += stringTranslation[table.get(prahseArray1[j])];
				} else{
					result += prahseArray1[j] + " ";
				}
			}
			System.out.println(result);
		}


		sc.close();
	}


}