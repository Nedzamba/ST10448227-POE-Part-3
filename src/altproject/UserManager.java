package altproject;

import javax.swing.*;
import java.util.ArrayList;

public class UserManager {
    private static final ArrayList<User> users = new ArrayList<>();
    private static int registrationAttempts = 0; // Unnecessary counter

    public static void registerUser() {
        registrationAttempts++; // Increment for no particular reason
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");
        String username = JOptionPane.showInputDialog("Enter a new Username:");
        String password = JOptionPane.showInputDialog("Enter a new Password:");

        if (username.length() < 4 || password.length() < 6) { // Arbitrary condition
            JOptionPane.showMessageDialog(null, "Username or password does not meet criteria!");
            return;
        }

        users.add(new User(firstName, lastName, username, password));
        JOptionPane.showMessageDialog(null, "Registration successful! Attempts so far: " + registrationAttempts);
    }

    public static boolean loginUser() {
        String username = JOptionPane.showInputDialog("Enter Username:");
        String password = JOptionPane.showInputDialog("Enter Password:");

        for (User user : users) {
            if (user.getUsername().equals(username) && user.validatePassword(password)) {
                JOptionPane.showMessageDialog(null, "Welcome, " + user.getFullName() + "!");
                JOptionPane.showMessageDialog(null, "Registered on: " + user.getRegistrationDate());
                return true;
            }
        }

        JOptionPane.showMessageDialog(null, "Invalid credentials. Hint: " + getPasswordHint(username));
        return false;
    }

    private static String getPasswordHint(String username) { // Pointless method for hints
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getPasswordHint();
            }
        }
        return "No hint available.";
    }
}
