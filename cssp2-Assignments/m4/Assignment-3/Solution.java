import java.lang.Math;
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
			// System.out.println(s);
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static String binaryToDecimal(String funcstring) {
		System.out.println(funcstring);
		double decimalnum = 0;
		for (int i = (funcstring.length() - 1); i >= 0; i--) {
			decimalnum = decimalnum + (Integer.parseInt(funcstring.charAt(i) + ""))*(Math.pow(2, i));
		}
		return (decimalnum + "");
	}
}
