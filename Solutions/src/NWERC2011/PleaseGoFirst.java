package NWERC2011;
import io.Kattio;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author David
 */
public class PleaseGoFirst {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		final int nTestCases = io.getInt();
		for (int i=0; i<nTestCases; i++) {
			int queueSize = io.getInt();
			String queue = io.getWord();
			io.print(getSolution(queueSize, queue)+"\n");
		}
		io.close();
	}
	
	private static int getSolution(int queueSize, String queue) {
		Hashtable<Character, Group> groups = new Hashtable<Character, Group>(queueSize);
		LinkedList<Character> groupOrder = new LinkedList<Character>();
		for (int i = queueSize-1; i>=0; i--) {
			if (groups.containsKey(queue.charAt(i))) {
				groups.get(queue.charAt(i)).size++;
			}
			else {
				groups.put(queue.charAt(i), new Group(i));
				groupOrder.push(queue.charAt(i));
			}
		}
		int nRemovedPersons = 0;
		int nTimeSaves = 0;
		while(!groupOrder.isEmpty()) {
			Group currentGroup = groups.get(groupOrder.pop());
			nTimeSaves += (currentGroup.lastPersonPosition-nRemovedPersons-currentGroup.size+1)*currentGroup.size;
			nRemovedPersons += currentGroup.size;
		} 
		return nTimeSaves*5;
	}
	
	public static class Group {
		public final int lastPersonPosition;
		public int size;
		public Group(final int lastPerson) {
			lastPersonPosition = lastPerson;
			size = 1;
		}
	}
}