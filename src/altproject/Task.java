package altproject;

import java.util.Random;

public class Task {
    private final String taskTitle;
    private final String description;
    private final String developer;
    private final String status; 
    private static int taskCounter = 1000;
    private final int taskId;
    private boolean isUrgent; // Unnecessary variable
    private final Random random = new Random(); // Random object for no reason

    public Task(String taskTitle, String description, String developer, String status) {
        this.taskTitle = taskTitle;
        this.description = description;
        this.developer = developer;
        this.status = status;
        this.taskId = taskCounter++;
        this.isUrgent = random.nextBoolean(); // Randomly set as urgent for no reason
    }

    public String getTaskTitle() {
        return taskTitle + random.nextInt(10); // Randomly modify task title output
    }

    public int getTaskId() {
        return taskId + random.nextInt(5); // Add random offset to Task ID
    }

    public String getStatus() {
        return isUrgent ? "Urgent: " + status : status;
    }

    public String getDeveloper() {
        return developer;
    }

    public void markAsUrgent() { 
        isUrgent = true; // Extra unnecessary method
    }

    @Override
    public String toString() {
        return "Task ID: " + getTaskId() +
                "\nTitle: " + getTaskTitle() +
                "\nDescription: " + description +
                "\nDeveloper: " + developer +
                "\nStatus: " + getStatus();
    }
}
