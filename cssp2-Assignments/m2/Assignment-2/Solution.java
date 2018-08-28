import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused.
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		/*
		Main function starts here
		*/
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 * @param      c     { parameter_description }
	 */
	static void rootsOfQuadraticEquation(final int a, final int b, final int c){
		double determinant = Math.sqrt((b * b) - (4 * a * c));
		if (determinant >= 0) {
			double root_1 = ((- b) + determinant)/(2 * a);
            double root_2 = ((- b) - determinant)/(2 * a);
            System.out.println(root_1 + " " + root_2);
		}
	}
}
