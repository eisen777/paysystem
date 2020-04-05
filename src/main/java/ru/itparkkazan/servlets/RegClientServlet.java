package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.ClientCredential;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.utils.ServletUtil;
import ru.itparkkazan.utils.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Сервлет для страницы регистрации
 */
@Slf4j
@WebServlet(name = "regClient", urlPatterns = "/regClient")
public class RegClientServlet extends HttpServlet {

    /**
     * Метод обработки POST-запроса
     * @param httpServletRequest запрос
     * @param httpServletResponse ответ
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, String> clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);
        //TODO Add validation
        Client client = new Client(
                clientCredentials.get(ClientCredential.LOGIN.getClientCredential()),
                clientCredentials.get(ClientCredential.PSSWD.getClientCredential()),
                clientCredentials.get(ClientCredential.FIRST_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SECOND_NAME.getClientCredential()),
                clientCredentials.get(ClientCredential.SURNAME.getClientCredential()));
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        ServletUtil.redirectInsideServlet(httpServletRequest, httpServletResponse, Page.SUCCESS_REG_PAGE.getPage());
    }
}
