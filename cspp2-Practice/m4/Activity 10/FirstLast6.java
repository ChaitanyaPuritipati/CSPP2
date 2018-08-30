import java.util.Scanner;
/**
 * { Class is created }.
 */
final class FirstLast6 {
    /**
     * Constructs the object.
     */
    private FirstLast6() {
        //unused
    }
    /**
     * { Main function is created to start the execution of the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(scan.nextLine());
        }
        final int six = 6;
        if (arr[0] == six || arr[size - 1] == six) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
