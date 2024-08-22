package lec04_1;

public class AList<Item> implements List61B<Item> {
    private int size;
    private Item[] items;

    public AList (){
        this.size = 0;
        this.items = (Item[]) new Object[100];
    }

    @Override
    public void addLast(Item x) {
        if(this.size == this.items.length) {
            this.resize(2 * this.size);
        }
        this.items[this.size] = x;
        this.size++;
    }

    @Override
    public void addFirst(Item x) {
        Item[] newItems = (Item[]) new Object[this.size+1];
        System.arraycopy(this.items,0, newItems, 1, this.size );
        newItems[0] = x;
        this.items = newItems;
        this.size++;
    }

    @Override
    public Item getFirst() {
        return this.items[0];
    }

    @Override
    public Item getLast() {
        return this.items[size-1];
    }

    @Override
    public Item get(int i) {
        return this.items[i];
    }

    @Override
    public Item removeLast() {
        Item last = this.getLast();
        this.items[this.size-1] = null;
        this.size--;
        return last;
    }

    @Override
    public void insert(Item x, int position) {
        Item[] newItems = (Item[]) new Object[this.size+1];
        System.arraycopy(this.items,0, newItems, 0, position);
        System.arraycopy(this.items,position, newItems, position+1, this.size - position);
        newItems[position] = x;
        this.items = newItems;
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void resize(int capacity) {
        Item[] newItems = (Item[]) new Object[capacity];
        System.arraycopy(this.items, 0, newItems, 0, this.size);
        this.items = newItems;
        this.size++;
    }













}
