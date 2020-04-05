package ru.itparkkazan.beans;

import java.util.List;

/**
 * Интерфейс персона
 */
public interface Person {
    /**
     * Метод для получения полного имени
     * @return
     */
    //TODO Описать методы интерфейса персоны
    String getFullName();

    /**
     * Сеттер счетов
     * @param personAccounts
     */
    void setAccounts(List<Account> personAccounts);
}
