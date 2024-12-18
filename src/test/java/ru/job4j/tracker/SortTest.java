package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class SortTest {
    @Test
    void whenItemAscByName() {
      List<Item> items = Arrays.asList(new Item(1, "abc"),
                                       new Item(3, "ghj"),
                                       new Item(2, "def")
                                       );
      List<Item> expected = Arrays.asList(new Item(1, "abc"),
                                          new Item(2, "def"),
                                          new Item(3, "ghj")
                                          );
      Collections.sort(items, new ItemAscByName());
      assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemDescByName() {
        List<Item> items = Arrays.asList(new Item(1, "abc"),
                                         new Item(3, "ghj"),
                                         new Item(2, "def")
                                         );
        List<Item> expected = Arrays.asList(new Item(3, "ghj"),
                                            new Item(2, "def"),
                                            new Item(1, "abc")
                                            );
        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}
