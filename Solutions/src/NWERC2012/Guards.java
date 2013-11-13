package NWERC2012;

import io.Kattio;

/**
 * @author David
 */
public class Guards {
	private static final Kattio io = new Kattio(System.in);
	
	public static void main(String[] args) {
		readWingRecursively(1);
		io.print(guardCount +"\n");
		//Uncomment to see guard position (which halls the guard are in)
		/*for (int i = 0; i < guardInHall.length; i++) {
			if (guardInHall[i])
				io.print(i +"\n");
		}*/
		io.close();
	}
	
	static boolean[] guardInHall = new boolean[10001];
	static int guardCount = 0;
	
	private static void readWingRecursively(int entranceIndex) {
		int nHalls = io.getInt();
		int nCorridors = io.getInt();
		int nWingExtensions = io.getInt();
		int[] hallIndices = new int[nHalls];
		hallIndices[0] = entranceIndex;
		Edge[] corridors = new Edge[nCorridors];
		Edge[][] corridorsConnectedToHall = new Edge[nHalls][9];
		for (int i = 0; i < corridors.length; i++) {
			corridors[i] = new Edge(io.getInt(), io.getInt());
			connectCorridorToHall(corridorsConnectedToHall, addHall(hallIndices, corridors[i].vertex1), corridors[i]);
			connectCorridorToHall(corridorsConnectedToHall, addHall(hallIndices, corridors[i].vertex2), corridors[i]);
		}
		int nGuardsInCurrentWing = 0;
		for (int i = 0; i < nWingExtensions; i++) {
			int vertex1 = io.getInt();
			int vertex2 = io.getInt();
			readWingRecursively(vertex2);
			if (!guardInHall[vertex2]) {
				guardInHall[vertex1] = true;
				nGuardsInCurrentWing++;
			}
		}
		int nAdditionalGuards = 0;
		while (!canSolveWing(hallIndices, corridors, corridorsConnectedToHall, nAdditionalGuards, 0)) {
			nAdditionalGuards++;
		}
		guardCount += nGuardsInCurrentWing + nAdditionalGuards;
	}
	
	private static boolean canSolveWing(int[] hallIndices, Edge[] corridors, Edge[][] corridorsConnectedToHall, int nGuards, int firstPossibleGuardIndex) {
		if (nGuards == 0) {
			return checkSolution(corridors);
		}
		for (int internalHallIndex = firstPossibleGuardIndex; internalHallIndex < hallIndices.length; internalHallIndex++) {
			if (!guardInHall[hallIndices[internalHallIndex]]) {
				guardInHall[hallIndices[internalHallIndex]] = true;
				if (canSolveWing(hallIndices, corridors, corridorsConnectedToHall, nGuards-1, internalHallIndex+1)) {
					return true;
				}
				guardInHall[hallIndices[internalHallIndex]] = false;
			}
		}
		return false;
	}
	
	private static boolean checkSolution(Edge[] corridors) {
		for (int i = 0; i < corridors.length; i++) {
			if(!corridors[i].isGuarded())
				return false;
		}
		return true;
	}

	private static void connectCorridorToHall(Edge[][] corridorsConnectedToHall, int internalHallIndex, Edge e) {
		for (int corridorIndex = 0; corridorIndex < 9; corridorIndex++) {
			if (corridorsConnectedToHall[internalHallIndex][corridorIndex] == null) {
				corridorsConnectedToHall[internalHallIndex][corridorIndex] = e;
				return;
			}
		}
	}
	
	private static int addHall(int[] hallIndices, int newHallIndex) {
		for (int i = 0; i < hallIndices.length; i++) {
			if (hallIndices[i] == newHallIndex) {
				return i;
			}
			else if (hallIndices[i] == 0) {
				hallIndices[i] = newHallIndex;
				return i;
			}
		}
		return hallIndices.length;
	}
	
	private static class Edge {
		final int vertex1;
		final int vertex2;
		
		public Edge(int v1, int v2) {
			vertex1 = v1;
			vertex2 = v2;
		}
				
		boolean isGuarded() {
			return guardInHall[vertex1] || guardInHall[vertex2];
		}
	}
}