package lec01_1;

public class LargerDemo {
    public static int larger(int a, int b){
        int max = a>b ? a: b;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(larger(8,10));
    }
}
