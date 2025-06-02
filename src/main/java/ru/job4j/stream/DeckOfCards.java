package ru.job4j.stream;

import java.util.stream.Stream;

public class DeckOfCards {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(diamond -> Stream.of(Value.values())
                        .map(value -> value + " " + diamond))
                .forEach(System.out::println);
    }
}
