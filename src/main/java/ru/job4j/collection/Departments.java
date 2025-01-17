package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();
        for (String value : departments) {
            String path = "";
            for (String element : value.split("/")) {
                if (path.isEmpty()) {
                    temp.add(element);
                    path = element;
                } else {
                    path = path + "/" + element;
                    temp.add(path);
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