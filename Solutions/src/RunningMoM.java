import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;


public class RunningMoM {
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		HashMap<String, Integer> cti = new HashMap<>();
		HashMap<String, ArrayList<String>> ctc = new HashMap<>();
		
		int n = io.getInt();
		for(int i = 0; i < n; i++) {
			String s = io.getWord();
			String d = io.getWord();
			cti.put(s, -1);
			cti.put(d, -1);
			if(!ctc.containsKey(s))
				ctc.put(s, new ArrayList<String>());
			
			ctc.get(s).add(d);
		}
		
		int round = 0;
		while(io.hasMoreTokens()) {
			round++;
			String city = io.getWord();
			ArrayDeque<String> stack = new ArrayDeque<>();
			stack.push(city);
			boolean safe = false;
			while(!stack.isEmpty()) {
				String nextCity = stack.pop();
				int color = cti.get(nextCity);
				if(color == round) {
					safe = true;
					break;
				}
				cti.put(nextCity, round);
				ArrayList<String> cc = ctc.get(nextCity);
				if(cc != null)
					for(String s : cc)
						stack.push(s);
			}
			
			io.println(city + " " + (safe ? "safe" : "trapped"));
		}
		
		io.close();
	}
}

/*
5
Arlington San_Antonio
San_Antonio Baltimore
Baltimore New_York
New_York Dallas
Baltimore Arlington
San_Antonio
Baltimore
New_York


*/