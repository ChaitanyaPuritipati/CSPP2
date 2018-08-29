import java.util.Scanner;
/**
 * { Class is created }.
 */
final class Pattern {
    /**
     * Constructs the object.
     */
    private Pattern() {
      //unused
    }
    /**
     * { Main function is created to start the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int linenum = input.nextInt();
        for (int i = 1; i <= linenum; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            } System.out.println();
        }
    }
}
