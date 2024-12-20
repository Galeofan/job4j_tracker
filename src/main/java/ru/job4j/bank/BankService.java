package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит хранилище клиентов и привязанных к ним счетов
 * Также содержит основные действия с хранилищем и метод перевода между счетами
 */
public class BankService {
    /**
     * Мап с клиентами и их счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод регистрации клиента в системе
     * @param user клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаления клиента из системы
     * @param passport паспорт
     */
    public void deleteUser(String passport) {
            users.remove(new User(passport, ""));
    }

    /**
     * Метод добавления счёта клиенту по паспорту
     * @param passport паспорт
     * @param account счёт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод поиска клиента по паспорту
     * @param passport паспорт
     * @return клиент
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод поиска счета по реквизитам
     * @param passport паспорт
     * @param requisite реквизиты
     * @return счёт
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            for (Account acc : list) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод перечисления денег с одного счёта на другой
     * @param sourcePassport паспорт отправителя
     * @param sourceRequisite счёт отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite счёт получателя
     * @param amount сумма
     * @return успешность отправки
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAcc = findByRequisite(sourcePassport, sourceRequisite);
        Account destAcc = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAcc == null || destAcc == null || sourceAcc.getBalance() < amount) {
            return false;
        }
        sourceAcc.setBalance(sourceAcc.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return true;
    }

    /**
     * Метод для тестов
     * @param user клиент
     * @return список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}