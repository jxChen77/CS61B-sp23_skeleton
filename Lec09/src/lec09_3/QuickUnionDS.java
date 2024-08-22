package lec09_3;

public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int N) {
        this.parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    private int find(int p) {
        int r = p;
        while(this.parent[r] >= 0) {
            r = this.parent[r];
        }
        return r;
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        this.parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
