package org.example;
import java.util.Scanner; // import the Scanner class


public class Homework303_2_1 {
        public static void main(String[] args) {

                Homework303_2_1.addInts();
                Homework303_2_1.addDouble();
                Homework303_2_1.addIntandDouble();
                Homework303_2_1.divideInt();
                Homework303_2_1.divideDouble();
                Homework303_2_1.divideIntCast();
                Homework303_2_1.constantCalc();
                Homework303_2_1.cafePrices();
        }


        public static int addInts() {
/*
● Write a program that declares two integer variables, assigns an integer to each, and
adds them together. Assign the sum to a variable. Print out the result.
*/
                Scanner in = new Scanner(System.in);

                System.out.println("\nThis is a very basic 'Integer' calculator.");

                System.out.print("Enter an Integer value: ");
                int i = in.nextInt();

                System.out.print("Enter another Integer value: ");
                int j = in.nextInt();

                int sum = i + j;
                System.out.println("The sum is: " + sum);
                return sum;
        }


        public static double addDouble() {
/*
● Write a program that declares two double variables, assigns a number to each, and
adds them together. Assign the sum to a variable. Print out the result.
*/
                Scanner in = new Scanner(System.in);

                System.out.println("\nThis is a very basic 'Double' calculator.");

                System.out.print("Enter a Double value: ");
                double a = in.nextDouble();

                System.out.print("Enter another Double value: ");
                double b = in.nextDouble();

                double sum = a + b;
                System.out.println("The sum is: " + sum);
                return sum;
        }


        public static double addIntandDouble() {
/*
● Write a program that declares an integer variable and a double variable, assigns
numbers to each, and adds them together. Assign the sum to a variable. Print out the
result. What variable type must the sum be?
*/
                Scanner in = new Scanner(System.in);

                System.out.println("\nThis is a very basic calculator.");

                System.out.print("Enter an Integer value: ");
                int o = in.nextInt();

                System.out.print("Enter a Double value: ");
                double p = in.nextDouble();

                double sum = o + p;
                System.out.println("The sum is: " + sum);
                return sum;
        }

        public static double divideInt() {
/*
● Write a program that declares two integer variables, assigns an integer to each, and
divides the larger number by the smaller number. Assign the result to a variable. Print
out the result. Now change the larger number to a decimal. What happens? What
corrections are needed?
Incorrect approximation, result made double from declaration.
*/
                Scanner in = new Scanner(System.in);
                double result;

                System.out.println("\nThis is a very basic 'Integer' calculator.");

                System.out.print("Enter an Integer value: ");
                int c = in.nextInt();

                System.out.print("Enter another Integer value: ");
                double d = in.nextInt();

                if (c > d) {
                        result = c / d;
                } else {
                        result = d / c;
                }

                System.out.println("The result is: " + result);
                return result;
        }


        public static double divideDouble() {
/*
● Write a program that declares two double variables, assigns a number to each, and
divides the larger by the smaller number. Assign the result to a variable. Print out the
result. Now, cast the result to an integer. Print out the result again.
*/
                Scanner in = new Scanner(System.in);
                double result;

                System.out.println("\nThis is a very basic 'Double' calculator.");

                System.out.print("Enter a Double value: ");
                double e = in.nextDouble();

                System.out.print("Enter another Double value: ");
                double f = in.nextDouble();

                if (e > f) {
                        result = e / f;
                } else {
                        result = f / e;
                }

                System.out.println("The result is: " + result);

                System.out.println("The Integer result is: " + (int) result);
                System.out.println("The trimmed Integer result is: " + (int) result);
                System.out.println("The rounded Integer result is: " + (int) Math.round(result));

                return (int) result;
        }

        public static double divideIntCast() {
/*
● Write a program that declares two integer variables, x and y, and assigns the number 5
to x and the number 6 to y. Declare a variable q and assign y/x to it and print q. Now,
cast y to a double and assign it to q. Print q again.
*/
                int x = 5;
                int y = 6;
                double q = x / y;

                System.out.println("If both terms are integers, 5/6 = " + q + "\n");
                q = (double) y / x;
                System.out.println("If one term is a double, 5/6 = " + q + "\n");
                return q;
        }


        public static double constantCalc() {
/*
● Write a program that declares a named constant and uses it in a calculation. Print the
result.
*/
                final double PI = 3.1415926535897932384626433;

                Scanner in = new Scanner(System.in);

                System.out.print("Enter a Double value for your radius: ");
                double r = in.nextDouble();

                System.out.print("Circle perimeter is approx. " + 2*PI*r);
                System.out.print("\nCircle area is approx. " + PI*(r*r));

                return PI;
        }

        public static double cafePrices() {
        /*
● Write a program where you create three variables that represent products at a cafe.
The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
Assign prices to each product. Create two more variables called subtotal and totalSale
and complete an “order” for three items of the first product, four items of the second
product, and two items of the third product. Add them all together to calculate the
subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to
obtain the totalSale amount. Be sure to format the results to two decimal places.
*/

                String[] cafeProducts = {"Dragon Drink", "Cake Pop", "Impossible Sandwich", "Lemon Pound Cake"};
                Double[] cafeProductPrices = {5.18, 4.20, 11.89, 4.0};
                double subtotal, totalSale;

                subtotal = 3*cafeProductPrices[0] + 4*cafeProductPrices[1] + 2*cafeProductPrices[2];
                final double SALES_TAX = subtotal*0.07;
                totalSale = subtotal+SALES_TAX;
                System.out.printf("Your total purchase price is " + "%.2f", totalSale);

                return totalSale;


        }
}