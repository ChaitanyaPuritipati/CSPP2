
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int small = Math.min(n1, n2);
        int large = Math.max(n1, n2);
        System.out.println(small);
        System.out.println(large);
        System.out.println(gcd(small,large));
    }
    static int gcd(int a, int b){
        for (int i = a; i>= 2; i--) {
        	if (b%i == 0) {
        		return i;
        	}

        }
        return 1;
    }
}
