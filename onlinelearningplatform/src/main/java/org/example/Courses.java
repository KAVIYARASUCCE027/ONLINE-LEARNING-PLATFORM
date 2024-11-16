package org.example;
import java.util.*;

public class Courses extends Quiz{
    String courseName;
    String courseId;
    String courseDescription;
    String instructorName;
    int durationInHours;
    double courseRating;
    int numberOfStudentsEnrolled;
    String courseLevel;
    String courseLanguage;
    double coursePrice;
    String startDate;
    String endDate;
    Quiz quiz=new Quiz();


    CourseFeedback courseFeedback=new CourseFeedback();
    CourseChapters courseChapters = new CourseChapters();

    public void CourseLists(){
        System.out.println("1.BE A EXPERT IN JAVA");
        System.out.println("2.C++ FOR BEGINNERS");
        System.out.println("3.MASTER THE ART OF DBMS");

    }
    public void Dbms(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                   ");
        System.out.println("Enter |START| to begin the Course");
        System.out.println("                                    ");

        String start = scanner.nextLine();
        if (Objects.equals(start, "START")) {
            courseChapters.DbmsChapter();
        } else {
            System.out.println("Enter the Word 'START' Correctly");
        }
        System.out.println("////////////////////////////////");
        System.out.println("DO YOU WANT TO ATTEND THE QUIZ(YES | NO)");
        System.out.println("////////////////////////////////");
        String takeQuizOrNot = scanner.nextLine();
        if (Objects.equals(takeQuizOrNot, "Yes") || Objects.equals(takeQuizOrNot, "YES")) {
            System.out.println("User_id:");
            String un=scanner.nextLine();
            if(Objects.equals(un,"kavi9677")){
                DbmsQuiz(un);
                courseFeedback.feedBack();
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }




    public  void CPlusPlus(){
        CourseChapters courseChapters = new CourseChapters();
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                  ");
        System.out.println("Enter |START| to begin the Course");
        System.out.println("                                   ");

        String start = scanner.nextLine();
        if (Objects.equals(start, "START")) {
            courseChapters.CPlusPlusChapter();
        } else {
            System.out.println("Enter the Word 'START' Correctly");
        }
        System.out.println("////////////////////////////////");
        System.out.println("DO YOU WANT TO ATTEND THE QUIZ (YES | NO)");
        System.out.println("////////////////////////////////");
        String takeQuizOrNot = scanner.nextLine();
        if (Objects.equals(takeQuizOrNot, "Yes") || Objects.equals(takeQuizOrNot, "YES")) {
            System.out.println("user_id");
            String un=scanner.nextLine();
            if(Objects.equals(un,"kavi9677")){
                CPlusPlusQuiz(un);
                courseFeedback.feedBack();
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }



    public void Java() {
        CourseChapters courseChapters = new CourseChapters();
        Scanner scanner = new Scanner(System.in);
        System.out.println("                                    ");
        System.out.println("Enter |START| to begin the Course");
        System.out.println("                                     ");
        String start = scanner.nextLine();
        if (Objects.equals(start, "START")) {
            courseChapters.JavaChapters();
        } else {
            System.out.println("Enter the Word 'START' Correctly");
        }
        System.out.println("////////////////////////////////");
        System.out.println("DO YOU WANT TO ATTEND THE QUIZ(YES | NO)");
        System.out.println("////////////////////////////////");
        String takeQuizOrNot = scanner.nextLine();
        if (Objects.equals(takeQuizOrNot, "Yes") || Objects.equals(takeQuizOrNot, "YES")) {
            System.out.println("user_id");
            String un=scanner.nextLine();
            if(Objects.equals(un,"kavi9677")){
                JavaQuiz(un);
                courseFeedback.feedBack();
                System.exit(0);
            }
        }
        else{
            System.exit(0);
        }
    }




    public void ChooseCourse(){
        Scanner scanner =new Scanner(System.in);
        int courseChoice=scanner.nextInt();
        if(courseChoice==1){
            System.out.println("pay for this course ₹100");
            Wallet wallet=new Wallet();
            if(wallet.Mywallet()){
                System.out.println("you are enrolled for  ***'BE A EXPERT IN JAVA'***  ");
                Java();
            }
            else{
                System.out.println("Error !");
            }
        }
        else if(courseChoice==2){
            System.out.println("pay for this course ₹200");
            Wallet wallet=new Wallet();
            if(wallet.Mywallet()){
                System.out.println("you are enrolled in   ***'C++ FOR BEGINNERS'***");
                CPlusPlus();
            }
            else{
                System.out.println("Error !");
            }
        }
        else if(courseChoice==3){
            System.out.println("pay for this course ₹200");
            Wallet wallet=new Wallet();
            if(wallet.Mywallet()){
                System.out.println("you are enrolled in   ***'MASTER THE ART OF DBMS'***");
                Dbms();
            }
            else{
                System.out.println("Error !");
            }

        }
    }
}
