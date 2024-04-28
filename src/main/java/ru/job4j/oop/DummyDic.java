package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String rus = "Неизвестное слово. " + eng;
        System.out.println(rus);
        return rus;
    }

    public static void main(String[] args) {
        DummyDic test = new DummyDic();
        test.engToRus("Hello");
    }
}
