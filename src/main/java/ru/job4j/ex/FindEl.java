package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                throw new ElementNotFoundException("Элемент не найден");
            }
            if (key.equals(value[i])) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = new String[2];
        str[0] = null;
        str[1] = "1234";
        try {
            indexOf(str, "1234");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}