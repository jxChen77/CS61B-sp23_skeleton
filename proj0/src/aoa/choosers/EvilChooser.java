package aoa.choosers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdRandom;
import aoa.utils.FileUtils;

public class EvilChooser implements Chooser {
    private String pattern;
    private List<String> wordPool;

    public EvilChooser(int wordLength, String dictionaryFile) {
        // TODO: Fill in this constructor.
        if (wordLength < 1)
            throw new IllegalArgumentException("Argument wordlength less than one");

        wordPool = FileUtils.readWordsOfLength(dictionaryFile, wordLength);
        if (wordPool.isEmpty())
            throw new IllegalStateException("No such length word in the file");
//        int numWords = wordsList.size();
//        int randomlyChosenWordNumber = StdRandom.uniform(numWords);
//        chosenWord = wordsList.get(randomlyChosenWordNumber);
        pattern = "-".repeat(wordLength);

    }

    @Override
    public int makeGuess(char letter) {
        // TODO: Fill in this method.
        char[] patternArray;
        String tempPattern;
        Map<String, List<String>> patternList = new TreeMap<>();
        for (String ele : this.wordPool) {
            patternArray = this.pattern.toCharArray();
            for (int i = 0; i < ele.length(); i++){
                if (ele.toCharArray()[i] == letter) {
                    patternArray[i] = letter;
                }
            }
            tempPattern = new String(patternArray);
            if (!patternList.containsKey(tempPattern)) {
                List<String> tempWordList = new ArrayList<>();
                tempWordList.add(ele);
                patternList.put(tempPattern, tempWordList);
            }
            else patternList.get(tempPattern).add(ele);
        }
        int max =0 ;
        for (String ele : patternList.keySet()) {
            if (patternList.get(ele).size() > max) {
                max = patternList.get(ele).size();
                this.wordPool = patternList.get(ele);
                this.pattern = ele;
            }
        }
        int count = 0;
        for (char i : this.pattern.toCharArray() ) {
            count += i == letter ? 1 : 0;
        }
        return count;
    }

    @Override
    public String getPattern() {
        // TODO: Fill in this method.
        return this.pattern;
    }

    @Override
    public String getWord() {
        // TODO: Fill in this method.
        if (this.wordPool.size() > 1) {
            int numWords = this.wordPool.size();
            int randomlyChosenWordNumber = StdRandom.uniform(numWords);
            return this.wordPool.get(randomlyChosenWordNumber);
        }
        else return this.wordPool.get(0);
    }
}
