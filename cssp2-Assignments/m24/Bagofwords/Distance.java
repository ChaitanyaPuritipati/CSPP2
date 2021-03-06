/**
 ******************************************************************************
 *                    MODULE 24
 ******************************************************************************
 *                  BAG OF WORDS
 ******************************************************************************
 *
 * The document distance problem is the problem of computing the distance
 * between two given text documents.
 *
 * The distance between two documents is the angle between their word
 * frequency vectors.
 *
 *
 *****************************************************************************/
import java.util.*;
import java.io.*;
import java.net.*;
public class Distance {
	//requirements are defined by provided tests
	//       Test1.java, Test2.java, Test3.java, Test4.java
	File testfile;
	Scanner filescan;
	String line;
	TreeMap<String, Integer> worddict = new TreeMap<>();
	Distance(File inputfile) {
		try {
			this.testfile = inputfile;
			filescan = new Scanner(testfile);
			 while (filescan.hasNext()) {
				line = filescan.useDelimiter("\\A").next();
			}
			buildingdict();
		} catch (IOException io) {
			System.out.println("FILE NOT FOUND");
			return;
		}

	}
	void buildingdict() {
		if (line != null) {
			String[] words = line.toLowerCase().split(" ");
			for (String word : words) {
				if (worddict.containsKey(word)) {
					worddict.put(word, worddict.get(word) + 1);
				} else {
					worddict.put(word, 1);
				}
			}
		}
	}
	TreeMap<String, Integer> getMap() {
		return worddict;
	}
	double norm() {
		double totalfreq = 0;
		for (int i : worddict.values()) {
			totalfreq = totalfreq + (i * i);
		}
		return Math.sqrt(totalfreq);
	}
	double innerProduct(TreeMap<String, Integer> comparedict) {
		double innerproductvalue = 0;
		for (String eachkey : this.getMap().keySet()) {
			if (comparedict.containsKey(eachkey)) {
				innerproductvalue = innerproductvalue + ((this.getMap().get(eachkey)) * (comparedict.get(eachkey)));
			}
		}
		return innerproductvalue;
	}
	long angle(TreeMap<String, Integer> comparedict) {
		double compnorm = 0;
		for (int i : comparedict.values()) {
			compnorm = compnorm + (i * i);
		}
		compnorm = Math.sqrt(compnorm);
		return Math.round((((innerProduct(comparedict)) / ((this.norm()) * (compnorm)))) * 100);
	}
}
