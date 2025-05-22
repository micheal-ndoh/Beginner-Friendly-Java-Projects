
import java.util.List;
import java.util.Scanner;
import services.Task;
import services.TaskService;
import style.ColorStyle.Color;
import style.ColorStyle.Style;

public class Main {

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println(Style.BOLD + Color.PURPLE + "----------------------------------------" + Color.RESET + Style.RESET);
        System.out.println(Style.BOLD + Color.PURPLE + "| Welcome to the To-Do List Application |" + Color.RESET + Style.RESET);
        System.out.println(Style.BOLD + Color.PURPLE + "----------------------------------------" + Color.RESET + Style.RESET);
        do {
            System.out.println(Style.BOLD + Color.PURPLE + "\nTo-Do List Menu:\n" + Color.RESET + Style.RESET);
            System.out.println(Color.YELLOW + "1. Add a Task");
            System.out.println("2. Delete a Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit" + Color.RESET);
            System.out.print("\nEnter your choice: ");

            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(Color.RED + "\nInvalid input. Please enter a number between 1 and 5." + Color.RESET);
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print(Color.BLUE + "\nEnter task description: " + Color.RESET);
                    String description = scanner.nextLine();
                    taskService.addTask(description);
                    System.out.println(Color.GREEN + "Task successfully added" + Color.RESET);
                    break;

                case 2:
                    System.out.print(Color.BLUE + "\nEnter task ID to delete: " + Color.RESET);
                    try {
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        taskService.deleteTask(deleteId);
                        System.out.println(Color.GREEN + "Task " + deleteId + " deleted" + Color.RESET);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.RED + "Invalid task ID." + Color.RESET);
                    }
                    break;

                case 3:
                    List<Task> tasks = taskService.getTasks();
                    if (tasks.isEmpty()) {
                        System.out.println(Color.YELLOW + "No tasks found." + Color.RESET);
                    } else {
                        System.out.println(Style.BOLD + Color.PURPLE + "\nTasks List:\n" + Color.RESET + Style.RESET);
                        tasks.forEach(System.out::println);
                    }
                    break;

                case 4:
                    System.out.print(Color.BLUE + "\nEnter task ID to mark as completed: " + Color.RESET);
                    try {
                        int completeId = Integer.parseInt(scanner.nextLine());
                        taskService.markTaskAsCompleted(completeId);
                        System.out.println(Color.GREEN + "Task marked as completed." + Color.RESET);
                    } catch (NumberFormatException e) {
                        System.out.println(Color.RED + "Invalid task ID." + Color.RESET);
                    }
                    break;

                case 5:
                    System.out.println(Color.YELLOW + "Exiting..." + Color.RESET);
                    break;

                default:
                    System.out.println(Color.RED + "\nInvalid choice. Please enter a number between 1 and 5." + Color.RESET);
            }

        } while (choice != 5);

        scanner.close();
    }
}
