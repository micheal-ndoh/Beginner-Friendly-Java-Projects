package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import services.Task;

/**
 * Utility class for handling task persistence to and from a text file.
 * This class provides static methods to save, load, and delete tasks.
 */
public class FileHandler {

    private static final String FILE_NAME = "tasks.txt";

    /**
     * Saves a list of Task objects to a text file.
     * Each task is stored in CSV format: id,description,completed.
     *
     * @param tasks The list of tasks to be saved.
     */
    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," + task.getDescription() + "," + task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the text file into a List of Task objects.
     * If the file does not exist or is empty, an empty list is returned.
     *
     * @return List of Task objects loaded from the file.
     */
    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(Paths.get(FILE_NAME))) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    boolean completed = Boolean.parseBoolean(parts[2]);
                    tasks.add(new Task(id, description, completed));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Deletes the task storage file if it exists.
     * Logs an error message if the deletion fails.
     */
    public static void deleteTasks() {
        try {
            Files.deleteIfExists(Paths.get(FILE_NAME));
        } catch (IOException e) {
            System.err.println("Error deleting tasks file: " + e.getMessage());
        }
    }
}
