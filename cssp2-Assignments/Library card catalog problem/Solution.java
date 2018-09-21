import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
class Card {
	private String booktitle;
	private String bookauthor;
	private String booksubject;
	Card(String title, String author, String subject) {
		this.booktitle = title;
		this.bookauthor = author;
		this.booksubject = subject;
	}
	public String gettitle() {
		return this.booktitle;
	}
	public String getauthor() {
		return this.bookauthor;
	}
	public String getsubject() {
		return this.booksubject;
	}
	public String toString() {
		return this.booktitle + " " + this.bookauthor + " " + this.booksubject;
	}
}
class Catalog {
	private ArrayList<Card> Cardcatalog;
	Catalog() {
		Cardcatalog = new ArrayList<Card>();


	}
	ArrayList<Card> getcardcatalog() {
		return Cardcatalog;
	}
	void addacard(Card inputcard) {
		Cardcatalog.add(inputcard);
	}
	Card getatitle(String inputtitle) {
		ArrayList<String> titles = new ArrayList<String>();
		ArrayList<String> testtitles = new ArrayList<String>();
		for (int i = 0; i < Cardcatalog.size(); i++) {
			testtitles.add(Cardcatalog.get(i).gettitle());
			titles.add(Cardcatalog.get(i).gettitle());
		}
		Collections.sort(titles);
		int first = 0;
		int last = Cardcatalog.size();
		while (first != last) {
			int middle = (int)((first + last) / 2);
			if (titles.get(middle).compareTo(inputtitle) == 0) {
				return Cardcatalog.get(testtitles.indexOf(inputtitle));
			} else if (titles.get(middle).compareTo(inputtitle) < 0) {
				first = middle;
			} else {
				last = middle;
			}
		}
		return null;
	}
	ArrayList<Card> getallauthor(String inputauthor) {
		ArrayList<Card>authorcatalog = new ArrayList<Card>();
		for (int i = 0; i < Cardcatalog.size(); i++) {
			if (Cardcatalog.get(i).getauthor().equals(inputauthor)) {
				authorcatalog.add(Cardcatalog.get(i));
			}
		}
		return authorcatalog;
	}
	ArrayList<Card>getallsubject(String inputsubject) {
		ArrayList<Card>subcatalog = new ArrayList<Card>();
		for (int i = 0; i < Cardcatalog.size(); i++) {
			if (Cardcatalog.get(i).getsubject().contains(inputsubject)) {
				subcatalog.add(Cardcatalog.get(i));
			}
		}
		return subcatalog;
	}
	void removetitle(String inputremovetitle) {
		Iterator<Card> it = Cardcatalog.iterator();
		while (it.hasNext()) {
			if (it.next().gettitle().equals(inputremovetitle)) {
				it.remove();
			}
		}
	}
}
class Solution {
	Solution() {
		//unused
	}
	public static void main(String[] args) {
		Catalog catalogobj = new Catalog();
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 15; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			switch (tokens[0]) {
			case "add":
				Card inputcard = new Card(tokens[1], tokens[2], tokens[3]);
				catalogobj.addacard(inputcard);
				break;
			case "title":
				if (catalogobj.getatitle(tokens[1]) != null) {
					System.out.println(catalogobj.getatitle(tokens[1]));
				} else {
					System.out.println("Not present");
				}
				break;
			case "author":
				int sizelist =  catalogobj.getallauthor(tokens[1]).size();
				for (int j = 0; j < sizelist; j++) {
					System.out.println(catalogobj.getallauthor(tokens[1]).get(j));
				}
				break;
			case "subject":
				sizelist = catalogobj.getallsubject(tokens[1]).size();
				for (int k = 0; k < sizelist; k++) {
					System.out.println(catalogobj.getallsubject(tokens[1]).get(k));
				}
				break;
			case "remove":
				catalogobj.removetitle(tokens[1]);
				break;
			}
		}
	}
}