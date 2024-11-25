package ru.job4j.cast;

public class Plain implements Vehicle {
    @Override
    public void move() {
        System.out.println("Plain is flying");
    }
}
