package lec04_1;

public class WordUtils {
    public static String longest(List61B<String> list) {
        int maxDex = 0;
        for(int i = 0; i < list.size(); i++) {
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if(thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }
//    public static String longest(SLList<String> list) {
//        int maxDex = 0;
//        for(int i = 0; i < list.size(); i++) {
//            String longestString = list.get(maxDex);
//            String thisString = list.get(i);
//            if(thisString.length() > longestString.length()) {
//                maxDex = i;
//            }
//        }
//        return list.get(maxDex);
//    }
//    public static String longest(AList<String> list) {
//        int maxDex = 0;
//        for(int i = 0; i < list.size(); i++) {
//            String longestString = list.get(maxDex);
//            String thisString = list.get(i);
//            if(thisString.length() > longestString.length()) {
//                maxDex = i;
//            }
//        }
//        return list.get(maxDex);
//    }

    public static void peek(List61B<String> list) {
        System.out.println(list.getLast());
    }
//    public static void peek(SLList<String> list) {
//        System.out.println(list.getFirst());
//    }

    public static void main(String[] args) {
//        SLList<String> someList = new SLList<>();
//        someList.addLast("elk");
//        someList.addLast("are");
//        someList.addLast("watching");
        AList<String> someAList = new AList<>();
        someAList.addLast("elk");
        someAList.addLast("are");
        someAList.addLast("watching");
        System.out.println(longest(someAList));
    }
}
