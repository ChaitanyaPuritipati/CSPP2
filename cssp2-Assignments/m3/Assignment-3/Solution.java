
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
     * { Main function is created to start the execution }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        final int small = Math.min(n1, n2);
        final int large = Math.max(n1, n2);
        System.out.println(gcd(small, large));
    }
    /**
     * { gcd function is static and is used to find the gcd of two numbers }.
     * @param      a     { It is of int type and a smaller value }.
     * @param      b     { It is of int type and a larger value }.
     */
    static int gcd(final int a, final int b) {
        for (int i = a; i>=2; i--) {
            if (b%i == 0 && a%i == 0) {
                return i;
            }

        }
        return 1;
    }
}
