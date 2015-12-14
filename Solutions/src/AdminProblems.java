import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class AdminProblems {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		int t = io.getInt();
		for(int i =0; i < t; i++)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		HashMap<String, Car> cars = new HashMap<>();
		HashMap<String, Spy> spies = new HashMap<>();
		PriorityQueue<Event> events = new PriorityQueue<>();
		int ncars = io.getInt();
		int n = io.getInt();
		
		for(int i =0; i < ncars; i++)
			cars.put(io.getWord(), new Car(io.getDouble(),io.getDouble(),io.getDouble()));
		
		for(int i =0; i < n; i ++)
			events.add(new Event(io.getInt(), io.getWord(), io.getWord(), io.getWord()));
		
		for(Event ev : events) {
			String spy = ev.spy;
			String type = ev.type;
			Spy s = spies.get(spy);
			if(s == null) {
				s = new Spy();
				spies.put(spy, s);
			}
			
			switch(type) {
			case "p":
				if(s.car != null)
					s.inconsistent = true;
				else {
					s.car = ev.data;
					s.cost += cars.get(s.car).rent;
				}
				break;
			case "r":
				if(s.car == null)
					s.inconsistent = true;
				else {
					s.cost += Math.ceil(cars.get(s.car).mile * Double.parseDouble(ev.data));
					s.car = null;
				}
				break;
			case "a":
				if(s.car == null)
					s.inconsistent = true;
				else {
					s.cost += Math.ceil(cars.get(s.car).price * Double.parseDouble(ev.data)/100);
				}
				break;
			}
		}
		
		TreeSet<String> strings = new TreeSet<>();
		strings.addAll(spies.keySet());
		
		for(String k : strings) {
			Spy s = spies.get(k);
			io.append(k);
			io.append(' ');
			if(s.inconsistent || s.car != null)
				io.println("INCONSISTENT");
			else
				io.println(s.cost);
		}
	}
	
	private static class Event implements Comparable<Event>{
		int time;
		String spy;
		String type;
		String data;
		public Event(int int1, String word, String word2, String word3) {
			time = int1;
			spy = word;
			type = word2;
			data = word3;
		}
		@Override
		public int compareTo(Event arg0) {
			return Integer.compare(time, arg0.time);
		}
	}
	
	private static class Spy {
		public long cost;
		public String car;
		public boolean inconsistent;
	}
	
	private static class Car {
		public double price, rent, mile;
		public Car(double p, double r, double m) {
			price = p;
			rent = r;
			mile = m;
		}
	}
}


/*
1
2 8
bmw 5000 150 10
jaguar 7000 200 25
10 mallory p bmw
15 jb p jaguar
20 jb r 500
35 badluckbrian a 100
50 mallory a 10
55 silva p jaguar
60 mallory r 100
110 silva a 30


*/