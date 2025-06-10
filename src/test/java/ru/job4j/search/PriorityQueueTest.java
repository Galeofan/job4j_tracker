package ru.job4j.search;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPrioritySecond() {
        var queue = new PriorityQueue();
        queue.put(new Task("low5", 5));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("middle3", 3));
        queue.put(new Task("middle2", 2));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent1");
    }

    @Test
    public void whenHigherPriorityFifth() {
        var queue = new PriorityQueue();
        queue.put(new Task("low2", 2));
        queue.put(new Task("urgent1", 1));
        queue.put(new Task("middle3", 3));
        queue.put(new Task("middle4", 5));
        queue.put(new Task("middle5", 4));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("urgent1");
    }

    @Test
    public void whenHigherPriorityEquals() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 5));
        queue.put(new Task("middle", 5));
        var result = queue.take();
        assertThat(result.getDescription()).isEqualTo("low");
    }
}