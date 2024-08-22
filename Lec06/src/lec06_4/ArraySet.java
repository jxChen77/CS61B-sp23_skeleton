package lec06_4;

import java.util.*;

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
        return new ArraySet.ArraySetIterator();
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

//    @Override
//    public String toString() {
//        String returnString = "{";
//        for(int i = 0; i < this.size - 1; i++) {
//            returnString += this.items[i] /**.toString()**/;
//            returnString += ", ";
//        }
////        for (T item : this){
////            returnString += item /**.toString()**/;
////            returnString += ", ";
////        }
//        returnString += this.items[this.size-1];
//        returnString += "}";
//        return returnString;
//    }

//    @Override
//    public String toString() {
//        StringBuilder returnSB = new StringBuilder("{");
//        for(int i = 0; i < this.size - 1; i++) {
//            returnSB.append(this.items[i] /**.toString()**/);
//            returnSB.append(", ");
//        }
//        returnSB.append(this.items[this.size-1]);
//        returnSB.append("}");
//        return returnSB.toString();
//    }

    /** bonus video**/
    @Override
    public String toString() {
        List<String> listofItems = new ArrayList<>();
        for(T x : this) {
            listofItems.add(x.toString());
        }
        return "{" + String.join(", ", listofItems) + "}";
    }

    public static <Glerp> ArraySet<Glerp> of(Glerp... stuff) {
        ArraySet<Glerp> returnSet = new ArraySet<Glerp>();
        for(Glerp x : stuff){
            returnSet.add(x);
        }
        return returnSet;
    }

    @Override
    public boolean equals(Object other){
        if (this==other) {
            return true;
        }
        if(other == null) {
            return false;
        }
        if(other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (o.size() != this.size()){
            return false;
        }
        for(T item : this) {
            if (!o.contains(item)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);
        System.out.println(aset);

        ArraySet<Integer> aset2 = new ArraySet<>();
        aset2.add(5);
        aset2.add(23);
        aset2.add(42);
        System.out.println(aset2);
        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(null));
        System.out.println(aset.equals(new int[]{5, 23, 42}));
        System.out.println(aset==aset2);
        System.out.println(aset.equals(aset));

        ArraySet<String> asetOfStrings = ArraySet.of("hi", "I'm", "here");
        System.out.println(asetOfStrings);
    }

}
