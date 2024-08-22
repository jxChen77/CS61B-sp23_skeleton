package lec02_1;

public class Walrus {
    public int weight;
    public double tuskSize;

    public Walrus(int w, double ts){
        this.weight = w;
        this.tuskSize = ts;
    }

    public static void main(String[] args) {
        Walrus w = new Walrus(4, 2.2);
    }
}
