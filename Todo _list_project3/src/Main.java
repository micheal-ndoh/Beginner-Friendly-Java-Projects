
import java.util.List;
import java.util.Scanner;
import services.Task;
import services.TaskService;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Menu:\n");
            System.out.println("1. Add a Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task description: ");
                    String desc = scanner.nextLine();
                    taskService.addTask(desc);
                    System.out.println("Task added");
                    break;

                case 2:
                    System.out.print("\nEnter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskService.deleteTask(deleteId);
                    System.out.println("Task deleted");
                    break;

                case 3:
                    List<Task> tasks = taskService.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        tasks.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print("\nEnter task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    taskService.markTaskAsCompleted(completeId);
                    System.out.println("Task marked as completed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
