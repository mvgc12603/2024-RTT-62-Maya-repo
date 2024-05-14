package org.example.pas;

import java.util.Scanner;

public class pa303_5_1 {
    public static void main(String[] args) {
        pa303_5_1.multiplicationTable();
        pa303_5_1.Gcd();
        pa303_5_1.tuitionDouble();
    }

    //Write a program that uses nested for loops to print a multiplication table.
    public static void multiplicationTable() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                System.out.print("\t" + i * j);
            }
            System.out.println();
        }
    }

    /*Find the Greatest Common Divisor
❖ Write a program that prompts the user to enter two positive
integers, and find their greatest common divisor (GCD).
❖ Examples:
➢ Enter 2 and 4. The gcd is 2.
➢ Enter 16 and 24. The gcd is 8.
❖ How do you find the gcd?
Pages : 1
➢ Name the two input integers n1 and n2.
➢ You know number 1 is a common divisor, but it may not be
the gcd.
➢ Check whether k (for k = 2, 3, 4, and so on) is a common
divisor for n1 and n2, until k is greater than n1 or n2.
     */

    public static void Gcd() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two positive numbers separated by a space: ");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        in.nextLine();
        if (num1 <= 0 || num2 <= 0) {
            System.out.println("Invalid input.");
            System.exit(1);
        }
        for (int gcd = num1 + num2; gcd > 0; gcd--) {
            if (num1 % gcd == 0 && num2 % gcd == 0) {
                System.out.println("The gcd is " + gcd);
                System.exit(0);
            }
        }

    }

    /*Suppose the tuition for a university is $10,000 for the current year
and increases by 7 percent every year.
❑ In how many years will the tuition be doubled?
     */
    public static void tuitionDouble() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter this years tuition: ");
        double tuition = in.nextDouble();
        double initialTuition = tuition;
        System.out.println("Your tuition increases by 7% every year. " +
                "What a scam. Wanna know just how expensive a scam?");

        for (int years = 1; years < 50; years++) {
            tuition=tuition*1.07;
            if (tuition >= (initialTuition * 2)) {
                System.out.println("In " + years + " years, this tuition will be double per year. yay.");
                System.exit(0);
            }
        }
    }
}

