package Kattiss;

import io.Kattio;

public class PizzaDelivery {

	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		int n = io.getInt();
		for (int i = 0; i < n; i++){
			run(io);
		}
		io.close();
	}

	public static void run(Kattio io) {
		int x = io.getInt();
		int y = io.getInt();
		int[] xValues = new int[x];
		int[] yValues = new int[y];
		for (int y1 = 0; y1 < y; y1++) {
			for (int x1 = 0; x1 < x; x1++) {
				int value = io.getInt();
				xValues[x1] += value;
				yValues[y1] += value;
			}
		}
		int xPoint = findAvg(xValues);
		int xCost = findDist(xValues,xPoint);
		int yPoint = findAvg(yValues);
		int yCost = findDist(yValues,yPoint);
		io.println(xCost + yCost + " blocks");
	}

	public static int findAvg(int[] value) {
		int sum = 0;
		for (int i = 0; i < value.length; i++) {
			sum += value[i];
		}
		int sum2 = 0;
		for (int i = 0; i < value.length; i++) {
			sum2 += value[i];
			if (sum2 >= sum / 2.0) {
				return i;
			}
		}
		return -1;
	}

	public static int findDist(int[] points, int index) {
		int sum = 0;
		for (int i = 0; i < points.length; i++) {
			int dist = Math.abs(i - index);
			sum += dist * points[i];
		}
		return sum;
	}

}
