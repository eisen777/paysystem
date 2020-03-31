package ru.itparkkazan.beans;

import java.util.List;

public interface Person {
    //TODO Описать методы интерфейса персоны
    String getFullName();
    void setAccounts(List<Account> personAccounts);
}
