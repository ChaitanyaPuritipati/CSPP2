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
	Task(String title, String name, int time, boolean imp, boolean urgent, String status) {
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
// class 
/**
 * Class for todoist main.
 */
public class TodoistMain {

	/**
	 * Starts a test.
	 */
	public static void startTest() {
		// Todoist todo = new Todoist();
		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			String[] tokens = s.nextLine().split(",");
			switch (tokens[0]) {
			case "task":
				testTask(tokens);
				break;
			// case "add-task":
			// 	testAddTask(todo, tokens);
			// 	break;
			// case "print-todoist":
			// 	System.out.println(todo);
			// 	break;
			// case "get-next":
			// 	System.out.println(todo.getNextTask(tokens[1]));
			// 	break;
			// case "get-next-n":
			// 	int n = Integer.parseInt(tokens[2]);
			// 	Task[] tasks = todo.getNextTask(tokens[1], n);
			// 	System.out.println(Arrays.deepToString(tasks));
			// 	break;
			// case "total-time":
			// 	System.out.println(todo.totalTime4Completion());
			// 	break;
			default:
				break;
			}
		}
	}

	// /**
	//  * method to test add task.
	//  *
	//  * @param      todo    The todo
	//  * @param      tokens  The tokens
	//  */
	// public static void testAddTask(final Todoist todo, final String[] tokens) {
	// 	try {
	// 		todo.addTask(createTask(tokens));
	// 	} catch (Exception e) {
	// 		System.out.println(e.getMessage());
	// 	}
	// }

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
