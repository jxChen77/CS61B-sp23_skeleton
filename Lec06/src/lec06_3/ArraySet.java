package lec06_3;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        this.items = (T[]) new Object[100];
        this.size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < this.size; i++) {
            /**if(items[i] == null) return true; **/
            if(items[i].equals(x)) return true;
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x == null) {
            throw new IllegalArgumentException("can't add null!");
        }
        if (this.contains(x)) return;
        items[size++] = x;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return this.size;
    }

    /** returns an iterator (a.k.a seer) into ME */
    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator(){
            this.wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return this.wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[this.wizPos];
            this.wizPos++;
            return returnItem;
        }
    }

    public static void main(String[] args) {
        Set<Integer> jset = new HashSet<>();
        jset.add(5);
        jset.add(23);
        jset.add(42);

        Iterator<Integer> seer = jset.iterator();
        while(seer.hasNext()) {
            int i = seer.next();
            System.out.println(i);
        }
        for (int i : jset) {
            System.out.println(i);
        }

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(10);
        aset.add(11);
        aset.add(12);
        Iterator<Integer> aseer = aset.iterator();
        while(aseer.hasNext()) {
            int i = aseer.next();
            System.out.println(i);
        }
        for (int i : aset) {
            System.out.println(i);
        }

    }

}
