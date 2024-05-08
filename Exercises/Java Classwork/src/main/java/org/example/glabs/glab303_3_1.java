package org.example.glabs;

public class glab303_3_1 {
    public static void main(String[] args) {
        glab303_3_1.lengthDemo();
    }

    public static void lengthDemo() {

        String str1 = "    Java";
        String str2 = "";
            System.out.println(str1.length()); // 8
            System.out.println(str2.length()); // 0
            System.out.println("Java".length()); // 4
            System.out.println("Java\n".length()); // 5
            System.out.println((str1+"Script").length()); // 14

        System.out.println(str1.isEmpty()); // false
        System.out.println(str2.isEmpty()); // true

        System.out.println(str1.toLowerCase()+", how are you?"); // without trim()
        System.out.println(str1.trim()+", how are you"); // with trim()
        String s = "Script";
        s+=s.toUpperCase();
        System.out.print(s);
    }
}
