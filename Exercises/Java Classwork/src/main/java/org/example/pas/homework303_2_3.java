package org.example.pas;

import static java.lang.System.*;

public class homework303_2_3 {

    public static void main(String[] args) {
        homework303_2_3.extraBitPractice();
        homework303_2_3.leftShift();
        homework303_2_3.bitWiseAnd();
        homework303_2_3.increments();
    }


    public static void extraBitPractice() {
        int x = 5;
        out.println("x = " + x);  //5
        x += 5;
        out.println("x+=5 is " + x);  //10
        x -= 5;
        out.println("x-=5 is " + x);  //5
        x *= 5;
        out.println("x*=5 is " + x);  //25
        x /= 5;
        out.println("x/=5 is " + x);  //5
        x %= 5;
        out.println("x%=5 is " + x);  //0
        x = 5;                    //set x back to 5
        String binaryX = Integer.toBinaryString(x);
        out.println("\n5 in binary is: " + binaryX);
        x <<= 1;
        out.println("x<<=n adds n 0s to " + binaryX);
        out.println(Integer.toBinaryString(x) + " is equivalent to " + x);
        x = 5;                    //set x back to 5
        x >>= 1;
        out.println("\nx>>=n removes n 0s from " + binaryX);
        out.println(Integer.toBinaryString(x) + " is equivalent to " + x + "\n");
        x = 5;                    //set x to 20
        x &= 20; //x = 20 & 5
        out.println("Let's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
                ", using the &(AND) operator (both need to = 1)" +
                "\nIt is equal to " + Integer.toBinaryString(x) + ", aka " + x);
        x = 5;
        x ^= 5;
        out.println("\nLet's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
                ", using the ^(XOR) operator (same=1, different=0)" +
                "\nIt is equal to " + Integer.toBinaryString(x) + ", aka " + x);
        x = 5;
        x |= 5;
        out.println("\nLet's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
                ", using the |(OR) operator (at least one has to = 1)" +
                "\nIt is equal to " + Integer.toBinaryString(x) + ", aka " + x);
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
        out.println(Integer.toBinaryString(x) + " equivalent to " + x); //100, 4

        int y = 9;
        out.println("\n" + Integer.toBinaryString(y) + " equivalent to " + y); //1001
        y <<= 1;
        out.println(Integer.toBinaryString(y) + " equivalent to " + y); //10010, 18

        int v = 17;
        out.println("\n" + Integer.toBinaryString(v) + " equivalent to " + v); //10001
        v <<= 1;
        out.println(Integer.toBinaryString(v) + " equivalent to " + v); //100010, 34

        int z = 88;
        out.println("\n" + Integer.toBinaryString(z) + " equivalent to " + z); //1011000
        z <<= 1;
        out.println(Integer.toBinaryString(z) + " equivalent to " + z); //10110000, 176
    }

    public static void bitWiseAnd() {
    /* Write a program that declares three int variables: x, y, and z. Assign 7 to x and 17 to y.
    Write a comment that indicates what you predict will be the result of the bitwise and
    operation on x and y. Now use the bitwise AND (&) operator to derive the decimal and
    binary values, and assign the result to z.
    */
        int x = 7, y = 17, z;
        z = x & y;
        out.println("\nComparing " + x + " and " + y + " aka " +
                Integer.toBinaryString(x) + " and " + Integer.toBinaryString(y) +  //comparing 111 & 10001 will give 1
                " with & operator gives us: " + Integer.toBinaryString(z) + " equivalent to " + z);
    }

    /*
    Write a program that declares an integer variable, assigns a number, and uses a
    postfix increment operator to increase the value. Print the value before and after the
    increment operator.
    + Write a program that demonstrates at least three ways to increment a variable by 1
    and does this multiple times. Assign a value to an integer variable, print it, increment
    by 1, print it again, increment by 1, and then print it again
     */
    public static void increments() {
        int b = 5;
        out.print("b++ is " + b++);
        out.print("\nNow b is " + b);
        b = 5;
        out.print("\n++b is " + ++b);
        b = 5;
        b += 1;
        out.println("\nb+=1 is " + b);
    }
}
