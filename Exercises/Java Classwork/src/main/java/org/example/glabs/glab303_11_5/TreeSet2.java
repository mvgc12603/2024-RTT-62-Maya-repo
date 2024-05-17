package org.example.glabs.glab303_11_5;
import java.util.*;


class cities_Comparator implements Comparator<String> {
    //override compare method to compare two elements of the TreeSet
    @Override
    public int compare(String cities_one, String cities_two) {
        int value = cities_one.compareTo(cities_two);
// sort elements in reverse order
        if (value > 0) {
            return -1;
        } else if (value < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

    class TreeSetExampleCom {
        public static void main(String[] args) {
// Create a TreeSet with user-defined comparator
            TreeSet<String> cities = new TreeSet<>(new cities_Comparator());
//add elements to the comparator
            cities.add("UAE");
            cities.add("Mumbai");
            cities.add("WashingtonDC");
            cities.add("Hyderabad");
            cities.add("Karachi");
            cities.add("Xanadu");
            cities.add("Lahore");
            cities.add("Montevideo");
            cities.add("Zagazig");
            cities.add("Yingkou");
//print the contents of TreeSet
            System.out.println("\nTreeSet: " + cities);
        }
    }
