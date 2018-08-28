import java.util.*;
class bigger_equal_smaller{
	public static void main(String[] args) {
		Scanner variable = new Scanner(System.in);
		int variable_A = variable.nextInt();
		int variable_B = variable.nextInt();
        System.out.println(comparision(variable_A, variable_B));
	}
	static String comparision(int a, int b){
		if (a > b) return "Bigger";
		if (a == b) return "Equal";
		if (a < b) return "Smaller";
        return "None";
	}
}