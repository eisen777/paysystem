package ru.itparkkazan.dao;

import ru.itparkkazan.beans.Client;
import ru.itparkkazan.exceptions.UnregistredClientException;

public interface DAO<T> {
    void insert(T t);

    Client getClient(String lgn, String psswd) throws UnregistredClientException;

}
