import java.util.HashMap;
import java.util.Map.Entry;

public class Prelude {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("A#", 2);
		map.put("Bb", 2);
		map.put("B", 3);
		map.put("C", 4);
		map.put("C#", 5);
		map.put("Db", 5);
		map.put("D", 6);
		map.put("D#", 7);
		map.put("Eb", 7);
		map.put("E", 8);
		map.put("F", 9);
		map.put("F#", 10);
		map.put("Gb", 10);
		map.put("G", 11);
		map.put("G#", 12);
		map.put("Ab", 12);
		
		Kattio scan = new Kattio();
		int s = 1;
		while(scan.hasMoreTokens()) {
			String note = scan.getWord();
			String t = scan.getWord();

			int n = map.get(note);
			boolean b = false;
			for(Entry<String, Integer> e : map.entrySet()) {
				if(e.getValue() == n && !e.getKey().equals(note)) {
					System.out.println("Case " + s +": " + e.getKey() + " " + t);
					b = true;
				}
				if(b)
					break;
			}
			
			if(!b)
				System.out.println("Case " + s + ": " + "UNIQUE");
			
			s++;
		}
		
		scan.close();
	}
}
/*
A major
A minor
A# major
A# minor
Bb major
Bb minor
C major
C minor
C# major
C# minor
Db major
Db minor
D major
D minor
D# major
D# minor
Eb major
Eb minor
E major
E minor
F major
F minor
F# major
F# minor
Gb major
Gb minor
G major
G minor
G# major
G# minor
Ab major
Ab minor
*/