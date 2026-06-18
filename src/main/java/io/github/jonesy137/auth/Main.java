package io.github.jonesy137.auth;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //initialise scanner object
        boolean running = true;

        /* manual test of initial password hasher implementation
        PasswordHasher passwordHasher = new PasswordHasher(); //initialise passwordHasher object
        String hash = passwordHasher.hashPassword("test123");

        System.out.println(hash);
        System.out.println(passwordHasher.verifyPassword("test123", hash));
        System.out.println(passwordHasher.verifyPassword("wrongpassword", hash));
        */

        while (running) {
            //Simple startup menu
            System.out.println("Secure Auth Java is running.");
            System.out.println("1. Signup");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println("Signup.");
                case "2" -> System.out.println("Log in.");
                case "3" -> {
                    System.out.println("Exit.");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
