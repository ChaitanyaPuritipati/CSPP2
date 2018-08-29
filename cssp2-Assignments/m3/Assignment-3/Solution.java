
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        
        System.out.println(gcd(n1,n2));
    }
    static int gcd(int a, int b){
    	if (a > b) {
    		if(a%b == 0){
    			return b;
    		}
    	     return 1;
    	}
    	else if (a < b) {
             if (b%a == 0) {
                 return a;
             }
             return 1;
    	}
    	else {
    		return a;
    	}
    }
}
