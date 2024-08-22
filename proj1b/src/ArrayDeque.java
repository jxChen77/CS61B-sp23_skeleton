import java.util.List;
import java.util.ArrayList;

public class ArrayDeque<T> implements Deque<T>{

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int cap = 10;

    public ArrayDeque() {
        this.size = 0;
        this.items = (T[])new Object[cap];
        this.nextLast = this.items.length/2;
        this.nextFirst = this.nextLast - 1;
    }

    public void resize(int extraCapacity){
        T[] newitems = (T[])new Object[this.size+extraCapacity];
        int index = 0;
        for(int i = 0; i < this.size; i++) {
            index = (this.nextFirst + 1 + i) % newitems.length;
            newitems[index] = this.get(i);
        }
        this.nextLast = (index + 1)% newitems.length;
        this.items = newitems;
    }

    @Override
    public void addFirst(T x) {
        if(this.size == this.items.length) {
            this.resize(this.size);
        }
        this.items[this.nextFirst] = x;
        this.nextFirst = (this.nextFirst + this.items.length - 1) % this.items.length;
        this.size++;
    }


    @Override
    public void addLast(T x) {
        if(this.size == this.items.length) {
            this.resize(this.size);
        }
        this.items[this.nextLast] = x;
        this.nextLast = (this.nextLast + 1) % this.items.length;
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < this.size; i++){
            int index = (this.nextFirst + i + 1) % this.items.length;
            returnList.add(this.items[index]);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if(this.size == 0) return null;
        this.nextFirst = (this.nextFirst + 1) % this.items.length;
        T returnValue = this.items[nextFirst];
        this.items[nextFirst] = null;
        this.size--;
        return returnValue;
    }

    @Override
    public T removeLast() {
        if(this.size == 0) return null;
        this.nextLast = (this.nextLast + this.items.length - 1) % this.items.length;
        T returnItem = this.items[this.nextLast];
        this.items[this.nextLast] = null;
        this.size--;
        return returnItem;
    }

    @Override
    public T get(int index) {
        if(index >= this.size || index < 0) return null;
        return this.items[(this.nextFirst+1+index) % this.items.length];
    }

    public static void main(String[] args) {
        Deque<Integer> ad = new ArrayDeque<>();
        for(int i = 0; i <= 100; i++){
            ad.addFirst(i);
        }
        ad.addLast(-1);
        ad.addLast(-2);
        ad.removeFirst();
        ad.removeLast();
        ad.removeFirst();
        ad.removeLast();
        System.out.println(ad.toList());
    }
}
