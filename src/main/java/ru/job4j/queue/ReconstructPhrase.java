package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder evenBuilder = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                evenBuilder.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return evenBuilder.toString();
    }

    private String getDescendingElements() {
        StringBuilder descBuilder = new StringBuilder();
        int size = descendingElements.size();
        for (int i = size; i > 0; i--) {
                descBuilder.append(descendingElements.pollLast());
        }
        return descBuilder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}