package org.example;
import static java.lang.System.*;

public class GLAB303_2_2 {

        public static void main(String[] args) {
            GLAB303_2_2.AutoTypeConversion();
            GLAB303_2_2.ExplicitTest();
            GLAB303_2_2.extraBitPractice();
        }

    public static void AutoTypeConversion() {
            int x = 20;
            int y = 40;
            long p = 30;
            float q = 10.60f;
// int z = x + y; (1) // Error; cannot convert from double to int.
            double z = x + y;
            out.println("Sum of two numbers: " + z);

// long r = p - q; // (2) // Error; cannot convert from float to long.
            float r = p - q;
            out.println("Subtraction of two numbers: " + r);
        }

    public static void ExplicitTest() {
            double d = 100.04;
// explicit type casting
            long l = (long)d;
            int i = (int)l;
            out.println("\n\nDouble value "+d);
            out.println("Long value "+l);
            out.println("Int value "+i);
            byte b;
            int z = 257;
            double doub = 323.142;

            out.println("\nConversion of int to byte.");
            b = (byte) z;
            //remainder of the division of 257 by 256 (the range of a byte)
            out.println("z = " + z + " b = " + b);

            out.println("Conversion of double to int.");
            z = (int) doub;
            out.println("doub = " + doub + " b = " + z);

            out.println("Conversion of double to byte.");
            b = (byte) doub;
            //remainder of the subtraction of 323 by 256 (the range of a byte)
            out.println("doub = " + doub + " b = " + b);
        }

    public static void extraBitPractice(){
        int x = 5;
    out.println("x = " + x);  //5
    x+=5;
    out.println("x+=5 is " + x);  //10
    x-=5;
    out.println("x-=5 is " + x);;  //5
    x*=5;
    out.println("x*=5 is " + x);;  //25
    x/=5;
    out.println("x/=5 is " + x);;  //5
    x%=5;
    out.println("x%=5 is " + x);;  //0
    x=5;                    //set x back to 5
    String binaryX = Integer.toBinaryString(x);
    out.println("\n5 in binary is: " + binaryX);
    x<<=1;
    out.println("x<<=n adds n 0s to " + binaryX);
    out.println(Integer.toBinaryString(x) + " is equivalent to " + x);
    x=5;                    //set x back to 5
    x>>=1;
    out.println("\nx>>=n removes n 0s from " + binaryX);
    out.println(Integer.toBinaryString(x) + " is equivalent to " + x + "\n");
    x=5;                    //set x to 20
    x&=20; //x = 20 & 5
    out.println("Let's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
            ", using the &(AND) operator (both need to = 1)" +
            "\nIt is equal to " + Integer.toBinaryString(x) + ", aka "+ x);
    x=5;
    x^=5;
    out.println("\nLet's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
            ", using the ^(XOR) operator (same=1, different=0)" +
            "\nIt is equal to " + Integer.toBinaryString(x) + ", aka "+ x);
    x=5;
    x|=5;
    out.println("\nLet's compare 20, aka " + Integer.toBinaryString(20) + ", to 5, aka " + Integer.toBinaryString(5) +
            ", using the |(OR) operator (at least one has to = 1)" +
            "\nIt is equal to " + Integer.toBinaryString(x) + ", aka "+ x);
}

    }

