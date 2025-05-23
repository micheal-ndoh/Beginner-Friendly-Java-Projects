package com.chat;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.chat.talk.Responses;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;
            Random random = new Random();

            ArrayList<String> helloResponses = Responses.getHelloResponses();
            ArrayList<String> howAreYouResponses = Responses.getHowAreYouResponses();

            System.out.println("Chatbot: Hi I'm your friendly chatbot. Type 'bye' to exit.");

            while (true) {
                System.out.print("You: ");
                userInput = scanner.nextLine().toLowerCase().trim();

                if (userInput.replaceAll("\\s+", "").contains("hello")) {
                    System.out.println("Chatbot: " + helloResponses.get(random.nextInt(helloResponses.size())));
                } else if (userInput.replaceAll("\\s+", "").contains("howareyou")
                        || userInput.replaceAll("\\s+", "").contains("howyou")) {
                    System.out.println("Chatbot: " + howAreYouResponses.get(random.nextInt(howAreYouResponses.size())));
                } else if (userInput.replaceAll("\\s+", "").contains("joke")) {
                    System.out.println("Chatbot: " + Responses.getJokeResponses().get(random.nextInt(Responses.getJokeResponses().size())));
                } else if (userInput.replaceAll("\\s+", "").contains("compliment")) {
                    System.out.println("Chatbot: " + Responses.getComplimentResponses().get(random.nextInt(Responses.getComplimentResponses().size())));
                } else if (userInput.equals("bye")) {
                    System.out.println("Chatbot: Goodbye! Have a great day!");
                    break;
                } else {
                    System.out.println("Chatbot: I'm sorry, I didn't understand that.");
                }
            }
        } catch (Exception e) {
            System.out.println("Chatbot: Oops! Something went wrong: " + e.getMessage());
        }
    }
}
