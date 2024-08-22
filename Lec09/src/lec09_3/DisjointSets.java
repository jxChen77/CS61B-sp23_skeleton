package lec09_3;

public interface DisjointSets {
    /** Connect two items P and Q **/
    void connect(int p, int q);

    /** Check to see if two items are connected. **/
    boolean isConnected(int p, int q);
}

