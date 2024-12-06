package altproject;

import java.time.LocalDate;

public class User {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final LocalDate registrationDate; // Unnecessary date tracking

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.registrationDate = LocalDate.now(); // Automatically set date
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHint() { // Unnecessary method for a password hint
        return "Password starts with: " + password.charAt(0);
    }

    public LocalDate getRegistrationDate() { // Completely unnecessary
        return registrationDate;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
