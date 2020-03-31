package ru.itparkkazan.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

    // TODO переписать класс с учетом использования lombok в классе Client

    private static final String LOGIN = "Ivan";
    private static final String PASSWD = "Ivan";
    private static final String FIRSTNAME = "Иван";
    private static final String SECONDNAME = "Иванович";
    private static final String SURNAME = "Иванов";

    private Client client;

    /**
     * Инициализация клиента
     * @return клиента с заполенными полями фамилия, имя, отчество
     */
    @Before
    public void initClient() {
        client = new Client(LOGIN, PASSWD, FIRSTNAME, SECONDNAME, SURNAME);
    }

    /**
     * Базовый тест для объекта клиента
     */
    @Test
    public void basicClientTest() {
        Assert.assertNotNull(client);
        System.out.println("Client's link from basic test " + client);
        Assert.assertEquals(client.toString(), String.valueOf(client));
    }

    /**
     * Метод тестирования полного имени клиента
     */
    @Test
    public void getFullNameTest() {
        String fullname = SURNAME + " " + FIRSTNAME + " " + SECONDNAME;
        Assert.assertEquals(fullname, client.getFullName());
        System.out.println("Client's link from getFullName test" + client);
    }
}