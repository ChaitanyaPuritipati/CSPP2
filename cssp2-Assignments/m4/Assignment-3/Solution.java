
// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i <= n; i++){
			String s = sc.nextLine();
			String res = String.valueOf(binaryToDecimal(s));//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static double binaryToDecimal(String funcstring) {
		double decimalnum = 0;
		for (int i = funcstring.length() - 1; i >= 0; i--) {
			decimalnum = decimalnum + Math.pow(2,i);
		}
		return decimalnum;
	}
}
