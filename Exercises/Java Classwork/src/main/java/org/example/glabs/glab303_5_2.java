package org.example.glabs;
import java.math.*;
import java.util.Scanner;

public class glab303_5_2 {
    public static void main(String[] args) {
        glab303_5_2.highlow();
        glab303_5_2.SubtractionQuizLoop();
        glab303_5_2.SentinelValuedemo();
    }

    /*Write a program that randomly generates an integer between 0 and
100, inclusive. The program should prompt the user to enter a number
repeatedly until the number matches the randomly generated number.
● For each user input, the program tells the user whether the input is too
low or too high.
● When the user discovers the correct answer, the program outputs a
congratulatory message, and then provides the user with the
opportunity to play again.
     */
    public static void highlow() {
        Scanner in = new Scanner(System.in);
        int x = (int) (Math.random() * 101);

        System.out.println("\nGuess my number: ");
        int guess = in.nextInt();

        while (guess != x) {
            if (guess < x) {
                System.out.println("higher");
                guess = in.nextInt();
            } else if (guess > x) {
                System.out.println("lower");
                guess = in.nextInt();
            }
        }
        System.out.println("\nYou guessed it! My number was " + x);
    }


    public static void SubtractionQuizLoop() {
        final int NUMBER_OF_QUESTIONS = 5; // Number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();
        String output = ""; // output string is initially empty
        Scanner input = new Scanner(System.in);
        while (count < NUMBER_OF_QUESTIONS) {
// 1. Generate two random single-digit integers
            int number1 = (int) (Math.random() * 10);
            int number2 = (int) (Math.random() * 10);
// 2. If number1 < number2, swap number1 with number2
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
// 3. Prompt the student to answer "What is number1 - number2?"
            System.out.print(
                    "What is " + number1 + " - " + number2 + "? ");
            int answer = input.nextInt();
// 4. Grade the answer and display the result
            if (number1 - number2 == answer) {
                System.out.println("You are correct!");
                correctCount++;
            } else{
        System.out.println("Your answer is wrong.\n" + number1
                + " - " + number2 + " should be " + (number1 -
                number2));
// Increase the count
        count++;
        output += "\n" + number1 + "-" + number2 + "=" + answer +
                ((number1 - number2 == answer) ? " correct" : " wrong");
    }
}
}

        public static void SentinelValuedemo() {
// Create a Scanner
            Scanner input = new Scanner(System.in);
// Read an initial data
            System.out.print("Enter an int value (the program exits if the input is 0): ");
            int data = input.nextInt();
// Keep reading data until the input is 0
            int sum = 0;
            while (data != 0) {
                sum += data;
// Read the next data
                System.out.print( "Enter an int value (the program exits if the input is 0): ");
                data = input.nextInt();
            }
            System.out.println("The sum is " + sum);
}