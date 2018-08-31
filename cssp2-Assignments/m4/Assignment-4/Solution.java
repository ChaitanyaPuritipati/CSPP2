import java.util.Scanner;
public class Solution {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String inputstring = input.nextLine();
		String reversestring = reverseString(inputstring);	
		System.out.println(reversestring);
	}
	static String reverseString(String funcstring) {
		String outstring = "";
		for (int everyindex = 0; everyindex < funcstring.length(); everyindex++) {
			outstring = funcstring.charAt(everyindex) + outstring;
		}
		return outstring;
	}
}
