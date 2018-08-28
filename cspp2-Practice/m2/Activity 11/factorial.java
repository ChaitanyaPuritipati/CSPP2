import java.util.*;
class factorial{
	public static void main(String[] args) {
		Scanner input_val = new Scanner(System.in);
		int num = Integer.parseInt(input_val.nextLine());
		if (num >=0) System.out.println(factorial_func(num));
		else System.out.println("Invalid Input");
	}
	static int factorial_func(int a){
		if (a == 0 || a == 1) return 1;
		return a*factorial_func(a-1);
	}
}
