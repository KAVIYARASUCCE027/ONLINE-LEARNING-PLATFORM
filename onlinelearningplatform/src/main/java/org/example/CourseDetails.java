package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CourseDetails {
    Scanner scanner = new Scanner(System.in);
    Connection conn;

    public CourseDetails() {
        try {
            // Connect to your database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelearningplatform", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(String courseName, String courseId, String courseDescription, String instructorName,
                             int durationInHours, double courseRating, int numberOfStudentsEnrolled,
                             String courseLevel, String courseLanguage, double coursePrice, String startDate, String endDate) {
        String sql = "INSERT INTO CourseDetails (courseName, courseId, courseDescription, instructorName, durationInHours, " +
                "courseRating, numberOfStudentsEnrolled, courseLevel, courseLanguage, coursePrice, startDate, endDate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseName);
            pstmt.setString(2, courseId);
            pstmt.setString(3, courseDescription);
            pstmt.setString(4, instructorName);
            pstmt.setInt(5, durationInHours);
            pstmt.setDouble(6, courseRating);
            pstmt.setInt(7, numberOfStudentsEnrolled);
            pstmt.setString(8, courseLevel);
            pstmt.setString(9, courseLanguage);
            pstmt.setDouble(10, coursePrice);
            pstmt.setDate(11, java.sql.Date.valueOf(startDate));
            pstmt.setDate(12, java.sql.Date.valueOf(endDate));

            pstmt.executeUpdate();
            System.out.println(courseName + " course details inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void JavaDetails() {
        String courseName = "JAVA";
        String courseId = "12";
        String courseDescription = "LEARNING";
        String instructorName = "TEKUSKO";
        int durationInHours = 48;
        double courseRating = 8;
        int numberOfStudentsEnrolled = 7;
        String courseLevel = "EXPERT";
        String courseLanguage = "ENGLISH";
        double coursePrice = 100;
        String startDate = "2024-01-01";
        String endDate = "2024-01-03";

        insertCourse(courseName, courseId, courseDescription, instructorName, durationInHours, courseRating,
                numberOfStudentsEnrolled, courseLevel, courseLanguage, coursePrice, startDate, endDate);
    }

    public void CPlusPlusDetails() {
        String courseName = "C++";
        String courseId = "13";
        String courseDescription = "LEARNING";
        String instructorName = "FREE CODE CAMP";
        int durationInHours = 120;
        double courseRating = 9.11;
        int numberOfStudentsEnrolled = 7;
        String courseLevel = "EXPERT";
        String courseLanguage = "ENGLISH";
        double coursePrice = 200;
        String startDate = "2024-02-03";
        String endDate = "2024-02-13";

        insertCourse(courseName, courseId, courseDescription, instructorName, durationInHours, courseRating,
                numberOfStudentsEnrolled, courseLevel, courseLanguage, coursePrice, startDate, endDate);
    }

    public void DbmsDetails() {
        String courseName = "DBMS";
        String courseId = "14";
        String courseDescription = "LEARNING";
        String instructorName = "GATE SMASHERS";
        int durationInHours = 90;
        double courseRating = 9;
        int numberOfStudentsEnrolled = 6;
        String courseLevel = "EXPERT";
        String courseLanguage = "ENGLISH,HINDI";
        double coursePrice = 200;
        String startDate = "2024-02-04";
        String endDate = "2024-02-10";

        insertCourse(courseName, courseId, courseDescription, instructorName, durationInHours, courseRating,
                numberOfStudentsEnrolled, courseLevel, courseLanguage, coursePrice, startDate, endDate);
    }

    public void Details() {
        System.out.println("1. Java Details");
        System.out.println("2. C++ Details");
        System.out.println("3. DBMS Details");
        int detailsChoice = scanner.nextInt();
        if (detailsChoice == 1) {
            JavaDetails();
        } else if (detailsChoice == 2) {
            CPlusPlusDetails();
        } else if (detailsChoice == 3) {
            DbmsDetails();
        }
    }
}
