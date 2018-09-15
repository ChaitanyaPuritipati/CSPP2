import java.util.Arrays;
class question {
	String questionname;
	int maxmarks;
	String choices;
	String anschoice;
	int penaltymarks;
	question(String name, String choicestr, String choice, int marks, int penalty) {
		questionname = name;
		maxmarks = marks;
		choices = choicestr;
		anschoice = choice;
		penaltymarks = penalty;
	}
}
class Quiz {
	question[] questions = new question[4];
	int questioncount;
	String[] userchoices = new String[4];
	int userchoicecount;
	int totalscore;
	Quiz() {
		questioncount = 0;
		userchoicecount = 0;
		totalscore = 0;
	}
	void quesresize() {
		questions = Arrays.copyOf(questions, 2 * questioncount);
	}
	void userresize() {
		userchoices = Arrays.copyOf(userchoices, 2 * userchoicecount);
	}
	void displayquescount() {
		System.out.println(questioncount + " are added to the quiz");
	}
	void addtoques(question inputques) {
		if (questioncount == questions.length) {
			quesresize();
		}
		questions[questioncount] = inputques;
		questioncount++;
	}
	void displayqueschoices() {
		for (int i = 0; i < questioncount; i++) {
			if (i > 0) {
				System.out.println();
			}
			System.out.println(questions[i].questionname + "(" + questions[i].maxmarks + ")");
			String[] displaychoices = questions[i].choices.split(",");
			for (int j = 0; j < displaychoices.length - 1; j++) {
				System.out.print(displaychoices[j] + "   ");
			}
			System.out.print(displaychoices[displaychoices.length - 1]);
			System.out.println();
		}
	}
	void addtochoices(String userchoice) {
		if (userchoicecount == userchoices.length) {
			userresize();
		}
		userchoices[userchoicecount++] = userchoice;
	}
	int calculatescore() {
		for (int i = 0; i < questioncount; i++) {
			if (userchoices[i].split(" ")[1].equals("a") || userchoices[i].split(" ")[1].equals("b") || userchoices[i].split(" ")[1].equals("c") || userchoices[i].split(" ")[1].equals("d")) {
				if (questions[i].anschoice.equals("1")) {
					questions[i].anschoice = "a";
				} else if (questions[i].anschoice.equals("2")) {
					questions[i].anschoice = "b";
				} else if (questions[i].anschoice.equals("3")) {
					questions[i].anschoice = "c";
				} else {
					questions[i].anschoice = "d";
				}
			}
			if (questions[i].anschoice.equals((userchoices[i].split(" ")[1]))) {
				totalscore = totalscore + questions[i].maxmarks;
			} else {
				totalscore = totalscore + questions[i].penaltymarks;
			}
		}
		return totalscore;
	}
}