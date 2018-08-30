import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main is used to start the program execution }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        final int rows1 = input.nextInt();
        final int columns1 = input.nextInt();
        int[][] arr1 = new int[rows1][columns1];
        for (int row = 0; row < rows1; row++) {
            for (int col = 0; col < columns1; col++) {
                arr1[row][col] = input.nextInt();
            }
        }
        final int rows2 = input.nextInt();
        final int columns2 = input.nextInt();
        int[][] arr2 = new int[rows2][columns2];
        for (int row = 0; row < rows2; row++) {
            for (int col = 0; col < columns2; col++) {
                arr2[row][col] = input.nextInt();
            }
        }
        if (rows1 != rows2 && columns1 != columns2) {
            System.out.println("not possible");
            return;
        }
        int[][] addarr = new int[rows1][columns1];
        for (int row = 0; row < rows1; row++) {
            for (int col = 0; col < columns1; col++) {
                addarr[row][col] = arr1[row][col] + arr2[row][col];
            }
        }
        for (int row = 0; row < rows1; row++) {
            for (int col = 0; col < columns1 - 1; col++) {
                System.out.print(addarr[row][col] + " ");
            }
            System.out.print(addarr[row][columns1 - 1]);
            System.out.println();
        }
    }
}