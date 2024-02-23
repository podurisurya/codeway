import java.util.*;
import java.util.TimerTask;

import java.util.Timer;


import java.util.*;
class Question{
    String prompt;
    String[] options;
    String answer;
    
    public Question(String prompt,  String[] options, String answer)
    {
        this.prompt=prompt;
        this.options = options;
        this.answer=answer;
    }
}
class Main{
     private static Timer timer;
    private static int totalSec; // Assuming you want a timer in seconds
    private static final int QUESTION_TIME = 20;
    private static int score = 0;
    public static void main(String args[]){
        String q1="Which is used to find and fix bugs in the java programs?\n";
        String[] options1 = {"a) JVM", "b) JDB", "c) JDK", "d) JRE"};
        String answer1 = "b";
                 
        String q2="Which package contains the Random class?\n";
        String[] options2 = {"a) java.util package", "b) java.lang package", "c) java.awt package", "d) java.io package"};
        String answer2 = "a";

        String q3="Which of the following is not a Java features?\n";
        String[] options3= {"a) Dynamic", "b) Architecture Neutral", "c) Use of pointers","d) Object-oriented"};
        String answer3= "c";

        String q4="What is the return type of the hashCode() method in the Object class?\n";
        String[] options4={"a) Object","b) int","c) long","d) void"};
        String answer4= "b";

        String q5="What does the expression float a = 35 / 0 return?\n";
        String[] options5={"a) 0","b) Not a Number","c) Infinity","d) Run time exception"};
        String answer5="c";      
                
        Question [] questions={
            new Question(q1, options1, answer1),
            new Question(q2, options2, answer2),
            new Question(q3, options3, answer3),
            new Question(q4, options4, answer4),
            new Question(q5, options5, answer5)
        };
        for (Question question : questions) {
            setTimer(question);
            takeQuestion(question);
        }
         System.out.println("Your total score is: "+ score+ "/"+questions.length);
   }
   private static void setTimer(Question question) {
        totalSec = QUESTION_TIME;
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                totalSec--;
                if (totalSec <= 0) {
                    timer.cancel();
                    System.out.println("Time's up for the current question!");
                    System.out.println("Please, press the Enter Key to display the next question.");
                     // Exit the program or perform other actions as needed
                }
            }
        };

        timer.schedule(timerTask, 0, 1000); // Schedule the timer to run every second
    }
        private static void takeQuestion(Question question) {
        System.out.println(question.prompt);
        for (String option : question.options) {
            System.out.println(option);
        }
        Scanner keyboardInput = new Scanner(System.in);
        String answer = keyboardInput.nextLine();
        timer.cancel(); // Cancel the timer for the current question
        if (answer.equals(question.answer)) {
            System.out.println("Correct!");
            score++;
        } 
         System.out.println("Press Enter to continue...");
        keyboardInput.nextLine();
        clearConsole(); // Clear console for the next question
    }
    private static void clearConsole() {
        // Clear the console screen for better presentation
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
