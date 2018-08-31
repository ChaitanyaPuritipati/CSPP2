
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
			System.out.println(s);
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static String binaryToDecimal(String funcstring) {
		System.out.println(funcstring);
		int decimalnum = 0;
		for (int i = funcstring.length() - 1; i >= 0; i--) {
			System.out.println(Integer.parseInt(funcstring.charAt(i)+""));
			// decimalnum = decimalnum + Math.pow(2, Integer.parseInt(funcstring.charAt(i)));
		}
		return String.valueOf(decimalnum);
	}
}
