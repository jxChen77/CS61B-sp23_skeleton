package aoa.choosers;

import edu.princeton.cs.algs4.StdRandom;
import aoa.utils.FileUtils;

import java.util.List;

public class RandomChooser implements Chooser {
    private final String chosenWord;
    private String pattern;

    public RandomChooser(int wordLength, String dictionaryFile) {
        // TODO: Fill in/change this constructor.
        if (wordLength < 1)
            throw new IllegalArgumentException("Argument wordlength less than one");

        List<String> wordsList = FileUtils.readWordsOfLength(dictionaryFile, wordLength);
        if (wordsList.isEmpty())
            throw new IllegalStateException("No such length word in the file");
        int numWords = wordsList.size();
        int randomlyChosenWordNumber = StdRandom.uniform(numWords);
        chosenWord = wordsList.get(randomlyChosenWordNumber);
        pattern = "-".repeat(wordLength);
    }

    @Override
    public int makeGuess(char letter) {
        // TODO: Fill in this method.
        int count = 0;
        char[] wordList = chosenWord.toCharArray();
        char[] patternList = pattern.toCharArray();
        for (int i = 0 ; i < wordList.length; i++ ) {
            if (wordList[i] == letter) {
                patternList[i] = letter;
                count++;
            }

        }
        pattern = new String(patternList);
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
        return this.chosenWord;
    }
}
