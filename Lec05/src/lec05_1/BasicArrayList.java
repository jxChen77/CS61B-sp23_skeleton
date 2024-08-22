package lec05_1;

import java.util.ArrayList;

public class BasicArrayList {
    public static void main(String[] args) {
        ArrayList<String> L = new ArrayList<String>();
        L.add("potato");
        L.add("Ketchup");
        String first = L.get(0);

        ArrayList<Integer> I = new ArrayList<Integer>();
        I.add(5);
        I.add(6);
        int f = I.get(0);
        int x = 20;
        Integer a = new Integer(20);
        blah(x);
        blahPrimitive(a);
        blahDouble(x);
        double b = 20.9;
        blahInt((int)b);
    }

    public static void blah(Integer x) {
        System.out.println(x);
    }

    public static void blahPrimitive(int x) {
        System.out.println(x);
    }

    public static void blahDouble(double x ) {
        System.out.println("double: " + x);
    }

    public static void blahInt(int x) {
        System.out.println("int: " + x);
    }
}
