package lec04_2;

public class SLList<Item> implements List61B<Item> {
    private static class Node<Item> {
        public Item item;
        public Node<Item> next;

        public Node(Item i, Node n) {
            this.item = i;
            this.next = n;
        }
    }

    /* The first Item(if exists) is at sentinel.next. */
    private Node<Item> sentinel;
    private int size;

    /** Create an empty list **/
    public SLList() {
        this.sentinel = new Node(63,null);
        size = 0;

    }
    public SLList(Item x) {
        this.sentinel = new Node(63, null);
        this.sentinel.next = new Node(x, null);
        this.size = 1;
    }

    @Override
    /** adds item to the end of the list **/
    public void addLast(Item x) {
        Node p = this.sentinel;

        /** Move p to the end of the list **/
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node(x, null);
        this.size++;
    }

    @Override
    /** add int x to the first of the list **/
    public void addFirst(Item x) {
        this.sentinel.next = new Node(x, this.sentinel.next);
        this.size++;
    }

    @Override
    /** get the first item of the list **/
    public Item getFirst() {
        return this.sentinel.next.item;
    }

    @Override
    public Item getLast() {
        return null;
    }
    /** Returns the size of the list that start at IntNode p **/
//    public static int size(IntNode p) {
//        if(p.next == null)
//            return 1;
//        return 1 + SLList.size(p.next);
//    }

    @Override
    public Item get(int i){return null;}

    @Override
    public Item removeLast(){return null;}

    @Override
    public void insert(Item x, int position){}

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print(){
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
    }

    public static void main(String[] args) {
        SLList<String> L = new SLList<>();
//        L.addFirst(10);
//        L.addFirst(5);
        L.addLast("elk");
        System.out.println(L.size());
    }
}


