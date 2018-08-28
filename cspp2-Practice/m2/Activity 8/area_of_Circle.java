import java.util.*;
public class area_of_Circle{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int input_radius = input.nextInt();
		System.out.println(area(input_radius));
	}
	static double area(int radius){
		double area = pi()*radius*radius;
		return area;
	}
	static double pi(){
		return 3.14;
	}
}