import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */
class Task {
    /**
     * { tasktitle }.
     */
    private String tasktitle;
    /**
     * { ownername }.
     */
    private String taskownername;
    /**
     * { time }.
     */
    private int tasktime;
    /**
     * { importance }.
     */
    private boolean importance;
    /**
     * { urgency }.
     */
    private boolean urgency;
    /**
     * { status }.
     */
    private String taskstatus;
    /**
     * Constructs the object.
     *
     * @param      title   The title
     * @param      name    The name
     * @param      time    The time
     * @param      imp     The imp
     * @param      urgent  The urgent
     * @param      status  The status
     * @throws     Exception The Exception
     */
    Task(final String title, final String name,
         final int time, final boolean imp,
         final boolean urgent,
         final String status) throws Exception {
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
    /**
     * { gettitle }.
     *
     * @return     { String }
     */
    public String gettasktile() {
        return this.tasktitle;
    }
    /**
     * { getownername }.
     *
     * @return     { String }
     */
    public String gettaskowner() {
        return this.taskownername;
    }
    /**
     * { gettasktime }.
     *
     * @return     { String }
     */
    public int gettasktime() {
        return this.tasktime;
    }
    /**
     * { getimp }.
     *
     * @return     { boolean }
     */
    public boolean gettaskimp() {
        return this.importance;
    }
    /**
     * { taskurgency }.
     *
     * @return     { boolean }
     */
    public boolean gettaskurgency() {
        return this.urgency;
    }
    /**
     * { taskstatus }.
     *
     * @return     { String }
     */
    public String gettaskstatus() {
        return this.taskstatus;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
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
        return gettasktile() + ", " + gettaskowner()
               + ", " + gettasktime() + ", " + imp
               + ", " + urg + ", " + gettaskstatus();
    }

}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * { tasks array }.
     */
    private Task[] tasks;
    /**
     * { size }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Todoist() {
        final int ten = 10;
        tasks = new Task[ten];
        size = 0;
    }
    /**
     * { toresize }.
     */
    public void resize() {
        tasks = Arrays.copyOf(tasks, 2 * size);
    }
    /**
     * Adds a task.
     *
     * @param      newtask  The newtask
     */
    public void addTask(final Task newtask) {
        if (size == tasks.length) {
            resize();
        }
        tasks[size++] = newtask;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String arraystring = "";
        for (int i = 0; i < size - 1; i++) {
            arraystring = arraystring + tasks[i].toString() + "\n";
        }
        arraystring = arraystring + tasks[size - 1].toString();
        return arraystring;
    }
    /**
     * Gets the next task.
     *
     * @param      inputname  The inputname
     *
     * @return     The next task.
     */
    public Task getNextTask(final String inputname) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].gettaskowner().equals(inputname)
                    && tasks[i].gettaskstatus().equals("todo")
                    && tasks[i].gettaskimp()
                    && (!tasks[i].gettaskurgency())) {
                return tasks[i];
            }
        }
        for (int j = 0; j < size; j++) {
            if (tasks[j].gettaskowner().equals(inputname)
                    && tasks[j].gettaskstatus().equals("todo")
                    && tasks[j].gettaskimp()
                    && tasks[j].gettaskurgency()) {
                return tasks[j];
            }
        }
        return null;
    }
    /**
     * Gets the next task.
     *
     * @param      inputname  The inputname
     * @param      count      The count
     *
     * @return     The next task.
     */
    public Task[] getNextTask(final String inputname, final int count) {
        Task[] nexttasks = new Task[count];
        int nextsize = 0;
        for (int i = 0; i < size; i++) {
            if (nexttasks.length == nextsize) {
                return nexttasks;
            }
            if (tasks[i].gettaskowner().equals(inputname)
                    && tasks[i].gettaskstatus().equals("todo")
                    && tasks[i].gettaskimp()
                    && !tasks[i].gettaskurgency()) {
                nexttasks[nextsize] = tasks[i];
                nextsize++;
            }
        }
        for (int j = 0; j < size; j++) {
            if (nexttasks.length == nextsize) {
                return nexttasks;
            }
            if (tasks[j].gettaskowner().equals(inputname)
                    && tasks[j].gettaskstatus().equals("todo")
                    && tasks[j].gettaskimp()
                    && tasks[j].gettaskurgency()) {
                nexttasks[nextsize] = tasks[j];
                nextsize++;
            }
        }
        return nexttasks;
    }
    /**
     * { time4completion }.
     *
     * @return     { int }
     */
    public int totalTime4Completion() {
        int totaltime = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].gettaskstatus().equals("todo")) {
                totaltime = totaltime + tasks[i].gettasktime();
            }
        }
        return totaltime;
    }
}
/**
 * Class for todoist main.
 */
final class TodoistMain {
    /**
     * Constructs the object.
     */
    private TodoistMain() {
        //unused
    }

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
        final int six = 6;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[three]);
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];
        return new Task(
                   title, assignedTo,
                   timeToComplete, important,
                   urgent, status);
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
