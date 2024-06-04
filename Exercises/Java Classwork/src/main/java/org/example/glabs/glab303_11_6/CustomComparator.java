package org.example.glabs.glab303_11_6;
import java.util.Comparator;

public class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer number1, Integer number2) {

        if (number1 < number2) {
            return -1;
        }
        else if (number1 > number2) {
            return 1;

        } else {
            return 0;
        }
    }
}