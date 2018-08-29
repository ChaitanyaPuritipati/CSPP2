/**
 * Class for convertto while loop.
 */
final class ConverttoWhileLoop {
    /**
     * Constructs the object.
     */
    private ConverttoWhileLoop() {
     //Unused
    }
    /**
     * { Main function to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int ten = 10;
        for (int i = 2; i <= ten; i = i + 2) {
            System.out.println(i);
        } System.out.println("GoodBye!");
    }
}
