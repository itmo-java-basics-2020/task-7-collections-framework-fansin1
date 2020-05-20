package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {

    private final PriorityQueue<Integer> sortedNumbers;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        sortedNumbers = new PriorityQueue<>();
        for (int number : numbers) {
            sortedNumbers.add(number);
        }
    }

    public int add(int val) {
        sortedNumbers.add(val);
        while (sortedNumbers.size() > k) {
            sortedNumbers.poll();
        }
        return sortedNumbers.peek();
    }
}
