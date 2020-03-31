<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница аутентификации</title>
</head>
<body>
<h1 align="center">Платежная система 1.0</h1>
<div style="width: 100%; height: 800px; vertical-align: bottom; background-color: brown">
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
</div>
</body>
</html>