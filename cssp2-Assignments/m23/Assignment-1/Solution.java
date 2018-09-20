import java.util.Scanner;
import java.io.File;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            double max = 0;
            String file1 = "";
            String file2 = "";
            Scanner scan = new Scanner(System.in);
            String dirname = scan.nextLine();
            File dir = new File(dirname);
            File[] files = dir.listFiles();
            if (files.length == 0) {
                System.out.println("empty directory");
                return;
            }
            System.out.print("\t" + "\t");
            for (File file : files) {
                System.out.print(file.getName() + "\t");
            }
            System.out.println();
            for (File file : files) {
                System.out.print(file.getName() + "\t");
                for (File eachfile : files) {
                    Distance map1 = new Distance(file);
                    Distance map2 = new Distance(eachfile);
                    System.out.print(map1.angle(map2.getMap()) + "\t" + "\t");
                    if (map1.angle(map2.getMap()) > max
                            && !(file.getName().equals(eachfile.getName()))) {
                        max = map1.angle(map2.getMap());
                        file1 = file.getName();
                        file2 = eachfile.getName();
                    }
                }
                System.out.println();
            }
            System.out.println("Maximum similarity is between "
                               + file1 + " and " + file2);
        } catch (Exception e) {
            System.out.println("empty directory");
            return;
        }
    }

}