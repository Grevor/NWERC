import java.util.HashMap;


public class ImperialMeasurement {
	static final double[] mm = {1, 1000, 12000, 3 * 12000, 3 * 22 * 12000, 10 * 3 * 22 * 12000, 8 * 10 * 3 * 22 * 12000, 3 * 8 * 10 * 3 * 22 * 12000};
	static final HashMap<String, Double> map = new HashMap<>();
	
	static {
		map.put("thou", mm[0]);
		map.put("th", mm[0]);
		
		map.put("inch", mm[1]);
		map.put("in", mm[1]);
		
		map.put("foot", mm[2]);
		map.put("ft", mm[2]);
		
		map.put("yard", mm[3]);
		map.put("yd", mm[3]);
		
		map.put("chain", mm[4]);
		map.put("ch", mm[4]);
		
		map.put("furlong", mm[5]);
		map.put("fur", mm[5]);
		
		map.put("mile", mm[6]);
		map.put("mi", mm[6]);
		
		map.put("league", mm[7]);
		map.put("lea", mm[7]);
	}
	
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		double base = io.getDouble();
		String b = io.getWord();
		io.getWord();
		String d = io.getWord();
		double ans = base * map.get(b) / map.get(d);
		io.println(ans);
		io.close();
	}
}
