package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private static final Object stub = new Object();
    private final TreeMap<T, Object> map;

    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    public SortedSet(Comparator<T> comparator) {
        map = new TreeMap<>(comparator);
    }

    public SortedSet() {
        map = new TreeMap<>();
    }

    public List<T> getSorted() {
        return new ArrayList<>(map.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(map.descendingKeySet());
    }

    @Override
    public boolean add(T key) {
        return map.put(key, stub) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean added = false;
        for (T key : collection){
            added |= add(key);
        }
        return added;
    }

    @Override
    public boolean remove(Object key) {
        if (key == null){
            throw new IllegalArgumentException("Argument is null");
        }
        return map.remove(key) == null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean removed = false;
        for (var value : collection) {
            removed |= map.remove(value) != null;
        }
        return removed;
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
