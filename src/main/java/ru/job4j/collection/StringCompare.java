package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Integer.compare(left.length(), right.length());
        int result = 0;
        if (length < 0) {
            for (int i = 0; i < left.length() - 1; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < right.length() - 1; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }
            }
        }
        result = (result == 0 && length > 0 || result == 0 && length < 0) ? length : result;
            return result;
    }
}