package org.example.glabs;

public class glab303_2_1 {

    public static void main (String[]args) {
        glab303_2_1.BitwiseOperatorsDemo();
        glab303_2_1.LogicalOperatorsDemo();
        glab303_2_1.UnaryOperator();
        glab303_2_1.AssignmentOperatorsDemo();
    }

    public static void AssignmentOperatorsDemo() {
// Assigning Primitive Values
            int j, k;
            j = 10; // j gets the value 10.
            j = 5; // j gets the value 5. The previous value is overwritten.
            k = j; // k gets the value 5.
            System.out.println("j is : " + j);
            System.out.println("k is : " + k);
// Multiple Assignments
            k = j = 10; // (k = (j = 10))
            System.out.println("j is : " + j);
            System.out.println("k is : " + k);
    }

    public static void LogicalOperatorsDemo() {

            boolean x = true;
            boolean y = false;
            System.out.println("x & y : " + (x & y));
            System.out.println("x && y : " + (x && y));
            System.out.println("x | y : " + (x | y));
            System.out.println("x || y: " + (x || y));
            System.out.println("x ^ y : " + (x ^ y));
            System.out.println("!x : " + (!x));

    }

    public static void BitwiseOperatorsDemo() {
            int x = 58; //111010
            int y = 13; //1101
            System.out.println("x & y : " + (x & y)); //returns 8 = 1000
            System.out.println("x | y : " + (x | y)); //63=111111
            System.out.println("x ^ y : " + (x ^ y)); //55=11011
            System.out.println("~x : " + (~x)); //-59
            System.out.println("x << y : " + (x << y));
            System.out.println("x >> y : " + (x >> y));
    }

    public static void UnaryOperator() {
            int sum = 1;
// sum is now 1
            System.out.println(sum);
            sum--;
// sum is now 0
            System.out.println(sum);
            sum++;
// sum is now 1
            System.out.println(sum);
        sum+=sum;
// sum is now 2
        System.out.println(sum);
            sum = -sum;
// sum is now -2
            System.out.println(sum);
            boolean result = false;
// false
            System.out.println(result);
// true
            System.out.println(!result);

        }

}