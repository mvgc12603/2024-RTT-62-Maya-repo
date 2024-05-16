package org.example.glabs.glab303_11_5;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSets {
    public static void main(String[] args) {
    }

    static void TreeSetExampleOne() {
        TreeSet<Integer> num_Treeset = new TreeSet<>();
        num_Treeset.add(20);
        num_Treeset.add(5);
        num_Treeset.add(15);
        num_Treeset.add(25);
        num_Treeset.add(10);
// Call iterator() method to define Iterator for TreeSet
        Iterator<Integer> iter_set = num_Treeset.iterator();
        System.out.print("TreeSet using Iterator: ");
// Access TreeSet elements using Iterator
        while (iter_set.hasNext()) {
            System.out.print(iter_set.next());
            System.out.print(", ");
        }
    }

    static void TreeSetExampleTwo() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);
        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);
        // Using the removeAll() method
        boolean value2 = numbers.removeAll(numbers);
        System.out.println("Are all elements removed? " + value2);
    }

    static void TreeSetExampleThree() {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("TreeSet: " + numbers);
// Using the first() method
        int first = numbers.first();
        System.out.println("First Number: " + first);
// Using the last() method
        int last = numbers.last();
        System.out.println("Last Number: " + last);
    }
}

