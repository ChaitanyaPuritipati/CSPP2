import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    private Solution() {
        //unused.
    }
    /**
     * { Main function to start execution of program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        String inputstring = input.nextLine();
        String reversestring = reverseString(inputstring);
        System.out.println(reversestring);
    }
    /**
     * { reverString function to reverse the string }.
     *
     * @param      funcstring  teststring to loop inside the loop.
     *
     * @return     { return value is of string type }.
     */
    static String reverseString(String funcstring) {
        String outstring = "";
        for (int everyindex = 0; everyindex < funcstring.length(); everyindex++) {
            outstring = funcstring.charAt(everyindex) + outstring;
        }
        return outstring;
    }
}
