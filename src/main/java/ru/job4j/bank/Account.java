package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счёта
 */
public class Account {
    /**
     * Реквизиты счёта
     */
    private String requisite;
    /**
     * Баланс счёта
     */
    private double balance;

    /**
     * Канонический конструктор
     * @param requisite
     * @param balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер реквизитов
     * @return реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер реквизитов
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер баланса
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер баланса
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}