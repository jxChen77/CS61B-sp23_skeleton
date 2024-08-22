package lec04_1;

public interface List61B<Item> {
    public void addLast(Item x);
    public void addFirst(Item x);
    public Item getFirst();
    public Item getLast();
    public Item get(int i);
    public Item removeLast();
    public void insert(Item x, int position);
    public int size();
    default public void print() {
        for(int i = 0; i < this.size(); i++) {
            System.out.println(get(i) + " ");
        }
        System.out.println();
    }
}
