import java.util.Arrays;
class Show {
	String[] movname;
	String[] movdate;
	String[] showseats;
	int size;
	public Show() {
		movname = new String[10];
		movdate = new String[10];
		showseats = new String[10];
		size = 0;
	}
	void resize() {
		movname = Arrays.copyOf(movname, 2 * size);
		movdate = Arrays.copyOf(movdate, 2 * size);
		showseats = Arrays.copyOf(showseats, 2 * size);
	}
	void add(String name, String date, String seats) {
		if (size == movname.length) {
			resize();
		}
		movname[size] = name;
		movdate[size] = date;
		showseats[size] = seats;
		size++;
		System.out.println(movname[size]);
		System.out.println(movdate[size]);
		System.out.println(showseats[size]);
	}
}
