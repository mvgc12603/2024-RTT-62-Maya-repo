package org.example.pas;

import java.util.Scanner;

public class pa303_4_1 {
    public static void main(String[] args) {
    pa303_4_1.lessOrGreater();
    pa303_4_1.range();
    pa303_4_1.day();
    }
/*
2. Write a program that declares 1 integer variable x, and then
assigns 7 to it. Write an if-else statement that prints out “Less than 10”
if x is less than 10, and “Greater than 10” if x is greater than 10.
Change x to 15 and notice the result.
*/

    public static void lessOrGreater()
    {
        int x = 7;
        for (int i=0; i<2;i++)
        {
            if (x < 10) {
                System.out.println("less than 10");
            } else if (x > 10) {
                System.out.println("more than 10");
            }
            x = 15;
        }
    }


/*4. Write a program that declares 1 integer variable x, and then
assigns 15 to it. Write an if-else statement that prints “Out of range” if
the number is less than 10 or greater than 20 and prints “In range” if
the number is between 10 and 20 (including equal to 10 or 20).
Change x to 5 and notice the result.
*/
    public static void range()
    {
        Scanner in = new Scanner (System.in);
        int y = in.nextInt();

        if (y<10 || y>20){
            System.out.println(y + "is out of range");
        }
        else {
            System.out.println(y + "is in range.");
        }
    }

    /*
Write a program that accepts an integer between 1 and 7 from
the user. Use a switch statement to print out the corresponding
weekday. Print “Out of range” if the number is less than 1 or greater
than 7. Do not forget to include “break” statements in each of your
cases.
 */
public static void day(){
    Scanner in = new Scanner (System.in);
    System.out.println("Inter int between 1 and 7");
    int y = in.nextInt();
    if (y<1 || y>7){
        System.out.println("Invalid input");
        System.exit(1);
    }
    else {
        switch (y)
        {
            case 1:
                System.out.println("Sonntag");
                break;

            case 2:
                System.out.println("Dienstag");
                break;

            case 3:
            System.out.println("Tuesday");
            break;

            case 4:
            System.out.println("Mittwoch");
            break;

            case 5:
            System.out.println("Donnerstag");
            break;

            case 6:
            System.out.println("Frietag");
            break;

            case 7:
            System.out.println("Samstag");
            break;
        }
    }
}

}
