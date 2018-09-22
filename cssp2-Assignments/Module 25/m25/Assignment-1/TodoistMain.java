import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
	private String tasktitle;
	private String taskownername;
	private int tasktime;
	private boolean importance;
	private boolean urgency;
	private String taskstatus;
	Task(String title, String name, int time, boolean imp, boolean urgent, String status) throws Exception {
		if (title.equals("")) {
			throw new Exception("Title not provided");
		}
		if (!(time > 0)) {
			throw new Exception("Invalid timeToComplete " + time);
		}
		if (!(status.equals("done") || status.equals("todo"))) {
			throw new Exception("Invalid status " + status);
		}
		this.tasktitle = title;
		this.taskownername = name;
		this.tasktime = time;
		this.importance = imp;
		this.urgency = urgent;
		this.taskstatus = status;
	}
	public String gettasktile() {
		return this.tasktitle;
	}
	public String gettaskowner() {
		return this.taskownername;
	}
	public int gettasktime() {
		return this.tasktime;
	}
	public boolean gettaskimp() {
		return this.importance;
	}
	public boolean gettaskurgency() {
		return this.urgency;
	}
	public String gettaskstatus() {
		return this.taskstatus;
	}
	public String toString() {
		String imp = "";
		String urg = "";
		if (gettaskimp()) {
			imp = "Important";
		} else {
			imp = "Not Important";
		}
		if (gettaskurgency()) {
			urg = "Urgent";
		} else {
			urg = "Not Urgent";
		}
		return gettasktile() + ", " + gettaskowner() + ", " + gettasktime() + ", " + imp + ", " + urg + ", " + gettaskstatus();
	}

}
class Todoist {
	private Task[] tasks;
	private int size;
	Todoist() {
		final int ten = 10;
		tasks = new Task[ten];
		size = 0;
	}
	public void resize() {
		tasks = Arrays.copyOf(tasks, 2 * size);
	}
	public void addTask(Task newtask) {
		if (size == tasks.length) {
			resize();
		}
		tasks[size++] = newtask;
	}
	public String toString() {
		String arraystring = "";
		for (int i = 0; i < size - 1; i++) {
			arraystring = arraystring + tasks[i].toString() + "\n";
		}
		arraystring = arraystring + tasks[size - 1].toString();
		return arraystring;
	}
	public Task getNextTask(String inputname) {
		for (int i = 0; i < size; i++) {
			if (tasks[i].gettaskowner().equals(inputname) && tasks[i].gettaskstatus().equals("todo") && tasks[i].gettaskimp() == true && tasks[i].gettaskurgency() == false) {
				return tasks[i];
			}
		}
		for (int j = 0; j < size; j++) {
			if (tasks[j].gettaskowner().equals(inputname) && tasks[j].gettaskstatus().equals("todo") && tasks[j].gettaskimp() == true && tasks[j].gettaskurgency() == true) {
				return tasks[j];
			}
		}
		return null;
	}
	public Task[] getNextTask(String inputname, int count) {
		Task[] nexttasks = new Task[count];
		int nextsize = 0;
		for (int i = 0; i < size; i++) {
			if(nexttasks.length == nextsize) {
				return nexttasks;
			}
			if (tasks[i].gettaskowner().equals(inputname) && tasks[i].gettaskstatus().equals("todo") && tasks[i].gettaskimp() == true && tasks[i].gettaskurgency() == false) {
				 nexttasks[nextsize] = tasks[i];
				 nextsize++;
			}
		}
		for (int j = 0; j < size; j++) {
			if(nexttasks.length == nextsize) {
				return nexttasks;
			}
			if (tasks[j].gettaskowner().equals(inputname) && tasks[j].gettaskstatus().equals("todo") && tasks[j].gettaskimp() == true && tasks[j].gettaskurgency() == true) {
				 nexttasks[nextsize] = tasks[j];
				 nextsize++;
			}
		}
		return nexttasks;
	}
	public int totalTime4Completion() {
		int totaltime = 0;
		for(int i = 0; i < size; i++) {
			if(tasks[i].gettaskstatus().equals("todo"))
            totaltime = totaltime + tasks[i].gettasktime();
		}
		return totaltime;
	}
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			case "add-task":
				testAddTask(todo, tokens);
				break;
			case "print-todoist":
				System.out.println(todo);
				break;
			case "get-next":
				System.out.println(todo.getNextTask(tokens[1]));
				break;
			case "get-next-n":
				int n = Integer.parseInt(tokens[2]);
				Task[] tasks = todo.getNextTask(tokens[1], n);
				System.out.println(Arrays.deepToString(tasks));
				break;
			case "total-time":
				System.out.println(todo.totalTime4Completion());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * method to test add task.
	 *
	 * @param      todo    The todo
	 * @param      tokens  The tokens
	 */
	public static void testAddTask(final Todoist todo, final String[] tokens) {
		try {
			todo.addTask(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * method to test the creation of task object.
	 *
	 * @param      tokens  The tokens
	 */
	public static void testTask(final String[] tokens) {
		try {
			System.out.println(createTask(tokens));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Creates a task object.
	 *
	 * @param      tokens     The tokens
	 *
	 * @return     Task object
	 *
	 * @throws     Exception  if task inputs are invalid
	 */
	public static Task createTask(final String[] tokens) throws Exception {
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		           title, assignedTo, timeToComplete, important, urgent, status);
	}

	/**
	 * main method.
	 *
	 * @param      args  The command line arguments
	 */
	public static void main(final String[] args) {
		startTest();
	}
}
