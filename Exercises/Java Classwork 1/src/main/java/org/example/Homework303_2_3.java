package org.example;
import static java.lang.System.*;

public class Homework303_2_3 {

    public static void main(String[] args) {
        Homework303_2_3.leftShift();
    }
    public static void leftShift() {

    /* 1. Write a program that declares an integer a variable x, assigns the value 2 to it, and
    prints out the binary string version of the number (Integer.toBinaryString(x) ). Now,
    use the left shift operator (<<) to shift by 1 and assign the result to x. Before printing
    the results, write a comment with the predicted decimal value and binary string. Now,
    print out x in decimal form and in binary notation.
    Perform the preceding exercise with the following values:
        a. 9
        b. 17
        c. 88
*/
        int x = 2;
        out.println(Integer.toBinaryString(x) + " equivalent to " + x); //10
        x <<= 1;
        out.println(Integer.toBinaryString(x)+ " equivalent to " + x); //100, 4

        int y = 9;
        out.println("\n" + Integer.toBinaryString(y) + " equivalent to " + y); //1001
        y <<= 1;
        out.println(Integer.toBinaryString(y)+ " equivalent to " + y); //10010, 18

        int v = 17;
        out.println("\n" + Integer.toBinaryString(v) + " equivalent to " + v); //10001
        v <<= 1;
        out.println(Integer.toBinaryString(v)+ " equivalent to " + v); //100010, 34

        int z = 88;
        out.println("\n" + Integer.toBinaryString(z) + " equivalent to " + z); //1011000
        z <<= 1;
        out.println(Integer.toBinaryString(z)+ " equivalent to " + z); //10110000, 176
    }

}
