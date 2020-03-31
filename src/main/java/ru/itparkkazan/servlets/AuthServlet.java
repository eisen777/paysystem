package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.exceptions.UnregistredClientException;
import ru.itparkkazan.sessions.SessionUtil;
import ru.itparkkazan.utils.ClientCredentialsInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet(name="auth", urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {

    private String clientLogin;
    private String clientPsswd;

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        readAuthCredentials(httpServletRequest);
        ClientDAO clientDAO = new ClientDAO();
        Client client = null;
        try {
            client = clientDAO.getClient(clientLogin, clientPsswd);
            if (client == null) {
                //TODO Вывести на GUI предупреждение "Проблемы с БД, обратитесь к администратору"
            }
        } catch (UnregistredClientException e) {
            //TODO Вывести на GUI предупреждение с незарегистрирвоным клиентом
            log.error(e.getMessage());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Page.SUCCESS_AUTH_PAGE.getPage());
    }

    private void readAuthCredentials(HttpServletRequest httpServletRequest) {
        clientLogin = httpServletRequest.getParameter(ClientCredentialsInfo.LOGIN);
        clientPsswd = httpServletRequest.getParameter(ClientCredentialsInfo.PSSWD);
    }
}
