package ru.itparkkazan.dao;

/**
 * Обобщенный интерфейс для получения объекта из БД
 *
 * @param <T> обобщенный тип
 */
public interface DAO<T> {
    /**
     * Метод вставки информации в БД
     *
     * @param t обобщенный тип
     */
    void insert(T t);

    /**
     * Метод получения информации из БД по 2 параметрам
     *
     * @param firstParam  первый параметр
     * @param secondParam второй параметр
     * @return обобщенный тип объекта
     * @throws Exception ошибка при получении объекта из БД
     */
    T get(String firstParam, String secondParam) throws Exception;

}
