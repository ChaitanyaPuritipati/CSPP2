import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * { Main function is created to start the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /*
        Main function starts here.
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
     * { function_description }.
     *
     * @param      a     { It is of int type }
     * @param      b     { It is of int type }
     * @param      c     { It is of int type }
     */
    static void rootsOfQuadraticEquation(final int a, final int b,
        final int c) {
        final int four = 4;
        double determinant = Math.sqrt((b * b) - (four * a * c));
        if (determinant >= 0) {
            double root1 = ((-b) + determinant) / (2 * a);
            double root2 = ((-b) - determinant) / (2 * a);
            System.out.println(root1 + " " + root2);
        }
    }
}
