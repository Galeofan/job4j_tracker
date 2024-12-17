package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("20Andrew12@mail.ru", "FIO");
        map.put("Test@mail.ru", "FIO1");
        map.put("Test2@mail.ru", "FIO2");
        map.put("Test2@mail.ru", "FIO3");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
