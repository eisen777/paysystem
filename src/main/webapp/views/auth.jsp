<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница аутентификации</title>
</head>
<body>
<h1 align="center">Платежная система 1.0</h1>
<div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 20%; background-color: #5a5a5a">
        <form style="width: 100%; height: 100%" id="clientAuthForm" action="../auth" method="post">
            <table style="height: 100%">
                <tr>
                    <td>
                        <label>Логин</label>
                    </td>
                    <td>
                        <input type="text" name="login">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Пароль</label>
                    </td>
                    <td>
                        <input type="password" name="psswd">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input style="width: 100%" type="submit" value="Войти">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<%--<div style="width: 100%; height: 800px; vertical-align: bottom; background-color: brown">
    <div align="center" style="width: 100%; height: 20%; background-color: gray">
        <form id="clientAuthForm" action="../auth" method="post">
            <div style="float: left; width: 40%; align-self: ">
                <label>Логин</label>
            </div>
            <div>
                <input type="text" name="login"/>
            </div>
            <div style="float: left">
                <labe>Пароль</labe>
            </div>
            <div>
                <input type="password" name="psswd"/>
            </div>
            <input type="submit" value="Войти"/>
        </form>
    </div>
</div>--%>
</body>
</html>