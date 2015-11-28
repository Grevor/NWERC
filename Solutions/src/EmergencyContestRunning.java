
public class EmergencyContestRunning {

	public EmergencyContestRunning() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		long n = io.getLong();
		long k = io.getLong();
		n--;
		if (n < k*2){
			io.println(n);
			io.close();
			return;
		}
		long dist = k + ((n)% k)+1;
		/*int dist = k;
		
		int jump = (n-k)/k;
		dist++;
		n -= jump*k;
		dist += n;*/
		
		
		io.println(dist);
		io.close();

	}

}
