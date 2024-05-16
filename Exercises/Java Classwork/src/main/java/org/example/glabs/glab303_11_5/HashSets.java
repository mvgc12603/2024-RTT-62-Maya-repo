package org.example.glabs.glab303_11_5;

import java.util.HashSet;

public class HashSets {

    public static void main(String[] args) {
        HashSets.exampleOne();
    }

    static void exampleOne() {
        HashSet<Integer> evenNumber = new HashSet<>();
// Using add() method
        evenNumber.add(2);
        evenNumber.add(4);
        evenNumber.add(6);
        System.out.println("HashSet: " + evenNumber);
        HashSet<Integer> numbers = new HashSet<>();
// Using addAll() method
        System.out.println("Union is: " + numbers);
    }

    static void exampleTwo() {
        HashSet<Integer> evenNumbers = new HashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("HashSet1: " + evenNumbers);
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(3);
        System.out.println("HashSet2: " + numbers);
// Union of two set
        numbers.addAll(evenNumbers);
    }

    static void exampleThree() {
        HashSet<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("HashSet1: " + primeNumbers);
        HashSet<Integer> oddNumbers = new HashSet<>();
        oddNumbers.add(1);
        oddNumbers.add(3);
        oddNumbers.add(5);
        System.out.println("HashSet2: " + oddNumbers);
// Difference between HashSet1 and HashSet2
        primeNumbers.removeAll(oddNumbers);
        System.out.println("Difference : " + primeNumbers);
    }

    static void exampleFour() {
        // HashSet declaration
        HashSet<String> hset = new HashSet<String>();
// Adding elements to the HashSet
        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
//Addition of duplicate elements
        hset.add("Apple");
        hset.add("Mango");
//Addition of null values
        hset.add(null);
        hset.add(null);
// Using advanced for loop
        for (String str : hset) {
            System.out.println(" ---> " + str);
        }
    }
}