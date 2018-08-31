import static java.lang.Math.pow;
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
		for(int i = 0; i < n; i++){
			String s = sc.next();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	static String binaryToDecimal(String funcstring) {
		int decimalnum = 0;
		for (int i = 0; i < funcstring.length(); i++) {
			decimalnum = decimalnum + ((Integer.parseInt(funcstring.charAt(i) + ""))*((int)Math.pow(2, funcstring.length()-i-1)));
		}
		decimalnum = (int) decimalnum;
		return (decimalnum + "");
	}
}
