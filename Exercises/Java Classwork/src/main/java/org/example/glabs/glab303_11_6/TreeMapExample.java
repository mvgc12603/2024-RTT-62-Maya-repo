package org.example.glabs.glab303_11_6;
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> numbers = new TreeMap<>();
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Ninety", 90);
        numbers.put("Three", 3);
        numbers.put("Four", 4);

        System.out.println("TreeMap: " + numbers);
// remove method with single parameter
        int value = numbers.remove("Two");
        System.out.println("Removed value: " + value);
// remove method with two parameters
        boolean result = numbers.remove("Three", 3);
        System.out.println("Is the entry {Three=3} removed? " + result);
        System.out.println("Updated TreeMap: " + numbers);

        String firstKey = numbers.firstKey();
        System.out.println("First Key: " + firstKey);
// Using the lastKey() method
        String lastKey = numbers.lastKey();
        System.out.println("Last Key: " + lastKey);
// Using firstEntry() method
        System.out.println("First Entry: " + numbers.firstEntry());
// Using the lastEntry() method
        System.out.println("Last Entry: " + numbers.lastEntry());
    }
}