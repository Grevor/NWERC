package NWERC2012;

import io.Kattio;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author David
 */
public class FoulPlay {
	private static LinkedList<Integer>[] winTable;
	private static boolean[] beatenTeams;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		int n = io.getInt();
		winTable = (LinkedList<Integer>[]) new LinkedList[n];
		for (int team=0; team<n; team++) {
			winTable[team] = new LinkedList<Integer>();
			String s = io.getWord();
			for (int opponent=0; opponent<n; opponent++) {				
				if (s.charAt(opponent)=='1')
					winTable[team].add(opponent);
			}
		}
		
		beatenTeams = new boolean[n];
		beatenTeams[0] = true;
		int lgN = Integer.numberOfTrailingZeros(n);
		MatchScheme matchScheme = new MatchScheme(lgN);
		matchScheme.team = 0;
		
		if (setMatchScheme(lgN, matchScheme))
			for (int i=0; i<lgN; i++)
				io.print(matchScheme.toString(i));
		else
			io.print("Impossibru");
		io.close();
	}
	
	private static boolean setMatchScheme(int match, MatchScheme matchScheme) {
		if (match == 0) {
			if (matchScheme.parent != null)
				return setMatchScheme(matchScheme.beatenTeams.length, matchScheme.parent);
			else
				return true;
		}
		ListIterator<Integer> iter = winTable[matchScheme.team].listIterator();
		while (iter.hasNext()) {
			int opponent = iter.next();
			if (!beatenTeams[opponent]) {
				beatenTeams[opponent] = true;
				matchScheme.beatenTeams[match-1].team = opponent;
				if (setMatchScheme(match-1, matchScheme.beatenTeams[match-1])) {
					return true;
				}
				else {
					beatenTeams[opponent] = false;
				}
			}
		}
		return false;
	}
	
	private static class MatchScheme {
		public int team;
		public MatchScheme parent;
		public MatchScheme[] beatenTeams;
		
		public MatchScheme(int nTeamsToBeat) {
			this(nTeamsToBeat, null);
		}
		
		private MatchScheme(int nTeamsToBeat, MatchScheme parent) {
			this.parent = parent;
			beatenTeams = new MatchScheme[nTeamsToBeat];
			if (nTeamsToBeat>0) {
				for (int i=0; i<nTeamsToBeat; i++) {
					beatenTeams[i] = new MatchScheme(i, this);
				}
			}
		}
		
		public String toString(int match) {
			String s = Integer.toString(team+1) + " " + Integer.toString(beatenTeams[match].team+1) +"\n";
			for (int i=match+1; i<beatenTeams.length; i++) {
				s += this.beatenTeams[i].toString(match);
			}
			return s;
		}
	}
}
