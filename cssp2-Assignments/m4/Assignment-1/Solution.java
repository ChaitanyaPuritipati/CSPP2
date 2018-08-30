
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function is used to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        int[] elements = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            elements[i] = sc.nextInt();
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        System.out.println(max);
    }
}
