package com.chat.talk;

import java.util.ArrayList;

public class Responses {
    public static ArrayList<String> getHelloResponses() {
        ArrayList<String> helloResponses = new ArrayList<>();
        helloResponses.add("Hello! How can I assist you today?");
        helloResponses.add("Hi there! What can I do for you?");
        helloResponses.add("Hey! Need any help?");
        return helloResponses;
    }

    public static ArrayList<String> getHowAreYouResponses() {
        ArrayList<String> howAreYouResponses = new ArrayList<>();
        howAreYouResponses.add("I'm just a program, but I'm doing great!");
        howAreYouResponses.add("I'm functioning as expected! How about you?");
        howAreYouResponses.add("I'm doing well! How are you?");
        return howAreYouResponses;
    }

    public static ArrayList<String> getJokeResponses() {
        ArrayList<String> jokeResponses = new ArrayList<>();
        jokeResponses.add("Why did the computer show up at work late? It had a hard drive!");
        jokeResponses.add("Why do programmers prefer dark mode? Because light attracts bugs!");
        jokeResponses.add("Why was the JavaScript developer sad? Because he didn't 'null' his feelings.");
        jokeResponses.add("Why do Java developers wear glasses?\nBecause they don't C#.");
        return jokeResponses;
    }

    public static ArrayList<String> getComplimentResponses() {
        ArrayList<String> complimentResponses = new ArrayList<>();
        complimentResponses.add("Thank you! You're awesome too!");
        complimentResponses.add("I appreciate your kindness!");
        complimentResponses.add("You made my day!");
        return complimentResponses;
    }
}