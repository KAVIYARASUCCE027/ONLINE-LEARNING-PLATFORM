package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Quiz {
    Scanner scanner = new Scanner(System.in);
      Quiz(){

    }

    public void JavaQuiz(String username) {
        System.out.println("Welcome to Java Quiz ");
        System.out.println("\n1. What is the keyword used to define a class in Java?");
        System.out.println("   a) class\n   b) Class\n   c) define\n   d) struct");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();

        System.out.println("\n2. Which method is used to print text to the console in Java?");
        System.out.println("   a) System.print()\n   b) System.out.println()\n   c) console.log()\n   d) printf()");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();

        System.out.println("\n3. What is the correct way to start the main method in Java?");
        System.out.println("   a) public void main(String[] args)\n   b) public static main(String[] args)\n   c) public static void main(String[] args)\n   d) main(String[] args)");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();

        int count = 0;
        if (Objects.equals(answer1, "class")) {
            count++;
        }
        if (Objects.equals(answer2, "System.out.println()")) {
            count++;
        }
        if (Objects.equals(answer3, "public static void main(String[] args)")) {
            count++;
        }

        System.out.println("\nThank you for taking the quiz!");
        System.out.println("Your score: " + count + "/3");

        // Insert the score into the database
        insertQuizScore(username, "Java", count);
    }

    public void CPlusPlusQuiz(String username) {
        System.out.println("Welcome to C++ Quiz ");
        System.out.println("\n1. Which of the following is the correct syntax to output 'Hello World' in C++?");
        System.out.println("   a) cout << 'Hello World';\n   b) System.out.println('Hello World');\n   c) printf('Hello World');\n   d) echo 'Hello World';");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();

        System.out.println("\n2. What does the 'public' access modifier mean in C++?");
        System.out.println("   a) Accessible only within the class\n   b) Accessible by other classes\n   c) Accessible by friends only\n   d) Not accessible by any class");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();

        System.out.println("\n3. Which of the following is a valid C++ pointer declaration?");
        System.out.println("   a) int* ptr;\n   b) ptr int*;\n   c) pointer int*;\n   d) int ptr*;");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();
        int score = 0;
        if (Objects.equals(answer1, "a")) {
            score++;
        }
        if (Objects.equals(answer2, "b")) {
            score++;
        }
        if (Objects.equals(answer3, "a")) {
            score++;
        }
        System.out.println("\nThank you for taking the quiz!");
        System.out.println("Your score: " + score + "/3");

        insertQuizScore(username, "C++", score);
    }

    public void DbmsQuiz(String username) {
        System.out.println("Welcome to the DBMS Quiz!");
        // Questions here
        System.out.println("\n1. What does DBMS stand for?");
        System.out.println("   a) Data Base Management System");
        System.out.println("   b) Data Backup Management System");
        System.out.println("   c) Data Binary Management System");
        System.out.println("   d) Database Master System");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();

        System.out.println("\n2. Which of the following is not a DBMS model?");
        System.out.println("   a) Hierarchical Model");
        System.out.println("   b) Relational Model");
        System.out.println("   c) Object-Oriented Model");
        System.out.println("   d) Network Model");
        System.out.println("   e) Textual Model");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();

        System.out.println("\n3. Which SQL command is used to delete all records from a table without deleting the table itself?");
        System.out.println("   a) REMOVE");
        System.out.println("   b) DELETE");
        System.out.println("   c) TRUNCATE");
        System.out.println("   d) DROP");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();
        int score = 0;
        if (answer1.equalsIgnoreCase("a")) {
            score++;
        }
        if (answer2.equalsIgnoreCase("e")) {
            score++;
        }
        if (answer3.equalsIgnoreCase("c")) {
            score++;
        }
        System.out.println("\nThank you for taking the quiz!");
        System.out.println("Your score: " + score + "/3");

        // Insert the score into the database
        insertQuizScore(username, "DBMS", score);
    }

    // Method to insert the quiz score into the database
    private void insertQuizScore(String username, String quizTopic, int score) {
        String query = "INSERT INTO QuizScores (username, quiz_topic, score) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, quizTopic);
            stmt.setInt(3, score);

            stmt.executeUpdate();
            System.out.println("Score for " + quizTopic + " quiz has been recorded in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
