import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { Main is used to start the program execution }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int rows_1 = input.nextInt();
        final int columns_1 = input.nextInt();
        int arr1[][] = new int[rows_1][columns_1];
        for (int row=0; row < rows_1; row++) {
            for (int col=0;col<columns_1;col++) {
                arr1[row][col] = input.nextInt();
            }
        }
        final int rows_2 = input.nextInt();
        final int columns_2 = input.nextInt();
        int arr2[][] = new int[rows_2][columns_2];
        for (int row=0; row < rows_2; row++) {
            for (int col=0;col<columns_2;col++) {
                arr2[row][col] = input.nextInt();
            }
        }
        if (rows_1 != rows_2 && columns_1 != columns_2) {
            System.out.println("not possible");
            return;
        }
        int addarr[][] = new int[rows_1][columns_1];
        for (int row = 0; row < rows_1; row++) {
            for (int col = 0; col < columns_1; col++) {
                addarr[row][col] = arr1[row][col] + arr2[row][col];
            }
        }
        for (int row = 0; row < rows_1; row++) {
            for (int col = 0; col < columns_1 - 1; col++) {
                System.out.print(addarr[row][col] + " ");
            }
            System.out.print(addarr[row][columns_1-1]);
            System.out.println();
        }
    }
}