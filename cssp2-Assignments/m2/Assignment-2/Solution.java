import java.util.Scanner;
import java.lang.Math;

public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	static void rootsOfQuadraticEquation(int a, int b, int c){
		double determinant = Math.sqrt((b*b)-(4*a*c));
		if (determinant >= 0){
			double root_1 = ((- b) + determinant)/(2*a);
            double root_2 = ((- b) - determinant)/(2*a);
            System.out.println(root_1 + " " + root_2);
		}
	}
}
