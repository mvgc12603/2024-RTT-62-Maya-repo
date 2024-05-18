package org.example.glabs.glab303_11_2;

import java.util.*;

public class WaysToLoopThroughArray {
    public static void main(String[] args) {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Phineas and Ferb");
        tvShows.add("How I Met Your Mother");
        tvShows.add("Once Upon a Time");
        tvShows.add("I Dream of Jeannie");
        System.out.println("\n=== Iterate using an iterator() ===");

        Iterator<String> tvShowIterator = tvShows.iterator(); //create iterator for ArrayList tvShows

        while (tvShowIterator.hasNext()) {
            String tvShow = tvShowIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("\n==Iterate using an iterator(). forEachRemaining() method, and Lambda ===");
        tvShowIterator = tvShows.iterator();
        tvShowIterator.forEachRemaining(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for (String tvShow : tvShows) {
            System.out.println(tvShow);
        }
        System.out.println("\n=== Iterate using for loop with index ===");

        for (int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }
        System.out.println("\n=== Iterate iterator ===");
        ListIterator iterator = tvShows.listIterator();
        System.out.println("Elements in forward direction");
        System.out.println("\n====== Iterate using while loop=======");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("\n=========Elements in backward direction======");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
