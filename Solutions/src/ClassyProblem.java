import java.util.TreeSet;


public class ClassyProblem {
	public static void main(String[] args) {
		Kattio io = new Kattio();
		
		int t = io.getInt();
		for(int i = 0; i < t; i++)
			run(io);
		
		io.close();
	}

	private static void run(Kattio io) {
		int n = io.getInt();
		TreeSet<Person> persons = new TreeSet<>();
		for(int i = 0; i < n; i++) {
			String name = io.getWord();
			name = name.substring(0, name.length() - 1);
			String[] classes = io.getWord().split("-");
			io.getWord();
			Person p = new Person(name, classes);
			persons.add(p);
		}
		for(Person pp : persons.descendingSet())
			io.println(pp.name);
		for(int i = 0; i < 30; i++)
			io.print('=');
		io.println();
	}
	
	private static class Person implements Comparable<Person>{
		private byte[] classes;
		private String name;
		
		public Person(String name, String[] clazzes) {
			this.name = name;
			classes = new byte[clazzes.length];
			int a = 0;
			for(String s : clazzes){
				if(s.equals("lower"))
					classes[a++] = 0;
				else if(s.equals("middle"))
					classes[a++] = 1;
				else
					classes[a++] = 2;
			}
		}
		

		@Override
		public int compareTo(Person arg0) {
			byte[] other = arg0.classes;
			int maxLength = Math.max(other.length, classes.length);
			for(int i = 0; i < maxLength; i++) {
				byte o = get(other, i);
				byte t = get(classes, i);
				if(o == t)
					continue;
				else
					return t - o;
			}
			int r =name.compareToIgnoreCase(arg0.name);
			return -r;
		}
		
		private static byte get(byte[] bs, int i) { return i < bs.length ? bs[bs.length - i - 1] : 1; }
		
	}
}

/*

1
5
mom: upper-upper-lower-middle class
dad: middle-middle-middle-lower-middle class
queenelizabeth: upper-upper-upper class
chair: lower-lower class
unclebob: middle-middle-lower-middle class




*/
