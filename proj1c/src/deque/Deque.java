package deque;

import java.util.List;

/**
 * Created by hug on 2/4/2017. Methods are provided in the suggested order
 * that they should be completed.
 */
public interface Deque<T> extends Iterable<T> {

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    void addFirst(T x);

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    void addLast(T x);

    /**
     * Returns a List copy of the deque. Does not alter tne deque.
     *
     * @return a new list copy of the deque.
     */
    List<T> toList();

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    int size();

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    T removeFirst();

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    T removeLast();

    /**
     * The Deque abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively.Does
     * not alter the deque.
     *
     * @param index index to get, assumes valid index
     * @return element at {@code index} in the deque
     */
    T get(int index);

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively.
     *
     * @param index index to get, assumes valid index
     * @return element at {@code index} in the deque
     */
    T getRecursive(int index);

    String toString();

    boolean equals(Object obj);
    public static void main(String[] args) {
        Deque<String> lld1 = new ArrayDeque<>();
        Deque<String> lld2 = new ArrayDeque<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        lld2.addLast("front");
        lld2.addLast("middle");
        lld2.addLast("back");
        for (String s : lld1) {
            System.out.println(s);
        }
        System.out.println(lld1);
        System.out.println(lld1.equals(lld2));
    }
}