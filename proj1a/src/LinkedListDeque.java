import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T>  {

    public class Node{
        T value;
        Node next;
        Node prev;
        public Node() {
            this.prev = null;
            this.next = null;
        }
        public Node(T v){
            this.value = v;
            this.next = null;
            this.prev = null;
        }
        public Node(T v, Node p, Node n) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }
    }

    private Node first;
    private Node last;
    private int size;
    public LinkedListDeque () {
        this.first = new Node();
        this.last = new Node();
        this.first.next=this.last;
        this.last.prev = this.first;
        this.size = 0;
    }
    @Override
    public void addFirst(T x) {
        Node insertNode = new Node(x,this.first,this.first.next);
        this.first.next.prev = insertNode;
        this.first.next = insertNode;
        this.size++;
    }

    @Override
    public void addLast(T x) {
        Node insertNode = new Node(x,this.last.prev,this.last);
        this.last.prev.next = insertNode;
        this.last.prev = insertNode;
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node temp = this.first;
        while(temp.next != this.last) {
            temp = temp.next;
            returnList.add(temp.value);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if(this.size <= 0) return null;
        else{
            this.first.next.next.prev = this.first;
            Node removeNode = this.first.next;
            T returnValue = removeNode.value;
            this.first.next = this.first.next.next;
            this.size--;
            return returnValue;
        }
    }

    @Override
    public T removeLast() {
        if(this.size <= 0) return null;
        else{
            this.last.prev.prev.next = this.last;
            Node removeNode = this.last.prev;
            T returnValue = removeNode.value;
            this.last.prev = this.last.prev.prev;
            this.size--;
            return returnValue;
        }
    }

    @Override
    public T get(int index) {
        if(index < this.size && index >= 0){
            Node temp = this.first.next;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }

    public T getRecursiveHelper(Node node, int index) {
        if(index == 0) return node.value;
        else return getRecursiveHelper(node.next, index -1);

    }

    @Override
    public T getRecursive(int index) {
        if(index < this.size && index >= 0){
            return getRecursiveHelper(this.first.next, index);
        }
        return null;

    }
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(2);
        lld.addFirst(3);
        lld.addLast(1);
        lld.addFirst(4);

        System.out.println(lld.toList());
        int value1 = lld.get(1);
    }
}
