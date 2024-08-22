package lec06_1;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class SimpleBuiltInListExample {
    public static void main(String[] args) {
        List<Integer> L = new ArrayList<>();
        L.add(5);
        L.add(10);
        L.add(15);
        System.out.println(L);

        Set<String> S = new HashSet<>();
        S.add("Tokyo");
        S.add("Beijing");
        S.add("Lagos");
        S.add("Sao Paulo");
        System.out.println(S.contains("Tokyo"));
        System.out.println(S.size());
        System.out.println(S);
    }
}
