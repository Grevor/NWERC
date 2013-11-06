package NWERC2012;
import java.util.ArrayList;


public class Idol {
	
	public static void main(String srgs[]) {
		Kattio io = new Kattio(System.in, System.out);
		ArrayList<Judge> judges = new ArrayList<Judge>();
		int contestants = io.getInt();
		int nJudges = io.getInt();
		Idol idol = new Idol();
		for(int i = 0; i < nJudges; i++) {
			judges.add(idol.new Judge(io.getInt(), io.getInt()));
		}
		
		ArrayList<Judge> newJudges = new ArrayList<Judge>();
		for(int i = 0; i < judges.size(); i++) {
			if(judges.get(i).votedAgainst(1))
				newJudges.add(judges.get(i));
		}
		
		judges = newJudges;
		
		for(int i = 0; i < judges.size(); i++) {
			for(int j = i + 1; j < judges.size(); j++) {
				if(judges.get(i).votedAgainst(judges.get(j).getNonKarlVote())) {
					io.println("no");
					io.close();
					return;
				}
			}
		}
		
		io.println("yes");
		io.close();
	}
	
	private class Judge {
		public final int vote1, vote2;
		
		public Judge(int v1, int v2) {
			vote1 = v1;
			vote2 = v2;
		}
		
		public boolean votedAgainst(int otherVote) {
			if(-otherVote == vote1 || -otherVote == vote2)
				return true;
			return false;
		}
		
		public int getNonKarlVote() {
			if(Math.abs(vote1) == 1)
				return vote2;
			else
				return vote1;
		}
	}
}
