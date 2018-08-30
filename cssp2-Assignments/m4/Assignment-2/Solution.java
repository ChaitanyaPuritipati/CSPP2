import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int rows_1 = input.nextInt();
   		int columns_1 = input.nextInt();
   		int arr1[][] = new int[rows_1][columns_1];
   		for (int row=0; row < rows_1; row++) {
   			for (int col=0;col<columns_1;col++) {
   				arr1[row][col] = input.nextInt();
   			}
   		}
   		System.out.println(arr1);
	}
}