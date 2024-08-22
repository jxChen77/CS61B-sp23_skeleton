package lec08_2;

import java.util.ArrayList;
import java.util.List;

public class Dup1 {
    public static boolean dup1(int[] A){
        for(int i = 0; i < A.length - 1; i++){
            for(int j = i+1; j < A.length; j++) {
                if(A[i] == A[j]) return true;
            }
        }
        return false;
    }


    public static boolean dup2(int[] A){
        for(int i = 0; i < A.length - 1; i++){
            if(A[i] == A[i+1]) return true;
        }
        return false;
    }

    public static int[] makeArray(int N) {
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = i;
        }
        return A;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] A = makeArray(N);
        dup1(A);
    }

}
