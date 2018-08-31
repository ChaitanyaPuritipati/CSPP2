import java.util.Scanner;
/**
 * Class for concatinate.
 */
final class Concatinate {
    /**
     * Constructs the object.
     */
    private Concatinate() {
        //unused
    }
    /**
     * { Main function is created to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        String inputstring = input.nextLine();
        System.out.println(concat(inputstring));
    }
    /**
     * { concat function is created to concatinate a certain string }.
     *
     * @param      teststring  It is of string type
     *
     * @return     { Return is concatinated string }.
     */
    static String concat(final String teststring) {
        teststring = "Hello " + teststring + "!";
        return teststring;
    }
}
