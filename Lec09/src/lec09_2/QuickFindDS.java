package lec09_2;

public class QuickFindDS implements DisjointSets{
    private int [] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < this.id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return this.id[p] == this.id[q];
    }
}
