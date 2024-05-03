package org.example;

public class GLAB303_2_2 {

        public static void main(String[] args) {
            GLAB303_2_2.AutoTypeConversion();
            GLAB303_2_2.ExplicitTest();
        }

    public static void AutoTypeConversion() {
            int x = 20;
            int y = 40;
            long p = 30;
            float q = 10.60f;
// int z = x + y; (1) // Error; cannot convert from double to int.
            double z = x + y;
            System.out.println("Sum of two numbers: " + z);

// long r = p - q; // (2) // Error; cannot convert from float to long.
            float r = p - q;
            System.out.println("Subtraction of two numbers: " + r);
        }

    public static void ExplicitTest() {
            double d = 100.04;
// explicit type casting
            long l = (long)d;
            int i = (int)l;
            System.out.println("\n\nDouble value "+d);
            System.out.println("Long value "+l);
            System.out.println("Int value "+i);
            byte b;
            int z = 257;
            double doub = 323.142;

            System.out.println("\nConversion of int to byte.");
            b = (byte) z;
            //remainder of the division of 257 by 256 (the range of a byte)
            System.out.println("z = " + z + " b = " + b);

            System.out.println("Conversion of double to int.");
            z = (int) doub;
            System.out.println("doub = " + doub + " b = " + z);

            System.out.println("Conversion of double to byte.");
            b = (byte) doub;
            //remainder of the subtraction of 323 by 256 (the range of a byte)
            System.out.println("doub = " + doub + " b = " + b);
        }
    }
