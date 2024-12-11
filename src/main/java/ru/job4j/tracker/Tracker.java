package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(int id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId() == id) {
                result = item;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = 0;
        for (Item element : items) {
            if (element.getId() == id) {
                index = items.indexOf(element);
                item.setId(id);
                items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public void delete(int id) {
        int index = 0;
        for (Item element : items) {
            if (element.getId() == id) {
                index = items.indexOf(element);
                items.remove(index);
                break;
            }
        }
    }
}