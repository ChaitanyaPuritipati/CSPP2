import java.util.Scanner;
/**
 * { Class is created }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){
        //unused
    }
    /**
     * { Main function is created to start execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        final int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int testnum = i;
            while (testnum > 0) {
                final int ten = 10;
                final int seven = 7;
                int temp = testnum % ten;
                if (temp == seven) {
                    count = count + 1;
                }
                testnum = testnum / ten;
            }
        } System.out.println(count);
    }
}
