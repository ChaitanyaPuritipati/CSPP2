import java.util.Scanner;
class Solution {
	Solution() {
		//unused.
	}
	public static void main(String[] args) {
		BookYourShow bookshow = new BookYourShow();
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] tokens = line.split(" ", 2);
			switch(tokens[0]) {
				case "add":
				           String[] par = tokens[1].split(",", 3); 
                           bookshow.add(par[0], par[1], par[2]);
                           break;
                case "book":
                           par = tokens[1].split(",", 5);
                           bookshow.book(par[0], par[1], par[2], par[3], par[4]);
                           break;
                case "print":
                           par = tokens[1].split(",");
                           bookshow.print(par[0], par[1], par[2]);
                           break;                      
			}
		}
	}
}