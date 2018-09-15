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
		for(int i = 0; i < questioncount; i++) {
			System.out.println(questions[i].anschoice + "answerchoice of question");
			System.out.println(userchoices[i].split(" ")[1] + "userchoiceeeeeee");
			if(questions[i].anschoice.equals((userchoices[i].split(" ")[1]))) {
				  System.out.println("entering right answer loop");
                  totalscore = totalscore + questions[i].maxmarks;
			} else {
				System.out.println("entering penalty loop");
				System.out.println(totalscore);
				System.out.println(questions[i].penaltymarks);
				totalscore = totalscore + questions[i].penaltymarks;
				System.out.println(totalscore);
			}
		}
		return totalscore;
	}
}