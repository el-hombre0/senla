/**
 * Задание №2. Курс валют
 * Создай консольное приложение, которое запрашивает у пользователя сумму в одной валюте и
 * конвертирует её в другие валюты по фиксированному количеству обменных курсов. Курсы обмена
 * валюты задавать в виде чисел с плавающей точкой. Курсы можно задать внутри кода программы
 * как константы или один раз запрашивать при запуске программы и потом использовать их в
 * течение всей ее работы. Пяти валют будет достаточно для реализации.
 */
package ru.evendot.task2;

import java.util.*;

public class Task2 {

    /**
     * Варианты собственных курсов валют (для удобства)
     * 82.50 97.80 12.10 0.15 27.44 1.00
     * 95.00 112.34 6.80 0.67 10.15 1.0
     */
    public static void main(String[] args) {
        CurrencyRatesWorker currencyWorker = new CurrencyRatesWorker();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Конвертер валют");

            // Предлагается выбрать либо предустановленные курсы валют, либо задать их самостоятельно
            System.out.println("Вы хотите использовать заранее определенные курсы валют? (Д/н)");
            String userExchangeDecision = sc.nextLine();
            if (Objects.equals(userExchangeDecision, "Д")) {
                currencyWorker.initCurrencyRatesWorker();
                Map<String, Double> rates = currencyWorker.getCurrencyRates();
                System.out.println("Курсы на 25 сентября 2025");
                rates.forEach((key, val) -> {
                    System.out.println(key + ": " + val + " руб.");
                });

            } else {
                System.out.println("Введите ваши курсы валют через пробел в следующем порядке в формате 56.87 " +
                        Arrays.toString(currencyWorker.getCurrencies()) + ": ");
                String unparsedUserRates = sc.nextLine();

                // Парсинг введенных пользователем валют
                String[] ratesArray = unparsedUserRates.split(" ");
                String[] currencies = currencyWorker.getCurrencies();
                Map<String, Double> rates = new HashMap<>();

                // Заполнение пользовательского курса валют
                for (int i = 0; i < currencies.length; i++) {
                    rates.put(currencies[i], Double.parseDouble(ratesArray[i]));
                }
                currencyWorker.setCurrencyRates(rates);
            }
            System.out.println("Введите вашу валюту:");
            String userCurrency = sc.nextLine();

            System.out.println("Введите вашу сумму:");
            String userAmount = sc.nextLine();

            System.out.println("Введите целевую валюту:");
            String targetCurrency = sc.nextLine();

            // Если перевод из рублей
            if (Objects.equals(userCurrency, "RUB")) {
                double convertedAmount = currencyWorker.convertFromRub(Double.parseDouble(userAmount), targetCurrency);
                String result = String.format("%.2f", convertedAmount);
                System.out.println("Ваша сумма в " + targetCurrency + ": " + result);
            } else if (Objects.equals(targetCurrency, "RUB")) { // Если перевод в рубли
                double convertedAmount = currencyWorker.convertToRub(Double.parseDouble(userAmount), userCurrency);
                String result = String.format("%.2f", convertedAmount);
                System.out.println("Ваша сумма в " + targetCurrency + ": " + result);
            } else { // Если перевод не из рублей не в рубли
                double convertedToRubAmount = currencyWorker.convertToRub(Double.parseDouble(userAmount), userCurrency);
                double convertedFromRubAmount = currencyWorker.convertFromRub(convertedToRubAmount, targetCurrency);
                String result = String.format("%.2f", convertedFromRubAmount);
                System.out.println("Ваша сумма в " + targetCurrency + ": " + result);
            }
        }
    }
}
