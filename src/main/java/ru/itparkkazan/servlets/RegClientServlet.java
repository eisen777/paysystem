package ru.itparkkazan.servlets;

import lombok.extern.slf4j.Slf4j;
import ru.itparkkazan.beans.Client;
import ru.itparkkazan.dao.ClientDAO;
import ru.itparkkazan.enums.Page;
import ru.itparkkazan.sessions.SessionUtil;
import ru.itparkkazan.utils.ClientCredentialsInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Slf4j
@WebServlet(name = "regClient", urlPatterns = "/regClient")
public class RegClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        Map<String, String> clientCredentials = SessionUtil.readClientCredentials(httpServletRequest);
        //TODO Add validation
        Client client = new Client(
                clientCredentials.get(ClientCredentialsInfo.LOGIN),
                clientCredentials.get(ClientCredentialsInfo.PSSWD),
                clientCredentials.get(ClientCredentialsInfo.FIRST_NAME),
                clientCredentials.get(ClientCredentialsInfo.SECOND_NAME),
                clientCredentials.get(ClientCredentialsInfo.SURNAME));
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
        HttpSession httpSession = httpServletRequest.getSession();
        SessionUtil.fillSession(httpSession, client);
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Page.SUCCESS_REG_PAGE.getPage());
    }
}
