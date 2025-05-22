package services;

public class Task {

    private int id;
    private String description;
    private boolean completed;

    public Task(int id, String description) {
        this(id, description, false);
    }

    public Task(int id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", description='" + description + "', completed=" + completed + '}';
    }
}
