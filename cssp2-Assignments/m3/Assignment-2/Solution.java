import java.util.Scanner;
/**
 * { Class is created }.
 */
public final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        final int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
        	int testnum = i;
        	while(testnum > 0) {
        		int temp = testnum%10;
                if (temp == 7) {
                	count = count + 1;
                }
                testnum = testnum / 10;
        	}
        } System.out.println(count);
    }
}
