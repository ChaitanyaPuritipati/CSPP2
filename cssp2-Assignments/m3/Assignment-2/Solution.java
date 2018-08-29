
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
        	int temp = i;
        	while(temp % 10 != 0){
                if (temp == 7) {
                	count = count + 1;
                }
                temp = temp/10;
        	}
        } System.out.println(count);
    }
}