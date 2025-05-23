package com.unity;

import java.util.Random;
import java.util.Scanner;

public class HangMan {

    public static void main(String[] args) {
        String[][] levels = {
            {"cat", "dog", "ice"},
            {"java", "code", "game"},
            {"unity", "array", "loops"},
            {"random", "string", "marco"},
            {"computer", "program", "hangman"},
        };

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int level = 0;

        System.out.println("Welcome to Hangman game");

        // Main game loop for levels
        while (level < levels.length) {
            String[] words = levels[level];
            String word = words[new Random().nextInt(words.length)];
            char[] masked = new char[word.length()];
            for (int i = 0; i < masked.length; i++) {
                masked[i] = '_';
            }

            int lives = 6;
            StringBuilder wrongGuesses = new StringBuilder();

            System.out.println("\nLevel " + (level + 1) + " | Word has " + word.length() + " letters.");

            // Guessing loop
            while (lives > 0) {
                // Show masked word
                System.out.print("Word: ");
                for (char c : masked) {
                    System.out.print(c + " ");
                }
                System.out.println("\nLives: " + lives + " | Wrong guesses: " + wrongGuesses);

                // Get user guess
                System.out.print("\nGuess a letter: ");
                String input = scanner.nextLine().toLowerCase();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }
                char guess = input.charAt(0);

                // Check if guess is in word
                boolean found = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess && masked[i] == '_') {
                        masked[i] = guess;
                        found = true;
                    }
                }

                // Wrong guess logic
                if (!found) {
                    if (wrongGuesses.toString().indexOf(guess) == -1) {
                        wrongGuesses.append(guess).append(' ');
                        lives--;
                    } else {
                        System.out.println("You already guessed that letter.");
                    }
                }

                // Win condition
                if (String.valueOf(masked).equals(word)) {
                    score += 10 * (level + 1); // More points for higher levels
                    System.out.println("Correct! The word was: " + word);
                    System.out.println("Score: " + score);
                    level++; // Next level
                    break;
                }
            }

            // Lose condition
            if (lives == 0) {
                System.out.println("Game Over! The word was: " + word);
                break;
            }
        }

        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
