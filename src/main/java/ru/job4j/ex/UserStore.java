package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername() == login) {
                result = user;
                break;
            } else {
                throw new UserNotFoundException("Пользователь не найден");
            }
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean isvalid = false;
        if (user.isValid()) {
            if (user.getUsername().length() < 3) {
                throw new UserInvalidException("Пользователь не валидный");
            }
            isvalid = true;
        } else {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return isvalid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}