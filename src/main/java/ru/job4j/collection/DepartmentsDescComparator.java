package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] first = left.split("/");
        String[] second = right.split("/");
        int result = second[0].compareTo(first[0]);
        if (result == 0) {
            int minLength = Math.min(first.length, second.length);
            for (int i = 1; i < minLength; i++) {
                result = first[i].compareTo(second[i]);
                if (result != 0) {
                    return result;
                }
            }
            return Integer.compare(first.length, second.length);
        }
        return result;
    }
}