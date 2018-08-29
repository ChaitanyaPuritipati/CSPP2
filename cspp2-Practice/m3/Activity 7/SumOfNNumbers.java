import java.util.Scanner;
/**
 * { New class is created }.
 */
final class SumOfNNumbers {
    /**
     * Constructs the object.
     */
    private SumOfNNumbers() {
        //unused
    }
    /**
     * { Main function is created to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        final int lastnum = Integer.parseInt(input.nextLine());
        int sum = 0;
        for (int i = 1; i <= lastnum; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}
