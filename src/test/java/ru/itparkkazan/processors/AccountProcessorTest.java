package ru.itparkkazan.processors;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import ru.itparkkazan.beans.Account;
import ru.itparkkazan.exceptions.ReplenishException;

@Slf4j
public class AccountProcessorTest {

    private static final int startSum = 0;
    private static final int replenishSum = -100;

    Account account;

    /**
     * Метод инициализации тестовых данных
     */
    @Before
    public void init() {
        account = new Account();
        account.setSum(startSum);
        account.setAccountNumber(1111);
    }

    /**
     * Метод проверки пополнения счета
     */
    @Test
    public void replenishAccountTest() {
        try {
            AccountProcessor.replenishAccount(account, replenishSum);
        } catch (ReplenishException e) {
           log.error(String.join(" ", "Ошибка при тестировании метода replenishAccount"));
        }
        //Assert.assertEquals(account.getSum(), startSum + replenishSum);
    }
}