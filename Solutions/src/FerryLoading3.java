import java.util.ArrayList;
import java.util.PriorityQueue;


public class FerryLoading3 {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int t = io.getInt();
		
		for(int i = 0; i < t; i++)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		PriorityQueue<Car> left = new PriorityQueue<>(), right = new PriorityQueue<>();
		
		int n = io.getInt();
		int t = io.getInt();
		int m = io.getInt();
		long[] times = new long[m];
		boolean boatLeft = true;
		
		for(int i = 0; i < m; i++) {
			int time = io.getInt();
			String r = io.getWord();
			if(r.equals("right"))
				right.add(new Car(time, i));
			else
				left.add(new Car(time, i));
		}
		
		int time = 0;
		while(!left.isEmpty() || !right.isEmpty()) {
			
			PriorityQueue<Car> currentSide = boatLeft ? left : right;
			PriorityQueue<Car> otherSide = boatLeft ? right : left;
			ArrayList<Car> cars = new ArrayList<>();
			
			if(!currentSide.isEmpty() && currentSide.peek().time <= time) {
				fill(cars, time, currentSide, n);
			} else if(!otherSide.isEmpty() && otherSide.peek().time <= time) {
				time += t;
				boatLeft = !boatLeft;
				fill(cars, time, otherSide, n);
			} else {
				//--- set the boat to the time where it will start to pick up new passengers.
				if(currentSide.isEmpty()) {
					time = t + otherSide.peek().time;
					boatLeft = !boatLeft;
				} else if(otherSide.isEmpty())
					time = currentSide.peek().time;
				else {
					if(currentSide.peek().time > otherSide.peek().time) {
						time = t + otherSide.peek().time;
						boatLeft = !boatLeft;
					} else
						time = currentSide.peek().time;
				}
				continue;
			}
			
			time += t;
			boatLeft = !boatLeft;
			for(Car c : cars)
				times[c.index] = time;
		}
		
		
		for(int i = 0; i < m; i++)
			io.println(times[i]);
		
		io.println();
	}
	

	private static void fill(ArrayList<Car> cars, int time,
			PriorityQueue<Car> currentSide, int n) {
		int c = 0;
		while(c < n && !currentSide.isEmpty() && currentSide.peek().time <= time) {
			cars.add(currentSide.poll());
			c++;
		}
	}


	private static class Car implements Comparable<Car> {
		public int time, index;
		
		public Car(int time, int i) {
			this.time = time;
			index = i;
		}

		@Override
		public int compareTo(Car o) {
			return Integer.compare(time, o.time);
		}
	}
}


/*
2
2 10 10
0 left
10 left
20 left
30 left
40 left
50 left
60 left
70 left
80 left
90 left
2 10 3
10 right
25 left
40 left



*/