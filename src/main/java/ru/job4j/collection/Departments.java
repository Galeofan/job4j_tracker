package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                if (value.startsWith(element)) {
                    temp.add(element);
                    start = element;
                } else {
                    start = start + "/" + element;
                    temp.add(start);
                }
            }
        }
            result.addAll(temp);
            return result;
        }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        Collections.sort(departments, new DepartmentsDescComparator());
    }
}