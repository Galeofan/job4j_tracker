package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> containsPhone = person -> person.getPhone().contains(key);
        Predicate<Person> containsName = person -> person.getName().contains(key);
        Predicate<Person> containsSurname = person -> person.getSurname().contains(key);
        Predicate<Person> containsAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = containsPhone.or(containsName).or(containsSurname).or(containsAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}