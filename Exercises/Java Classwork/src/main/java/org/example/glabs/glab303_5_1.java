package org.example.glabs;
import java.util.Scanner;

public class glab303_5_1 {
    // Program to find the sum of natural numbers from 1 to 1000.
    public static void main(String[] args) {
        glab303_5_1.palindromeCheck();
    }

    public static void sum1000() {
        int sum = 0;
        int n = 1000;
// for loop
        for (int i = 1; i <= n; ++i) {
// body inside for loop
            sum += i; // sum = sum + i
        }
        System.out.println("Sum = " + sum);
    }

    public static void palindromeCheck(){
        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse)) {
            System.out.println("Entered string/number is a palindrome.");
        } else {
            System.out.println("Entered string/number isn't a palindrome.");
        }

    }
}
