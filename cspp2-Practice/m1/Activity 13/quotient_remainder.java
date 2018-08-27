public class quotient_remainder
{
	public static void main(String[] args)
	{
		int first_num = 10;
		int second_num = 20;
		int quotient = second_num/first_num;
		int remainder = second_num%first_num;
		System.out.println("Quotient of "+Integer.toString(first_num)+" "+"and"+" "+Integer.toString(second_num)+" is "+Integer.toString(quotient));
        System.out.println("Remainder of "+Integer.toString(first_num)+" "+"and"+" "+Integer.toString(second_num)+" is "+Integer.toString(remainder));
	}
 
}