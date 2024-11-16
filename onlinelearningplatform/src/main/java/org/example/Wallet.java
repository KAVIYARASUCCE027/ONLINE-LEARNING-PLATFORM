package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Wallet {
    Scanner scanner = new Scanner(System.in);

    private static final String DB_URL = "jdbc:mysql://localhost:3306/onlinelearningplatform";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public boolean Mywallet() {
        System.out.println("pay         |         cancel");
        System.out.print("Enter your Option: ");
        String moneyPayment = scanner.nextLine();

        if (Objects.equals(moneyPayment, "pay")) {
            int initialAmount = 2000;
            System.out.print("Enter the Amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Confirm ?");
            String confirm = scanner.nextLine();

            if (Objects.equals(confirm, "Confirm")) {
                System.out.println("Enter password:");
                String pass = scanner.nextLine();

                if (Objects.equals(pass, "1234")) {
                    System.out.println("Payment Successful>>!");
                    int balance = initialAmount - amount;

                    System.out.println("Your balance: " + balance);
                    saveTransaction(amount, confirm, balance);
                    return true;
                } else {
                    System.out.println("Incorrect password.");
                }
            } else {
                System.out.println("OOPS! Something went wrong.");
                System.exit(0);
            }
        }
        else{
            System.out.println("enter A valid Input");
        }
        return false;
    }

    private void saveTransaction(int amount, String confirmation, int balance) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String insertQuery = "INSERT INTO Transactions (amount, confirmation, balance) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, amount);
            preparedStatement.setString(2, confirmation);
            preparedStatement.setInt(3, balance);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Transaction saved to database successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save transaction.");
        }
    }
}
