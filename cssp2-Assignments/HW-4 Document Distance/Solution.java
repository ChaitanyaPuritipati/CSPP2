import java.util.*;
import java.io.*;
import java.net.*;
public class Solution {
	public static void main(String[] args) {
		File dir = new File("src");
		File[] files = dir.listFiles();
		for(File file : files) {
			System.out.println(file.getName());
		}
		// Distance disobj = new Distance(new File("verne.txt"));
		// // Distance disobj = new Distance("To be or not to be");
		// System.out.println(disobj.getNumOfLines());
		// System.out.println(disobj.getNumOfWords());
		// System.out.println(disobj.getNumOfDistinctWords());
		// // System.out.println(disobj.getMap());
		// System.out.println(disobj.norm());
	}
}