package ru.itparkkazan.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import ru.itparkkazan.exceptions.PropertyReaderException;

import java.util.Properties;

@Slf4j
public class ReadPropertiesServiceTest {

    @Test
    public void readDataSourceProperty() {
        try {
            Properties properties = ReadPropertiesService.readDataSourceProperty();
            Assert.assertNotNull(properties);
            log.info("Считывание файла с данными о БД прошло успешно");
            if (properties.isEmpty()) {
                log.info("Файл пустой");
            } else {
                log.info(String.join(" ", "Содержимое файла", properties.toString()));
            }
            log.info(properties.toString());
        } catch (PropertyReaderException e) {
            log.error(String.join(" ",
                    "Ошибка во время выполнения теста считывания property-файла с данными"),
                    e.getMessage());
            Assert.fail();
        }
    }
}