package ru.evendot.task1;

import java.util.List;
import java.util.Random;

public class GameWorker {
    public int getWordsLength(String[] words){
        return words.length;
    }

    public String chooseWord(String[] words, int maxBound ){
        Random rn = new Random();
        int randomNum = rn.nextInt(maxBound);
        return words[randomNum];
    }

    public boolean checkIfLetterInWord(String str, char ch, MutableInt foundCount) {
        if (str == null || foundCount == null) {
            return false;
        }

        // Подсчитываем общее количество вхождений символа в строке
        int totalCount = countCharOccurrences(str, ch);

        // Если символа нет в строке вообще
        if (totalCount == 0) {
            return false;
        }

        // Если уже нашли все вхождения
        if (foundCount.getValue() >= totalCount) {
            return false;
        }

        foundCount.increment();
        return true;
    }

    public static int countCharOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public void showFoundLettersInWord(String word, List<Character> foundChars){
        for (int i = 0; i < word.length(); i++) {
            boolean letterEntered = false;
            for (Character ch : foundChars) {
                if (word.charAt(i) == ch){
                    System.out.print(ch);
                    letterEntered = true;
                }
            }
            if(!letterEntered){
                System.out.print("_");
            }

        }
    }

}
