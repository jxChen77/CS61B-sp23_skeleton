package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.*;

public class PAGALetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PAGALetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN and the GUESSES that have been made. */
    public char getGuess(String pattern, List<Character> guesses) {
        // TODO: Fill in this method.
        List<String> wordsMatch = getWords(pattern, guesses);
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

    public List<String> getWords (String pattern, List<Character> gusses) {
        List<String> result = new ArrayList<>();
        List<Character> noList = new ArrayList<>();
        for (Character ch : gusses) {
            if (pattern.indexOf(ch) == -1) {
                noList.add(ch);
            }
        }
        int patternLength = pattern.length();
        for (String ele : words) {
            boolean add = true;
            if (ele.length() == patternLength) {
                for (int i =0; i < patternLength; i++) {
                    if (pattern.toCharArray()[i] !='-' && pattern.toCharArray()[i] != ele.toCharArray()[i]) {
                        add = false;
                        break;
                    } else if (pattern.toCharArray()[i] == '-' && gusses.contains(ele.toCharArray()[i]) ){
                        add = false;
                        break;
                    }
                    else {
                        for (Character ch : noList) {
                            if (ele.indexOf(ch) != -1 ) {
                                add = false;
                                break;
                            }
                        }

                    }
                }
                if (add) result.add(ele);
            }

        }
        return result;
    }


    public static void main(String[] args) {
        PAGALetterFreqGuesser pagalfg = new PAGALetterFreqGuesser("data/example.txt");
        System.out.println(pagalfg.getGuess("----", List.of('e')));
    }
}
