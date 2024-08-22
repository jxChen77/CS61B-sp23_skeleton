package lec02_2;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            this.item = i;
            this.next = n;
        }
    }

    /* The first Item(if exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    /** Create an empty list **/
    public SLList() {
        this.sentinel = new IntNode(63,null);
        size = 0;

    }
    public SLList(int x) {
        this.sentinel = new IntNode(63, null);
        this.sentinel.next = new IntNode(x, null);
        this.size = 1;
    }

    /** add int x to the first of the list **/
    public void addFirst(int x) {
        this.sentinel.next = new IntNode(x, this.sentinel.next);
        this.size++;
    }

    /** get the first item of the list **/
    public int getFirst() {
        return this.sentinel.next.item;
    }

    /** adds item to the end of the list **/
    public void addLast(int x) {
        IntNode p = this.sentinel;

        /** Move p to the end of the list **/
        while (p.next != null) {
            p = p.next;
        }
            p.next = new IntNode(x, null);
        this.size++;
    }

    /** Returns the size of the list that start at IntNode p **/
//    public static int size(IntNode p) {
//        if(p.next == null)
//            return 1;
//        return 1 + SLList.size(p.next);
//    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        SLList L = new SLList( );
//        L.addFirst(10);
//        L.addFirst(5);
        L.addLast(6);
        System.out.println(L.size());
    }
}
