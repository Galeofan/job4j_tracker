package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        boolean exist = false;
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (acc.equals(account)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> list = getAccounts(user);
        if (user != null) {
            for (Account acc : list) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}