package services;

import java.util.List;
import utils.FileHandler;

public class TaskService {

    private List<Task> tasks;

    public TaskService() {
        this.tasks = FileHandler.loadTasks(); 
    }

    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task newTask = new Task(id, description);
        tasks.add(newTask);
        FileHandler.saveTasks(tasks);
    }

    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).setId(i + 1);
        }
        FileHandler.saveTasks(tasks);
    }

    public void markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsCompleted();
                break;
            }
        }
        FileHandler.saveTasks(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}