public class swap
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Value of a is:" + Integer.toString(a) + "\n" + "Value of b is:" + Integer.toString(b));
	}
}