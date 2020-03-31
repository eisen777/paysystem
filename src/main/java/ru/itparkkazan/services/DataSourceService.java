package ru.itparkkazan.services;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.exceptions.DataSourceServiceException;
import ru.itparkkazan.exceptions.PropertyReaderException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class DataSourceService {

    private static final String DRIVER_NAME_PROPERTY_NAME = "driver_name";
    private static final String URL_PROPERTY_NAME = "url";
    private static final String USER_PROPERTY_NAME = "user";
    private static final String PSSWD_PROPERTY_NAME = "password";

    private Properties properties;
    private Connection connection;

    /**
     * Конструктор по-умолчанию
     */
    public DataSourceService() {
        try {
            properties = ReadPropertiesService.readDataSourceProperty();
        } catch (PropertyReaderException e) {
            log.error("Ошибка при получении данных для подключения к БД", e);
        }
    }

    /**
     * Метод получения подключения к БД
     * @return подключение к БД
     */
    private Connection getConnection() throws DataSourceServiceException {
        String driverName = properties.getProperty(DRIVER_NAME_PROPERTY_NAME);
        String url = properties.getProperty(URL_PROPERTY_NAME);
        String user = properties.getProperty(USER_PROPERTY_NAME);
        String password = properties.getProperty(PSSWD_PROPERTY_NAME);
        try {
            Class.forName(driverName);
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            String errorMessage = String.join(" ", "Ошибка при попытке получить подключение к БД", url);
            log.error(errorMessage, e);
            throw new DataSourceServiceException(errorMessage);
        }
    }

    public PreparedStatement getPreparedStatement(String query) throws DataSourceServiceException {
        try {
            connection = getConnection();
            if (connection != null) {
                return connection.prepareStatement(query);
            } else {
                String errorMessage = String.join(" ", "Не удалось получить подключение при создании " +
                        "подготовленного выражения для запроса", query);
                log.error(errorMessage);
                throw new DataSourceServiceException(errorMessage);
            }
        } catch (SQLException e) {
            String errorMessage = String.join(" ", "Ошибка при попытке получить подготовленного " +
                    "выражения для запроса в БД", query);
            log.error(errorMessage, e);
            throw new DataSourceServiceException(errorMessage);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Error while trying to close jdbc connection");
            }
        }
    }
}
