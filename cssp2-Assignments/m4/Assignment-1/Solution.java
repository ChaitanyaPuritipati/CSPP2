
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] elements = new int[n];
		int max = 0;
 		for (int i = 0; i < n; i++) {
 			elements[i] = sc.nextInt();
 			if (elements[i] > max) {
 				max = elements[i];
 			}
		}
        System.out.println(max);
	}
}
