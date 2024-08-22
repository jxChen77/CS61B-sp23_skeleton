package lec02_1;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size(){
        if(this.rest==null) {
            return 1;
        }
        return 1 + this.rest.size();

    }

    /** return the size of the list using iteration, no recursion!**/
    public int iterativeSize() {
        IntList p =this;
        int totalSize = 0;
        while(p!=null) {
            totalSize++;
            p = p.rest;
        }
        return totalSize;

    }

    /** return the ith item of this IntNode**/
    public int get(int i) {
        if(i == 0) return this.first;
        return this.rest.get(i-1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
//        L.first = 5;
//        L.rest = null;

        L= new IntList(10,L);
//        L.rest.first = 10;

        L.rest.rest = new IntList(5,L);
//        L.rest.rest.first = 15;
        System.out.println(L.size());
    }
}
