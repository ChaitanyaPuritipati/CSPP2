/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
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
	ArrayList<String> filelines = new ArrayList<String>();
	TreeMap<String, Integer> worddict = new TreeMap<>();
	Distance(File inputfile) {
		try {
			this.testfile = inputfile;
			filescan = new Scanner(testfile);
			while (filescan.hasNext()) {
				// String line = filescan.nextLine();
				String line = filescan.useDelimiter("\\A").next();
				filelines.add(line);
			}
			buildingdict();
		} catch (IOException io) {
			System.out.println("FILE NOT FOUND");
			return;
		}

	}
	Distance(String inputline) {
		filelines.add(inputline);
		buildingdict();

	}
	int getNumOfLines() {
		return filelines.size();
	}
	int getNumOfDistinctWords() {
		return worddict.keySet().size();
	}
	int getNumOfWords() {
		int sum = 0;
		for (int i : worddict.values()) {
			sum = sum + i;
		}
		return sum;
	}
	void buildingdict() {
		for (String eachline : filelines) {
			// eachline = eachline.toLowerCase();
			// eachline = eachline.replaceAll("[^a-z0-9_']","");
			if (eachline.length() > 0) {
				// System.out.println(eachline);
				// String[] words = eachline.split("\\W");
				String[] words = eachline.split(" ");
				for (String word : words) {
					word = word.toLowerCase();
					if (word.length() > 0) {
						if (worddict.containsKey(word)) {
							worddict.put(word, worddict.get(word) + 1);
						} else {
							worddict.put(word, 1);
						}
					}
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
		// System.out.println(getNumOfWords() + "Wordcount");
		double compnorm = 0;
		for (int i : comparedict.values()) {
			compnorm = compnorm + (i * i);
		}
		compnorm = Math.sqrt(compnorm);
		return Math.round((((innerProduct(comparedict)) / ((this.norm()) * (compnorm)))) * 100);
	}
}
