package ru.evendot.task1;

import java.util.List;
import java.util.Random;

/**
 * Бизнес-логика игры
 */
public class GameWorker {
    /**
     * Получить длину массива слов
     *
     * @param words Массив слов
     * @return Длина слова
     */
    public int getWordsLength(String[] words) {
        return words.length;
    }

    /**
     * Выбор случайного слова
     *
     * @param words    Массив слов
     * @param maxBound Верхняя граница
     * @return Выбранное слово
     */
    public String chooseWord(String[] words, int maxBound) {
        Random rn = new Random();
        int randomNum = rn.nextInt(maxBound);
        return words[randomNum];
    }

    /**
     * Подсчет количества вхождений буквы в слове
     *
     * @param str Слово
     * @param ch  Буква
     * @return Количество вхождений буквы в слове
     */
    public int countCharOccurrences(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(ch)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Отображение слова с учетом отгаданных букв
     *
     * @param word       Слово
     * @param foundChars Отгаданные буквы
     */
    public void showFoundLettersInWord(String word, List<Character> foundChars) {
        for (int i = 0; i < word.length(); i++) {
            boolean letterEntered = false;
            for (Character ch : foundChars) {
                char targetChRegisterCopy = word.charAt(i);
                char foundChRegisterCopy = ch;
                if (Character.toLowerCase(targetChRegisterCopy) == Character.toLowerCase(foundChRegisterCopy)) {
                    System.out.print(targetChRegisterCopy);
                    letterEntered = true;
                }
            }
            if (!letterEntered) {
                System.out.print("_");
            }
        }
    }
}
