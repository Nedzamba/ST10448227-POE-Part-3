package altproject;

import javax.swing.*;
import java.util.ArrayList;

public class Login {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final boolean maintenanceMode = false; // Unnecessary variable

    public static void main(String[] args) {
        if (maintenanceMode) { // Pointless condition
            JOptionPane.showMessageDialog(null, "System is under maintenance. Try again later.");
            return;
        }

        while (true) {
            String menu = "1. Register\n2. Login\n3. Exit";
            int choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1 -> UserManager.registerUser();
                case 2 -> {
                    if (UserManager.loginUser()) {
                        userDashboard();
                    }
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "System shutting down. Maintenance scheduled.");
                    System.exit(0); // Abrupt exit for dramatic effect
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Try again.");
            }
        }
    }

    private static void userDashboard() {
        boolean loggedIn = true;

        while (loggedIn) {
            String dashboard = "1. Add Task\n2. View Tasks\n3. Assign Developer\n4. Logout\n5. Maintenance Info";
            int choice = Integer.parseInt(JOptionPane.showInputDialog(dashboard));

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> assignDeveloper();
                case 4 -> {
                    loggedIn = false;
                    JOptionPane.showMessageDialog(null, "Logging out...");
                }
                case 5 -> JOptionPane.showMessageDialog(null, "System Maintenance Date: None");
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
            }
        }
    }

    private static void addTask() {
        String title = JOptionPane.showInputDialog("Task Title:");
        String description = JOptionPane.showInputDialog("Task Description:");
        String developer = JOptionPane.showInputDialog("Developer Name:");
        String status = "To Do";

        tasks.add(new Task(title, description, developer, status));
        JOptionPane.showMessageDialog(null, "Task added successfully!");
    }

    private static void viewTasks() {
        StringBuilder allTasks = new StringBuilder("Task List:\n");
        for (Task task : tasks) {
            allTasks.append(task).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, allTasks.length() > 0 ? allTasks.toString() : "No tasks available.");
    }

    private static void assignDeveloper() {
        for (Task task : tasks) {
            task.markAsUrgent(); // Calling pointless method
        }

        JOptionPane.showMessageDialog(null, "Developer assigned. All tasks marked urgent.");
    }
}

