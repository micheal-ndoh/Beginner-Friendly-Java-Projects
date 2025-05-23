
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"rock", "paper", "scissors", "lizard", "spock"};
        System.out.println("Welcome to Rock-Paper-Scissors-Lizard-Spock game");

        while (true) {
            System.out.print("Enter your move (rock, paper, scissors, lizard, spock or quit): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            if (!Arrays.asList(options).contains(input)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            String player2Move = options[random.nextInt(options.length)];
            System.out.println("Player2 chose: " + player2Move);

            if (input.equals(player2Move)) {
                System.out.println("Draw");
            } else if ((input.equals("rock") && (player2Move.equals("scissors") || player2Move.equals("lizard")))
                    || (input.equals("paper") && (player2Move.equals("rock") || player2Move.equals("spock")))
                    || (input.equals("scissors") && (player2Move.equals("paper") || player2Move.equals("lizard")))
                    || (input.equals("lizard") && (player2Move.equals("spock") || player2Move.equals("paper")))
                    || (input.equals("spock") && (player2Move.equals("scissors") || player2Move.equals("rock")))) {
                System.out.println("You win");
            } else {
                System.out.println("Player2 wins");
            }
        }

        scanner.close();
    }
}
