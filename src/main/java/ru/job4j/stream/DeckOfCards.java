package ru.job4j.stream;

import java.util.stream.Stream;

public class DeckOfCards {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(value -> new Card(s, value)))
                .forEach(System.out::println);
    }
}
