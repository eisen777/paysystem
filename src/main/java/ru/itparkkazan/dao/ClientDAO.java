package ru.itparkkazan.dao;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.exceptions.DataSourceServiceException;
import ru.itparkkazan.exceptions.UnregistredClientException;
import ru.itparkkazan.services.DataSourceService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс доступа к данным БД для клиента
 */
@Slf4j
public class ClientDAO implements DAO<Client> {

    /**
     * SQL-запрос для вставки в БД информации о клиенте
     */
    private static final String INSERT_INTO_CLIENT_LOGIN_PSWD_VALUES = "INSERT INTO PAYSYSTEM.PAYSYSTEM.CLIENT (LOGIN, PSWD, FIRSTNAME, SECONDNAME, SURNAME) VALUES (?,?,?,?,?)";
    /**
     * SQL-запрос для получения из БД информации о клиенте по логину и паролю
     */
    private static final String SELECT_CLIENT_BY_LGN_AND_PSSWD = "SELECT * FROM PAYSYSTEM.PAYSYSTEM.CLIENT WHERE LOGIN = ? AND PSWD = ?";

    /**
     * Поле класса для работы с БД
     */
    private DataSourceService dataSourceService = new DataSourceService();

    /**
     * Метод для вставки в БД информации о клиенте
     * @param client объект клиент
     */
    @Override
    public void insert(Client client) {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(INSERT_INTO_CLIENT_LOGIN_PSWD_VALUES)){
            preparedStatement.setString(1, client.getLogin());
            preparedStatement.setString(2, client.getPsswd());
            preparedStatement.setString(3, client.getFirstname());
            preparedStatement.setString(4, client.getSecondname());
            preparedStatement.setString(5, client.getSurname());
            preparedStatement.executeUpdate();
        } catch (DataSourceServiceException e) {
            log.error("Ошибка подключения к БД при попытке вставки записи с данными клиента", e);
        } catch (SQLException e) {
            log.error("Ошибка запроса при попытке вставки записи с данными клиента " + INSERT_INTO_CLIENT_LOGIN_PSWD_VALUES, e);
        } finally {
            dataSourceService.closeConnection();
        }
    }

    /**
     * Метод получения объекта клиента из БД по логину и паролю
     * @param lgn логин
     * @param psswd пароль
     * @return объект клиента
     * @throws UnregistredClientException исключение "Незарегистрированный клиент"
     */
    @Override
    public Client get(String lgn, String psswd) throws UnregistredClientException {
        try (PreparedStatement preparedStatement = dataSourceService.getPreparedStatement(SELECT_CLIENT_BY_LGN_AND_PSSWD)) {
            preparedStatement.setString(1, lgn);
            preparedStatement.setString(2, psswd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //TODO Добавить инициализацию с id
//                int id = resultSet.getInt(ID);
                String firstName = resultSet.getString(ClientCredential.FIRST_NAME.getClientCredential());
                String secondName = resultSet.getString(ClientCredential.SECOND_NAME.getClientCredential());
                String surname = resultSet.getString(ClientCredential.SURNAME.getClientCredential());
                return new Client(lgn, psswd, firstName, secondName, surname);
            } else {
                throw new UnregistredClientException("Клиент с логином " + lgn + " отсутсвует.");
            }
        } catch (DataSourceServiceException e) {
            log.error("Ошибка при получении данных о клиенте с логином " + lgn, e);
            return null;
        } catch (SQLException e) {
            log.error("Ошибка при выполнении запроса " + SELECT_CLIENT_BY_LGN_AND_PSSWD, e);
            return null;
        } finally {
            dataSourceService.closeConnection();
        }
    }
}
