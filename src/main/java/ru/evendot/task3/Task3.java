/**
 * Задание №3. Генератор паролей
 * Напиши программу, которая генерирует случайный безопасный пароль длиной от 8 до 12 символов.
 * Пароль должен содержать заглавные и строчные буквы, цифры и специальные символы.
 * Предоставь пользователю возможность выбрать длину пароля.
 */
package ru.evendot.task3;

import java.util.Random;
import java.util.Scanner;


public class Task3 {

    // Наборы символов для пароля
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    // Объединение всех символов
    private static final String ALL_CHARS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL;

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Генератор паролей");

        while (true) {
            try {
                System.out.print("\nВведите желаемую длину пароля (8-12 символов) или '0' для выхода: ");
                int length = scanner.nextInt();

                if (length == 0) {
                    System.out.println("Программа завершена.");
                    break;
                }

                if (length < 8 || length > 12) {
                    System.out.println("Ошибка: длина пароля должна быть от 8 до 12 символов!");
                    continue;
                }

                String password = generatePassword(length);
                System.out.println("Сгенерированный пароль: " + password);
                System.out.println("Длина пароля: " + password.length() + " символов");

                // Проверка безопасности пароля
                checkPasswordSecurity(password);

            } catch (Exception e) {
                System.out.println("Ошибка: введите корректное число!");
                scanner.nextLine(); // Очистка буфера
            }
        }

        scanner.close();
    }

    /**
     * Генерирует случайный безопасный пароль заданной длины
     * @param length длина пароля (8-12 символов)
     * @return сгенерированный пароль
     */
    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        // Гарантируем наличие хотя бы одного символа из каждой категории
        password.append(getRandomChar(LOWERCASE));
        password.append(getRandomChar(UPPERCASE));
        password.append(getRandomChar(DIGITS));
        password.append(getRandomChar(SPECIAL));

        // Заполняем оставшуюся длину случайными символами из всех категорий
        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(ALL_CHARS));
        }

        // Перемешиваем символы для большей случайности
        return shuffleString(password.toString());
    }

    /**
     * Возвращает случайный символ из заданной строки
     * @param charSet строка с набором символов
     * @return случайный символ
     */
    private static char getRandomChar(String charSet) {
        int symbolsLen = charSet.length();
        int index = random.nextInt(symbolsLen);
        return charSet.charAt(index);
    }

    /**
     * Перемешивает символы в строке для увеличения случайности
     * @param input исходная строка
     * @return перемешанная строка
     */
    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

    /**
     * Проверяет безопасность сгенерированного пароля
     * @param password пароль для проверки
     */
    private static void checkPasswordSecurity(String password) {
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (LOWERCASE.indexOf(c) != -1)
                hasLowercase = true;
            else if (UPPERCASE.indexOf(c) != -1)
                hasUppercase = true;
            else if (DIGITS.indexOf(c) != -1)
                hasDigit = true;
            else if (SPECIAL.indexOf(c) != -1)
                hasSpecial = true;
        }

        System.out.println("\nПроверка безопасности пароля:");
        System.out.println("Строчные буквы: " + (hasLowercase ? "Да" : "Нет"));
        System.out.println("Заглавные буквы: " + (hasUppercase ? "Да" : "Нет"));
        System.out.println("Цифры: " + (hasDigit ? "Да" : "Нет"));
        System.out.println("Специальные символы: " + (hasSpecial ? "Да" : "Нет"));

        if (hasLowercase && hasUppercase && hasDigit && hasSpecial) {
            System.out.println("Пароль соответствует всем требованиям безопасности!");
        } else {
            System.out.println("Пароль не соответствует всем требованиям!");
        }
    }
}
