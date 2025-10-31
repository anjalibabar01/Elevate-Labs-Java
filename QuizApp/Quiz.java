// Quiz.java
package QuizApp;

import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "1. What is the capital of India?",
            Arrays.asList("A) Mumbai", "B) Delhi", "C) Kolkata", "D) Chennai"),
            1 // Delhi
        ));

        questions.add(new Question(
            "2. Who developed Java?",
            Arrays.asList("A) Dennis Ritchie", "B) James Gosling", "C) Bjarne Stroustrup", "D) Guido van Rossum"),
            1 // James Gosling
        ));

        questions.add(new Question(
            "3. Which keyword is used to inherit a class in Java?",
            Arrays.asList("A) implement", "B) extends", "C) inherit", "D) super"),
            1 // extends
        ));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        for (Question q : questions) {
            System.out.println("\n" + q.getQuestionText());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (0-A, 1-B, 2-C, 3-D): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.getOptions().get(q.getCorrectAnswerIndex()));
            }
        }

        System.out.println("\n🎯 Your Final Score: " + score + "/" + questions.size());
        sc.close();
    }
}
