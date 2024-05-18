package org.example.glabs.glab303_11_2;

import java.util.ArrayList;
import java.util.List;

public class ArrayList6 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Steve");
        names.add("John");
        names.add("Steve");
        names.add("Maria");

        // Check if an ArrayList contains a given element
        System.out.println("Does names array contain \"Bob\"? : " + names.contains("Bob"));
        System.out.println("Does names array contain \"Bill\"? : " + names.contains("Bill"));

        // Find the index of the first occurrence of an element in an ArrayList
        printIndexOf(names, "Steve");
        printIndexOf(names, "Mark");

        // Find the index of the last occurrence of an element in an ArrayList
        printLastIndexOf(names, "John");
    }

    private static void printIndexOf(ArrayList<String> list, String element) {
        int index = list.indexOf(element);
        if (index == -1) {
            System.out.println("\"" + element + "\" does not exist.");
        }
        else{
            System.out.println("indexOf \"" + element + "\": " + index);
        }
    }

    private static void printLastIndexOf(ArrayList<String> list, String element) {
        int lastIndex = list.lastIndexOf(element);
        if (lastIndex == -1) {
            System.out.println("\"" + element + "\" does not exist.");
        }
        else{
            System.out.println("lastIndexOf \"" + element + "\": " + lastIndex);
        }
    }
}
