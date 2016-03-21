import java.util.Arrays;


public class OpeningCeremony {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int n = io.getInt();
		
		int[] heights = new int[n];
		for(int i = 0; i < n; i++)
			heights[i] = io.getInt();
		
		Arrays.sort(heights);
		
		int h = 0;
		int bombs = 0;
		int high = n - 1;
		int low = 0;
		
		while(high >= low) {
			int next = heights[high] - h;
			int size = high - low + 1;
			
			if(next > size) {
				high--;
				bombs++;
			} else {
				int charges = (heights[low] - h);
				bombs += charges;
				h += charges;
				while(high >= low && heights[low] <= h)
					low++;
			}
		}
		
		io.println(bombs);
		
		io.close();
	}
}

/*

6
2 1 8 8 2 3

5
1 1 1 1 10

*/