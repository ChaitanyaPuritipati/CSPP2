import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
class Solution {
	static TreeMap<String, ArrayList<String>> connections = new TreeMap<>();
	public static void main(String[] args) {
		try {
			File networkfile = new File("input002.txt");
			Scanner scan = new Scanner(networkfile);
			int createnumber = Integer.parseInt(scan.nextLine().split(" ")[1]);
			for (int z = 0; z < createnumber; z++) {
				String line = scan.nextLine();
				line = line.substring(0, line.length() - 1);
				String[] linesplits = line.split(" is connected to ");
				String[] tokensplits = linesplits[1].split(", ");
				ArrayList<String> friends = new ArrayList<String>();
				for (int l = 0; l < tokensplits.length; l++) {
					friends.add(tokensplits[l]);
				}
				connections.put(linesplits[0], friends);
			}
			while (scan.hasNext()) {
				String testline = scan.nextLine();
				String[] testtokens = testline.split(" ");
				switch (testtokens[0]) {
				case "addConnections":
					if (connections.containsKey(testtokens[1]) && connections.containsKey(testtokens[2])) {
						connections.get(testtokens[1]).add(testtokens[2]);
					} else {
						System.out.println("Not a user in Network");
					}
					break;
				case "getConnections":
					if (connections.containsKey(testtokens[1])) {
						System.out.println(connections.get(testtokens[1]));
					} else {
						System.out.println("Not a user in Network");
					}
					break;
				case "CommonConnections":
					if (connections.containsKey(testtokens[1]) && connections.containsKey(testtokens[2])) {
						ArrayList<String> common = new ArrayList<String>(connections.get(testtokens[1]));
						common.retainAll(connections.get(testtokens[2]));
						System.out.println(common);
					}
					break;
				case "Network":
				    String[] keys = connections.keySet().toArray(new String[connections.keySet().size()]);
				    for(int i = 0; i < keys.length - 1; i++) {
				    	System.out.print(keys[i] + ": ");
				    	System.out.print(connections.get(keys[i]) + ", ");
				    }
				    System.out.print(keys[keys.length - 1] + ": ");
				    System.out.print(connections.get(keys[keys.length - 1]));
				    System.out.println();
					break;
				default:
				}
			}
		} catch (IOException io) {
			System.out.println("FILE NOT FOUND");
			return;
		}
	}
}