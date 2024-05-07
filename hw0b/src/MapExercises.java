import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter,
     * where 'a' is 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> result = new HashMap<>();
        char ele = 'a';
        for (int i = 0; i < 26;) {
            result.put((char) (ele + i),++i);
        }
        return result;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num, num*num);
        }
        return result;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> result = new HashMap<>();
        for (String ele : words) {
            int count = 0;
            for (String item : words) {
                count += Objects.equals(ele, item) ?  1 : 0;
            }
            result.put(ele,count);
        }
        return result;
    }
}
