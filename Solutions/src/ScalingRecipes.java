import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class ScalingRecipes {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int n = io.getInt();
		
		for(int i = 0; i < n; i++)
			run(io, i+1);
		
		io.close();
	}

	private static void run(Kattio io, int n) {
		int in = io.getInt();
		int r = io.getInt();
		int d = io.getInt();
		HashMap<String, Double> perc = new HashMap<>();
		ArrayList<String> order = new ArrayList<>();
		double w = 0;
		double ref = d / (double)r;
		
		while(in-- >0) {
			String name = io.getWord();
			double weight = io.getDouble();
			double per = io.getDouble();
			
			if(per == 100.0) {
				w = weight * ref;
			}
			perc.put(name, per);
			order.add(name);
		}
		
		HashMap<String, Double> act = new HashMap<>();
		for(Entry<String, Double> e : perc.entrySet()) {
			act.put(e.getKey(), e.getValue() * w / 100);
		}
		
		io.println("Recipe # " + n);
		for(String s : order)
			io.println(s + " " + act.get(s));
		
		io.println("----------------------------------------");
	}
}
