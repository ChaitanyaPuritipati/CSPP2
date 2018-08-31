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
			String s = sc.next();
			System.out.println(s);
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println("entered after function");
			System.out.println(res);
		}
	}
	static String binaryToDecimal(String funcstring) {
		System.out.println("entered into function");
		double decimalnum = 0;
		for (int i = 0; i < funcstring.length(); i++) {
			decimalnum = decimalnum + (Integer.parseInt(funcstring.charAt(i) + ""))*(Math.pow(2, funcstring.length()-i-1));
		}
		System.out.println("looping done");
		return (decimalnum + "");
	}
}
