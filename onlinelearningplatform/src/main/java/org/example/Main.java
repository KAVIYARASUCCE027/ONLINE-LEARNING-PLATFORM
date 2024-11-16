package org.example;
import java.sql.Connection;
import java.util.Scanner;

public class Main extends CourseDetails{
    public static void UserInterface() {
        System.out.println("^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-");
        System.out.println("ONLINE LEARNING PLATFORM");
        System.out.println("^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-^_^-");
    }

    public static void UserInterfaceOptions() {
        System.out.println("1. Login To Learning Platform");
        System.out.println("2. View Course Lists");
        System.out.println("3. view Details About Course");
        System.out.println("4.view Entered details");
    }


    public static int ChooseOptions(Scanner scanner) {
        return scanner.nextInt();
    }

    public static void ExecuteOptions(int choice,User user,Courses courses) {
        if (choice == 1) {
            System.out.println("You are logging in to Learning Platform...");
            if (user.UserLogin()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }
        } else if (choice == 2) {
            System.out.println("You are Viewing Courses");
            courses.CourseLists();
            System.out.println("---------------------");
            System.out.println("Select the course");
            System.out.println("---------------------");
            courses.ChooseCourse();


        } else if (choice == 3) {
            System.out.println(" Course Details");
            CourseDetails courseDetails=new CourseDetails();
            courseDetails.Details();


        } else if(choice==4){
            System.out.println("view entered Details.");
            user.displayAllUsers();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user=new User();
        Courses courses=new Courses();
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("You can now interact with the database.");
        }
        Quiz quiz=new Quiz();

        while (true) {
            UserInterface();
            UserInterfaceOptions();
            int choice = ChooseOptions(scanner);
            ExecuteOptions(choice,user,courses);

        }
    }
}
