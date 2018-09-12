import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        BookYourShow bookshow = new BookYourShow();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String line = input.nextLine();
            String[] tokens = line.split(" ", 2);
            switch (tokens[0]) {
            case "add":
                String[] par = tokens[1].split(",", three);
                bookshow.add(par[0], par[1], par[2]);
                break;
            case "book":
                par = tokens[1].split(",", five);
                bookshow.book(par[0], par[1], par[2], par[three], par[four]);
                break;
            case "print":
                par = tokens[1].split(",");
                System.out.println(bookshow.print(par[0], par[1], par[2]));
                break;
            case "get":
                par = tokens[1].split(",");
                System.out.println(bookshow.get(par[0], par[1]));
                break;
            case "showAll":
                bookshow.showAll();
                break;
            default:
            }
        }
    }
}
