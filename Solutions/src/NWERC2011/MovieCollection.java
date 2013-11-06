package NWERC2011;

import io.Kattio;

/**
 * @author David
 */
public class MovieCollection {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		int nTestCases = io.getInt();
		for (int testCase=0; testCase<nTestCases; testCase++) {
			int nMovies = io.getInt();
			int nRequests = io.getInt();
			//int[] movieStack = new int[nMovies+nRequests];
			int[] movieIndexToStackIndexMap = new int[nMovies+1];
			for (int i = 0; i<nMovies; i++) {
				//movieStack[i+nRequests] = i+1;
				movieIndexToStackIndexMap[i+1] = i+nRequests;
			}
			MovieStackCount movieStackCount = new MovieStackCount(0, nMovies+nRequests, nRequests);
			int stackPointer = nRequests;
			while (stackPointer > 0) {
				stackPointer--;
				int movieIndex = io.getInt();
				int stackIndex = movieIndexToStackIndexMap[movieIndex];
				io.print(movieStackCount.nElementsLeftOfIndex(stackIndex)+" ");
				movieStackCount.removeElementAt(stackIndex);
				movieStackCount.addElementAt(stackPointer);
				movieIndexToStackIndexMap[movieIndex] = stackPointer;
			}
			io.print("\n");
		}
		
		io.close();
	}
	
	static class MovieStackCount {
		int numberOfElements, left, right;
		private MovieStackCount L, R;
		
		public MovieStackCount(int left, int right, int firstMovieIndex) {
			this.left = left;
			this.right = right;
			
			if (left<firstMovieIndex)
				if (right>=firstMovieIndex)
					numberOfElements = right-firstMovieIndex+1;
				else
					numberOfElements = 0;
			else
				numberOfElements = right-left+1;
			
			if (left<right) {
				int mid = getMidIndex();
				L = new MovieStackCount(left, mid, firstMovieIndex);
				R = new MovieStackCount(mid+1, right, firstMovieIndex);
			}
		}
		
		private int getMidIndex() {
			return left+(right-left)/2;
		}
		
		public int nElementsLeftOfIndex(int index) {
			int mid = getMidIndex();
			if (index <= mid) {
				if (L == null)
					return 0;
				else
					return L.nElementsLeftOfIndex(index);
			}
			else {
				if (L == null)
					return R.nElementsLeftOfIndex(index);
				else
					return L.numberOfElements+R.nElementsLeftOfIndex(index);
			}
		}
		
		//Assumes an element existed in that position before
		public void removeElementAt(int index) {
			if (index <= getMidIndex()) {
				if (L != null)
					L.removeElementAt(index);
			}
			else {
				if (R != null)
					R.removeElementAt(index);
			}
			numberOfElements--;
		}
		
		public void addElementAt(int index) {
			if (index <= getMidIndex()) {
				if (L != null)
					L.addElementAt(index);
			}
			else {
				if (R != null)
					R.addElementAt(index);
			}
			numberOfElements++;
		}
	}
}