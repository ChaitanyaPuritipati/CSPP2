
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    private Solution() {
        //unused
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        final int small = Math.min(n1, n2);
        final int large = Math.max(n1, n2);
        System.out.println(gcd(small,large));
    }
    static int gcd(final int a, final int b){
        for (int i = a; i>=2; i--) {
            if (b%i == 0 && a%i == 0) {
                return i;
            }

        }
        return 1;
    }
}
