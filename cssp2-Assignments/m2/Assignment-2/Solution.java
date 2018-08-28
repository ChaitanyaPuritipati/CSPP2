import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		/*
		Main function starts here
		*/
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	static void rootsOfQuadraticEquation(int test_a, int test_b, int test_c){
		double determinant = Math.sqrt((test_b*test_b)-(4*test_a*test_c));
		if (determinant >= 0){
			double root_1 = ((- test_b) + determinant)/(2*test_a);
            double root_2 = ((- test_b) - determinant)/(2*test_a);
            System.out.println(root_1 + " " + root_2);
		}
	}
}
