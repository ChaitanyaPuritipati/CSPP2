import java.util.Scanner;
class Solution {
	Solution() {
		//unused.
	}
	public static void main(String[] args) {
		BookYourShow bookshow = new BookYourShow();
		Show showobj =  new Show();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] tokens = line.split(" ", 2);
			switch(tokens[0]) {
				case "add":
				           String[] par = tokens[1].split(",", 3); 
                           bookshow.add(par[0], par[1], par[2]);
                           break;
			}
		}
	}
}