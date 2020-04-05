package ru.itparkkazan.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для описания объекта "Счет"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    /**
     * Номер счета
     */
    private int accountNumber;
    /**
     * Сумма счета
     */
    private int sum;
    /**
     * Клиент-владелец счета
     */
    private Person client;
    /**
     * Флаг блокировки счета
     */
    Boolean isBlocked;

    /**
     * Переопределенный метод вывода класса счета в строку
     *
     * @return номер счета и сумму на нём через разделитель
     */
    @Override
    public String toString() {
        return String.join(" | ", String.valueOf(accountNumber), String.valueOf(sum));
    }
}
