package ru.evendot.task2;

import java.util.HashMap;
import java.util.Map;

public class CurrencyRatesWorker {
    private final String[] currencies = {"USD", "EUR", "CNY", "KZT", "BYN", "RUB"};
    private Map<String, Double> currencyRates = new HashMap<>();

    /**
     * Инициализация предустановленным курсом валют
     */
    public void initCurrencyRatesWorker() {
        this.currencyRates.put("USD", 82.50);
        this.currencyRates.put("EUR", 97.80);
        this.currencyRates.put("CNY", 12.10);
        this.currencyRates.put("KZT", 0.15);
        this.currencyRates.put("BYN", 27.44);
        this.currencyRates.put("RUB", 1.00);

    }

    /**
     * Конвертирование заданной суммы из заданной валюты в рубли
     * @param amount Денежная сумма в заданной валюте
     * @param userCurrency Заданная валюта, доступная у пользователя
     * @return Денежная сумма в рублях
     */
    public double convertToRub(double amount, String userCurrency) {
        return amount * this.currencyRates.get(userCurrency);
    }

    /**
     * Конвертирование заданной суммы из рублей в заданную валюту
     * @param amount Денежная сумма в рублях
     * @param targetCurrency Заданная пользователем целевая валюта
     * @return Денежная сумма в заданной валюте
     */
    public double convertFromRub(double amount, String targetCurrency) {
        return amount / this.currencyRates.get(targetCurrency);
    }

    public Map<String, Double> getCurrencyRates() {
        return currencyRates;
    }

    public void setCurrencyRates(Map<String, Double> currencyRates) {
        this.currencyRates = currencyRates;
    }

    public String[] getCurrencies() {
        return currencies;
    }

}
