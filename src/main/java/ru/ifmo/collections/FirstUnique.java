package ru.ifmo.collections;

import java.util.TreeSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final TreeSet<Integer> uniques = new TreeSet<>();

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        if (uniques.isEmpty()) {
            return -1;
        }
        return uniques.first();
    }

    public void add(int value) {
        if (uniques.contains(value)) {
            uniques.remove(value);
        } else {
            uniques.add(value);
        }
    }
}
