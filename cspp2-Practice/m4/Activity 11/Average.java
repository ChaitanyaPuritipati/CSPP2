import java.util.Scanner;
/**
 * { Average Class is created }.
 */
final class Average {
    /**
     * Constructs the object.
     */
    private Average() {
        //unused
    }
    /**
     * { Main function is created to start the program execution }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int size = scan.nextInt();
        int[] arr = new int[size];
        int sum = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
            sum = sum + arr[i];
        }
        double avg = sum / size;
        System.out.println(avg);

    }
}
