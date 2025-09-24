/**
 * Задание №1. Игра «Виселица» Реализуй игру «Виселица», где игрок пытается угадать слово,
 * вводя одну букву за раз. Если буква отсутствует в слове, то игрок теряет жизнь.
 * Игра заканчивается, когда игрок угадывает слово или теряет все жизни.
 * Слово для отгадывания выбирать случайно из списка слов-констант внутри программы.
 * После каждой введенной буквы выводить в консоль загадываемое слово с пропусками букв
 * и сообщение о том, сколько жизней осталось. Рисовать в консоли человечка на виселице
 * как иллюстрацию количества жизней (как это обычно бывает в «Виселице») не обязательно,
 * но будет приветствоваться.
 */

package ru.evendot.task1;

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        String[] words = new String[] {"Wednesday", "Powerbank", "Cup", "Paper", "Cactus", "Wall", "Window"};

        GameWorker gw = new GameWorker();
        int hiddenWordsArrayLen = gw.getWordsLength(words);

        String hiddenWord = gw.chooseWord(words, hiddenWordsArrayLen);

//        hiddenWord = "Wall";

        int hiddenWordLen = hiddenWord.length();
        Player player = new Player();


        int guessProgress = 0;
        List<Character> foundLetters = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

//        System.out.println("DEBUG ONLY -- hiddenWord: " + hiddenWord);
        while (player.getHp() != 0 && guessProgress != hiddenWordLen) {
            MutableInt charFoundCount = new MutableInt(0);
            int currHP = player.getHp();
            System.out.println("\nHP: " + currHP);
            System.out.println("Enter a letter: ");
            char letter = sc.next().charAt(0);
            if (gw.checkIfLetterInWord(hiddenWord, letter, charFoundCount)){
                guessProgress++;
                foundLetters.add(letter);
            }
            else {
                player.setHp(currHP - 1);
            }
            gw.showFoundLettersInWord(hiddenWord, foundLetters);
        }
        if (player.getHp() == 0){
            System.out.println("\n\nYou died!");
        } else if (guessProgress == hiddenWordLen) {
            System.out.println("\n\nYou won! Congratulations!!!");
        }
    }
}