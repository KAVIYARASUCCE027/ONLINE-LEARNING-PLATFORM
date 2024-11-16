package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    private String userFirstName;
    private String userLastName;
    private String contactnumber;
    private String gmail;
    private String location;
    private String languagesPreffered;
    private String gender;
    private String username;
    private String password;
    public void insertUserToDatabase() {
        String query = "INSERT INTO User (userFirstName, userLastName, contactNumber, gmail, location, languagesPreferred, gender, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, getUserFirstName());
            stmt.setString(2, getUserLastName());
            stmt.setString(3, getContactnumber());
            stmt.setString(4, getGmail());
            stmt.setString(5, getLocation());
            stmt.setString(6, getLanguagesPreffered());
            stmt.setString(7, getGender());
            stmt.setString(8, getUsername());
            stmt.setString(9, getPassword());

            stmt.executeUpdate();
            System.out.println("User details have been inserted into the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static List<User> userList = new ArrayList<>();

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguagesPreffered() {
        return languagesPreffered;
    }

    public void setLanguagesPreffered(String languagesPreffered) {
        this.languagesPreffered = languagesPreffered;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

                                      // methods of user//



    public boolean UserLogin(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter the first Name:");
        setUserFirstName(scanner.nextLine());
        System.out.print("Enter Last Name: ");
        setUserLastName(scanner.nextLine());
        System.out.print("Enter Contact Number: ");
        setContactnumber(scanner.nextLine());
        System.out.print("Enter Gmail: ");
        setGmail(scanner.nextLine());
        System.out.print("Enter Location: ");
        setLocation(scanner.nextLine());
        System.out.print("Enter Preferred Language(s): ");
        setLanguagesPreffered(scanner.nextLine());
        System.out.print("Enter Gender (M/F): ");
        setGender(scanner.nextLine());
        System.out.print("Enter Username: ");
        setUsername(scanner.nextLine());
        System.out.print("Enter Password: ");
        setPassword(scanner.nextLine());
        addUserToList(this);
        System.out.println("User details have been successfully entered.");
        insertUserToDatabase(); // Insert user details into the database
        System.out.println("User details have been successfully entered.");
        return true;
    }

    public void addUserToList(User user) {
        userList.add(user);
        System.out.println("User has been added to the user list.");
    }


    public static void displayAllUsers() {
        System.out.println("\nList of all registered users:");
        for (User user : userList) {
            System.out.println("Name: " + user.getUserFirstName() + " " + user.getUserLastName());
            System.out.println("Contact: " + user.getContactnumber());
            System.out.println("Gmail: " + user.getGmail());
            System.out.println("Location: " + user.getLocation());
            System.out.println("Languages Preferred: " + user.getLanguagesPreffered());
            System.out.println("Gender: " + user.getGender());
            System.out.println("Username: " + user.getUsername());
            System.out.println("--------------------------");
        }
    }



}
