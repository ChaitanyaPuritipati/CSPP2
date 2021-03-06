import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * { Prints the odd composite numbers between 2 and funcnum }.
     *
     * @param      funcnum  It is of int type.
     */
    static void oddComposites(final int funcnum) {
        final int three = 3; //To remove magical number error.
        for (int i = three; i <= funcnum; i = i + 2) {
            int flag = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                System.out.println(i);
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputnum = scan.nextInt();
        oddComposites(inputnum);
    }
}
