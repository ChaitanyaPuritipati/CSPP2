import java.util.*;
import java.io.*;
import java.net.*;
public class Solution {
	public static void main(String[] args) {
		double max = 0;
		String file1 = "";
		String file2 = "";
		Scanner scan = new Scanner(System.in);
		String dirname = scan.nextLine();
		File dir = new File(dirname);
		File[] files = dir.listFiles();
		for (File file : files) {
			for (File eachfile : files) {
				Distance map1 = new Distance(file);
				// System.out.println(map1.getNumOfLines() + " lines  ");
				// System.out.println(map1.getNumOfWords() + " words  ");
				// System.out.println(map1.getNumOfDistinctWords() + " distinct words");
				// System.out.println(map1.norm() + " Euclidean norm\n");

				Distance map2 = new Distance(eachfile);
				// System.out.println(map2.getNumOfLines() + " lines  ");
				// System.out.println(map2.getNumOfWords() + " words  ");
				// System.out.println(map2.getNumOfDistinctWords() + " distinct words");
				// System.out.println(map2.norm() + " Euclidean norm\n");

				// System.out.println(map2.innerProduct(map1.getMap()) + " inner product");
				System.out.println(map1.angle(map2.getMap()) + " angle" + file.getName() + eachfile.getName());
				if(map1.angle(map2.getMap()) > max && !(file.getName().equals(eachfile.getName()))) {
					max = map1.angle(map2.getMap());
					file1 = file.getName();
					file2 = eachfile.getName();

				}
			}
			System.out.println("----------------------------------------------------------------");
		}
		System.out.println(max + file1 + file2);
	}
}