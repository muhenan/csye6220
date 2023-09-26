package com.example.hw4part6.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public void removeItem(int index) {
        items.remove(index);
    }
}
