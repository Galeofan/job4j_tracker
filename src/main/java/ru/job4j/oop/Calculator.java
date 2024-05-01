package ru.job4j.oop;

public class Calculator {

    private static int x = 10;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int add = sum(10);
        int sub = minus(20);
        Calculator mul = new Calculator();
        Calculator div = new Calculator();
        Calculator all = new Calculator();
        System.out.println(add);
        System.out.println(sub);
        System.out.println(mul.multiply(10));
        System.out.println(div.divide(50));
        System.out.println(all.sumAllOperation(10));
    }
}
