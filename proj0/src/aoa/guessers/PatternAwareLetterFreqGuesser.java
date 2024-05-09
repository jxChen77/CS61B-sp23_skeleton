package aoa.guessers;

import aoa.utils.FileUtils;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */
    public char getGuess(String pattern, List<Character> guesses) {
        // TODO: Fill in this method.
        List<String> wordsMatch = getWords(pattern);
        Map<Character, Integer> tempFre = new TreeMap<Character, Integer>(getFreq(wordsMatch));
        int max=0;
        char maxCh=' ';
        for (Character ele : tempFre.keySet()) {
            if (!guesses.contains(ele) && tempFre.get(ele) > max) {
                max=tempFre.get(ele);
                maxCh = ele;
            }
        }
        return maxCh;

    }

    public Map<Character, Integer> getFreq(List<String> wordsList) {
        Map<Character, Integer> result = new HashMap<>();
        for (String ele : wordsList) {
            for (char item : ele.toCharArray()) {
                if (result.containsKey(item)) {
                    result.put(item, result.get(item) + 1);
                } else {
                    result.put(item, 1);
                }
            }
        }
        return result;
    }

    public List<String> getWords (String pattern) {
        List<String> result = new ArrayList<>();
        int patternLength = pattern.length();
        for (String ele : words) {
            if (ele.length() == patternLength) {
                boolean add = true;
                for (int i =0; i < patternLength; i++) {
                    if (pattern.toCharArray()[i] !='-' && pattern.toCharArray()[i] != ele.toCharArray()[i]) {
                        add = false;
                        break;
                    }
                }
                if (add) result.add(ele);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("-e--", List.of('e')));
    }
}