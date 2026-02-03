package com.yatish.training.services;

import com.yatish.training.dao.UserDAOImpl;
import com.yatish.training.models.CurrentUser;
import com.yatish.training.models.User;

import java.util.Scanner;

public class AuthenticationService {
    private UserDAOImpl userDAO = new UserDAOImpl();
    private Scanner sc = new Scanner(System.in);

    public boolean login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        var userOpt = userDAO.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password) && user.isActive()) {
                CurrentUser.getInstance().setLoggedInUser(user);
                System.out.println("\nWelcome, " + user.getUsername() + "! (Role: " + user.getRole() + ")");
                return true;
            } else {
                System.out.println("Invalid password or user is inactive!");
                return false;
            }
        } else {
            System.out.println("User not found!");
            return false;
        }
    }

    public boolean register() {
        System.out.println("\n=== REGISTER ===");
        System.out.print("Username: ");
        String username = sc.nextLine();

        if (userDAO.userExists(username)) {
            System.out.println("Username already exists!");
            return false;
        }

        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Confirm Password: ");
        String confirmPassword = sc.nextLine();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return false;
        }

        System.out.println("Role (1.ADMIN 2.EMPLOYEE): ");
        int roleChoice = sc.nextInt();
        sc.nextLine(); // consume newline
        String role = (roleChoice == 1) ? "ADMIN" : "EMPLOYEE";

        User user = new User(username, password, role);
        var savedUser = userDAO.addUser(user);

        if (savedUser.isPresent()) {
            System.out.println("User registered successfully!");
            return true;
        } else {
            System.out.println("Registration failed!");
            return false;
        }
    }

    public void logout() {
        if (CurrentUser.getInstance().isLoggedIn()) {
            System.out.println("Goodbye, " + CurrentUser.getInstance().getCurrentUsername() + "!");
            CurrentUser.getInstance().logout();
        }
    }

    public User getCurrentUser() {
        return CurrentUser.getInstance().getLoggedInUser();
    }


    public boolean isLoggedIn() {
        return CurrentUser.getInstance().isLoggedIn();
    }
}
