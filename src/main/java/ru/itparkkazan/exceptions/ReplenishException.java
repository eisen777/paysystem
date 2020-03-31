package ru.itparkkazan.exceptions;

/**
 * Исключение связанный с некорректной суммой пополнения счета
 */
public class ReplenishException extends Exception {

    /**
     * Конструктор с сообщением детали Exc
     * @param message
     */
    public ReplenishException(String message) {
        super(message);
    }
}
