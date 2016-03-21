
public class SVM {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		double[] w = new double[n];
		double[] x = new double[n];
		
		readValues(w, io);
		double b = io.getDouble();
		
		double wl = Math.sqrt(inner(w,w));
		
		while(io.hasMoreTokens()) {
			readValues(x, io);
			double ans = (inner(w,x) + b) / wl;
			io.println(ans);
		}
		
		io.close();
	}

	private static double inner(double[] w, double[] w2) {
		double sum = 0;
		for(int i = 0; i < w.length; i++)
			sum += w[i] * w2[i];
		return sum;
	}

	private static void readValues(double[] w, Kattio io) {
		for(int i = 0; i < w.length; i++)
			w[i] = io.getDouble();
	}
}

/*

2
-1 2 3
-3 1
8.71 -2.35


*/