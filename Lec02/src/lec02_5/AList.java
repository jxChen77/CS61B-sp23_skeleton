package lec02_5;

public class AList<Item> {
    private Item[] items;
    private int size;

    /** Create an empty list **/
    public AList() {
        this.items = (Item[])new Object[100];
        this.size = 0;
    }

    /** Resizes the underlying array to the target capacity**/
    public void resize(int capacity) {
        Item[] newItems = (Item[])new Object[capacity];
        System.arraycopy(this.items, 0, newItems, 0, size);
        this.items = newItems;
    }
    /** Inserts x into the back of the list */
    public void addLast(Item x ){
        if(this.size == this.items.length) {
            this.resize(size+1);
        }
        this.items[size] = x;
        this.size++;
    }

    /** Return the item from the back of the list */
    public Item getLast(){
        return this.items[size-1];
    }

    /** Gets the ith item in the list (0 is the front) */
    public Item get(int i) {
        return this.items[i];
    }

    /** Return the number of items in the list */
    public int size() {
        return this.size;
    }

    /** Deletes the item from back of the list and
      * return deleted item */
    public Item removeLast() {
        Item last = this.items[size-1];
        this.items[size-1] = null;
        size--;
        return last;
    }



}
