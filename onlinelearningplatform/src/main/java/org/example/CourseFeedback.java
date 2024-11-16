package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseFeedback {
    Scanner scanner = new Scanner(System.in);
    Connection conn;


    public CourseFeedback() {
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ onlinelearningplatform", "root", "root");
            System.out.println("Connected to the database successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void feedBack() {
        System.out.println("-------------------------");
        System.out.println(" ^-^  FEEDBACK  ^-^");
        System.out.println("-------------------------");

        System.out.println("Enter the Course Name:");
        String courseName = scanner.nextLine();

        System.out.println("Enter Overall Rating (Out of 5 stars):");
        int stars = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Course Content Rating (1.EXCELLENT 2.ACCEPTABLE 3.AVERAGE):");
        String contentRating = scanner.nextLine();

        insertFeedback(courseName, stars, contentRating);
    }

    private void insertFeedback(String courseName, int overallRating, String contentRating) {
        String sql = "INSERT INTO CourseFeedback (courseName, overallRating, contentRating) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseName);
            pstmt.setInt(2, overallRating);
            pstmt.setString(3, contentRating);

            pstmt.executeUpdate();
            System.out.println("Feedback submitted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
