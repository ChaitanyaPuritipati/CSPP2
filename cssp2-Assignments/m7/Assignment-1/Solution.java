import java.util.*;
class InputValidator {
	private String testinput;
	public InputValidator(String giveninput) {
		this.testinput = giveninput;
	}
	public boolean validateData() {
		final int six = 6;
		return this.testinput.length() > six;
	}
}
public class Solution {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		InputValidator i = new InputValidator(input);
		System.out.println(i.validateData());

	}

}
