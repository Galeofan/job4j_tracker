package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель клиента банка
 */
public class User {
    /**
     * Паспорт клиента
     */
    private String passport;
    /**
     * Имя клиента
     */
    private String username;

    /**
     * Канонический конструктор
     * @param passport
     * @param username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер паспорта
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер паспорта
     * @param passport новый паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер имени клиента
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер имени клиента
     * @param username новое имя клиента
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}