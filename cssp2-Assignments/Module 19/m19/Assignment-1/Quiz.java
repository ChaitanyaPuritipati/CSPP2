import java.util.Arrays;
class question {
	String questionname;
	int maxmarks;
	String choices;
	int anschoice;
	int penaltymarks;
	question(String name, String choicestr, int choice, int marks, int penalty) {
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
	Quiz() {
		questioncount = 0;
		userchoicecount = 0;
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
		// if(questioncount > 0) {
		// 	System.out.println();
		// }
		// System.out.println(questions[questioncount].questionname + "(" + questions[questioncount].maxmarks + ")");
		// String[] displaychoices = questions[questioncount].choices.split(",");
		// for(int i = 0; i < displaychoices.length - 1; i++) {
		// 	System.out.print(displaychoices[i] + "   ");
		// }
		// System.out.print(displaychoices[displaychoices.length-1]);
		questioncount++;
	}
	void displayqueschoices() {
		for (int i = 0; i < questions.length; i++) {
			if (i > 0) {
				System.out.println();
			}
			System.out.println(questions[i].questionname + "(" + questions[i].maxmarks + ")");
			String[] displaychoices = questions[i].choices.split(",");
			for (int j = 0; i < displaychoices.length - 1; j++) {
				System.out.print(displaychoices[j] + "   ");
			}
			System.out.print(displaychoices[displaychoices.length - 1]);
		}
	}
	void addtochoices(String userchoice) {
		if (userchoicecount == userchoices.length) {
			userresize();
		}
		userchoices[userchoicecount++] = userchoice;
	}
}