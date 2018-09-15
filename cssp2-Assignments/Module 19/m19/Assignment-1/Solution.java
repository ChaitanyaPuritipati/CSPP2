import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * { error flag }.
     */
    private static boolean errorflag = false;
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * { flag function }.
     *
     * @return     { boolean type }
     */
    public static boolean getflag() {
        return errorflag;
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(
        final Scanner s, final Quiz quiz,
        final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
            errorflag = true;
            return;
        }
        for (int i = 0; i < questionCount; i++) {
            String textline = s.nextLine();
            String[] tokens = textline.split(":");
            final int five = 5;
            final int four = 4;
            final int three = 3;
            if (tokens.length != five || tokens[0].equals("")) {
                System.out.println("Error! Malformed question");
                errorflag = true;
                return;
            }
            if (tokens[1].split(",").length < 2) {
                System.out.println(tokens[0]
                                   + " does not have enough answer choices");
                errorflag = true;
                return;
            }
            if (Integer.parseInt(tokens[2]) > four) {
                System.out.println(
                    "Error! Correct answer choice number" 
                    + " is out of range for question text 1"
                );
                errorflag = true;
                return;
            }
            if (Integer.parseInt(tokens[three]) < 0) {
                System.out.println("Invalid max marks for " + tokens[0]);
                errorflag = true;
                return;
            }
            if (Integer.parseInt(tokens[four]) > 0) {
                System.out.println("Invalid penalty for " + tokens[0]);
                errorflag = true;
                return;
            }
            question newques = new question(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[three]), Integer.parseInt(tokens[four]));
            quiz.addtoques(newques);
        }
        quiz.displayquescount();
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (getflag()) {
            return;
        }
        for (int i = 0; i < answerCount; i++) {
            String choiceline = s.nextLine();
            quiz.addtochoices(choiceline);
        }
        quiz.displayqueschoices();
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        if (getflag()) {
            return;
        }
        System.out.println("Total Score: " + quiz.calculatescore());
    }
}
