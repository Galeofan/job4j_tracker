package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[2];
        str[0] = "12345";
        str[1] = null;
        try {
            indexOf(str, "1234");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}