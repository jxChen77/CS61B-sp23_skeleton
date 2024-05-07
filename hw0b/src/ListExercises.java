import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum=0;
        for (Integer integer : L) {
            sum += integer;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> NewOne = new ArrayList<>();
        for (int ele : L) {
            if (ele % 2 == 0) {
                NewOne.add(ele);
            }
        }
        return NewOne;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> result = new ArrayList<>();
        int lengthL1 = L1.size(), lengthL2 = L2.size();

        if (lengthL1 <= lengthL2) {
            for (int ele : L1) {
                if (L2.contains(ele)) {
                    result.add(ele);
                }
            }
        }else{
            for (int ele : L2) {
                if (L1.contains(ele)) {
                    result.add(ele);
                }
            }

        }
        return result;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String ele : words) {
            for (int i = 0; i < ele.length(); i++) {
                count = ele.charAt(i) == c ? count + 1 : count;
            }
        }
        return count;
    }
}
