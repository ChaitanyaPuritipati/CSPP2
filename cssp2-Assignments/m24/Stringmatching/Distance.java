/**
 ******************************************************************************
 *                    MODULE 24
 ******************************************************************************
 *                  THE STRING MATCHING
 ******************************************************************************
 *
 * The String matching problem is the problem of computing the Longest
 * common substring between two given text documents.
 *
 * The plagarism between two documents is given by their lcs.
 * 
 *
 *
 *****************************************************************************/

import java.util.*;
import java.io.*;
import java.net.*;

public class Distance {
	private HashMap<String, Integer> freqWords = new HashMap<>();
	String s1 = "";
	String s2 = "";
	double ans;
	public Distance(File inputFile, File inputFile2) {
		try {
			Scanner filescan = new Scanner(inputFile);
			while(filescan.hasNext()) {
				s1 += filescan.nextLine();
			}
			filescan = new Scanner(inputFile2);
			while(filescan.hasNext()) {
				s2 += filescan.nextLine();
			}
			String lcs = "";
			for (int i = 0; i < s2.length(); i++) {
				for (int j = i + 1 ; j <= s2.length(); j++) {
					if (s1.contains(s2.substring(i, j))) {
						if (s2.substring(i, j).length() > lcs.length()) {
							lcs = s2.substring(i, j);
						}
					}
				}
			}
			if (inputFile.getName().equals(inputFile2.getName())) {
				ans = 100;
				System.out.format("%13.1f", ans);
			} else {
				double numerator = lcs.length() * 2 * 100;
				double denominator = s1.length() + s2.length();
				ans = Math.round(numerator / denominator);
				System.out.format("%13.1f", ans);
			}
		} catch (Exception e) {
			System.out.println("FILE NOT FOUND");
		}
	}
	public double getSimilarity() {
		return ans;
	}
}