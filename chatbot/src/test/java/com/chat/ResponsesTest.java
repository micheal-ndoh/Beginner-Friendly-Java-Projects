// package com.chat;

// import java.util.ArrayList;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
// import static org.junit.Assert.assertTrue;
// import org.junit.Test;

// import com.chat.talk.Responses;

// public class ResponsesTest {

//     @Test
//     public void testGetHelloResponses() {
//         ArrayList<String> responses = Responses.getHelloResponses();
//         assertNotNull(responses);
//         assertEquals(3, responses.size());
//         assertTrue(responses.contains("Hello! How can I assist you today?"));
//         assertTrue(responses.contains("Hi there! What can I do for you?"));
//         assertTrue(responses.contains("Hey! Need any help?"));
//     }

//     @Test
//     public void testGetHowAreYouResponses() {
//         ArrayList<String> responses = Responses.getHowAreYouResponses();
//         assertNotNull(responses);
//         assertEquals(3, responses.size());
//         assertTrue(responses.contains("I'm just a program, but I'm doing great!"));
//         assertTrue(responses.contains("I'm functioning as expected! How about you?"));
//         assertTrue(responses.contains("I'm doing well! How are you?"));
//     }

//     @Test
//     public void testGetJokeResponses() {
//         ArrayList<String> responses = Responses.getJokeResponses();
//         assertNotNull(responses);
//         assertEquals(4, responses.size());
//         assertTrue(responses.contains("Why did the computer show up at work late? It had a hard drive!"));
//         assertTrue(responses.contains("Why do programmers prefer dark mode? Because light attracts bugs!"));
//         assertTrue(responses.contains("Why was the JavaScript developer sad? Because he didn't 'null' his feelings."));
//         assertTrue(responses.contains("Why do Java developers wear glasses?\nBecause they don't C#."));
//     }

//     @Test
//     public void testGetComplimentResponses() {
//         ArrayList<String> responses = Responses.getComplimentResponses();
//         assertNotNull(responses);
//         assertEquals(3, responses.size());
//         assertTrue(responses.contains("Thank you! You're awesome too!"));
//         assertTrue(responses.contains("I appreciate your kindness!"));
//         assertTrue(responses.contains("You made my day!"));
//     }
// }
