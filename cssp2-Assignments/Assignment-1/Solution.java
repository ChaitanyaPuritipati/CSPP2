import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
        Scanner string = new Scanner(System.in);
        String username = string.nextLine();
        Scanner number = new Scanner(System.in);
        int rollnumber = number.nextInt();
		System.out.println("Name : " + username + " and Roll Number : " + Integer.toString(rollnumber));
	}
}