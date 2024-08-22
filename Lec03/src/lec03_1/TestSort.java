package lec03_1;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Test.*;

public class TestSort {
    /** Test the Sort.sort **/
    @Test
    public void testSort() {
        String[] input = {"I", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "I"};
        String[] ex = {"I", "have", "an", "egg"};
        Sort.sort(input);

        for (int i = 0; i < input.length; i += 1) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");
                break;
            }
        }

        /** if(input != ex) { That's compare the address of the two object **/
        if(!java.util.Arrays.equals(input, expected)){
            System.out.println("Error! There seems to be a problem with Sort.sort.");
        }

    }

    @Test
    public void testSort2 () {
        String[] input = {"I", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "I"};
        Sort.SelectionSort(input);
        assertArrayEquals(expected, input);

    }

    /** Test the sort.findSmallest **/
    @Test
    public void testFindSmallest() {
        String[] input = {"I", "have", "an",  "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input,0);
        assertEquals(expected, actual);

//        String[] input2 = {"There", "are", "many",  "pigs"};
//        String expected2 = "are";
//        String actual2 = Sort.findSmallest(input2);
//        org.junit.Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testSwap() {
        String[] input = {"I", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "I", "egg",};

        Sort.swap(input, a, b);
        assertArrayEquals(input, expected);
    }
//    public static void main(String[] args) {
//        //testSort();
//        testSort2();
//        testFindSmallest();
//        testSwap();
//    }
}
