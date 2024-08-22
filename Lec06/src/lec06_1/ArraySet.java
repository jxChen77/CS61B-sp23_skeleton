package lec06_1;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
public class ArraySet<T> /**implements Iterable<T>**/ {
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
            throw new IllegalArgumentException("can't add null to an Arrayset!");
        }
        if (this.contains(x)) return;
        items[size++] = x;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
    //    s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());

        Set<String> s2 = new HashSet<>();
        s2.add(null);
        System.out.println(s2.contains(null));


    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
