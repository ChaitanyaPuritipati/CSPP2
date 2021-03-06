import java.util.Scanner;
/**
 * { Solution class is created }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function is created to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int numofstrings = input.nextInt();
        for (int i = 0; i < numofstrings; i++) {
            String binarystring = input.next();
            String decimalstring = binaryToDecimal(binarystring);
            System.out.println(decimalstring);
        }
    }
    /**
     * { binaryToDecimal function is to convert binary to decimal }.
     *
     * @param      funcstring  Binary string
     *
     * @return     { Return value is decimal string }.
     */
    static String binaryToDecimal(final String funcstring) {
        int decimalnum = 0;
        for (int i = 0; i < funcstring.length(); i++) {
            int everycharint = (Integer.parseInt(funcstring.charAt(i) + ""));
            int power = (int) Math.pow(2, funcstring.length() - i - 1);
            decimalnum = decimalnum + (everycharint) * (power);
        }
        return (decimalnum + "");
    }
}
