
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Chatbot: Hi I'm your friendly chatbot. Type 'bye' to exit.");

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine().toLowerCase();

            if (userInput.contains("hello")) {
                System.out.println("Chatbot: Hello How can I assist you today");
            } else if (userInput.contains("how are you")) {
                System.out.println("Chatbot: I'm doing okay, how about you");
            } else if (userInput.equals("bye")) {
                System.out.println("Chatbot: Goodbye Have a great day");
                break;
            } else {
                System.out.println("Chatbot: I'm sorry, I didn't understand that.");
            }
        }

        scanner.close();
    }
}
