package org.example.glabs;
import java.util.*;
import static java.lang.System.out;

public class glab303_3_1 {
    public static void main(String[] args) {
        glab303_3_1.stringDemo();
        glab303_3_1.stringSplit();
        glab303_3_1.DemoReplaceAll();
    }

    public static void stringDemo() {

        String str1 = "    Java";
        String str2 = "";
        String str3 = "Script";
            out.println(str1.length()); // 8
            out.println(str2.length()); // 0
            out.println("Java\n".length()); // 5
            out.println((str1+"Script").length()); // 14
            out.println((str1+str3).length());    // 14

        out.println(str1.isEmpty()); // false
        out.println(str2.isEmpty()); // true

        out.println(str1.compareTo(str2+'a')); //weird behaviour

        out.println(str1.toLowerCase()+", how are you?"); // without trim()
        out.println(str1.trim()+", how are you"); // with trim()
        String s = "Script";
        s+=s.toUpperCase();
        out.print(s);

        out.println("\n\n" + str1.indexOf('s')); //-1, because char not in string
        out.println(str1.lastIndexOf('a')); // 7, includes spaces

        out.println(str1.contains("ava"));

        out.println("\nThe first character in the message is " + s.charAt(0));


        String s1="hello";
        String s3="hemlo";
        String s4="flag";
        out.println(s1.compareTo(s3)); //-1 because "l" is only on time lower than "m"
        out.println(s1.compareTo(s4)); // 2 because "h" is 2 times greater than "f"

        out.println("hello + hemlo?" + s1.equals(s3));

        out.println(s1.replace('h', 'B'));
        out.println(s1.replace('b', 'J')); //returns original, B is capital
    }

    public static void stringSplit() {
            String vowels = "a::b::c::d:e";
// splitting the string at "::"
// storing the result in an array of strings
            String[] result = vowels.split("::");
// converting array to string and printing it
            out.println("result = " + Arrays.toString(result));
            out.println(result);     //gives memory location, not contents
        out.println(Arrays.toString(vowels.split("::")));  //same but on one line
            out.println("The first character in vowels is " + result[0]);
        }

    public static void DemoReplaceAll() {
            String str1 = "Java123is456fun";
// regex for sequence of digits
            String regex = "\\d+";
// replace all occurrences of numeric
// digits by a space
            System.out.println(str1.replaceAll(regex, " "));
        }
}
