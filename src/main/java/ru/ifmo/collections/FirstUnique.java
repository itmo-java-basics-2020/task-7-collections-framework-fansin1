package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    private final Map<Integer, Boolean> map = new LinkedHashMap<>();

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (var element : map.entrySet()) {
            if (element.getValue()) {
                return element.getKey();
            }
        }

        return -1;
    }

    public void add(int value) {
        var unique = !map.containsKey(value);
        map.put(value, unique);
    }
}
