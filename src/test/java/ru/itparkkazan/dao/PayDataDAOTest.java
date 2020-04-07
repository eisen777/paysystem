package ru.itparkkazan.dao;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.beans.PayData;

import java.util.Date;

@Ignore
public class PayDataDAOTest {

    private static final Client client = new Client(16, "test", "test", "test", "test", "test");
    private static final String targetAccountTest = "1111";
    private static final int sumTest = 100;
    private static final Date dateTest = new Date();

    private PayDataDAO payDataDAO;
    private PayData payData;

    @Before
    public void prepareDoInsertTest() {
        payDataDAO = new PayDataDAO();
        payData = new PayData(client, targetAccountTest, sumTest, dateTest);
    }

    @Test
    public void doInsertTest() {
        payDataDAO.insert(payData);
    }
}