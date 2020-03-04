<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 02.03.2020
  Time: 2:56
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <h1><span style="color: #FF0066">&bull;</span> Авторизация <span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>
        <form action="" method="post">
            <div class="Login">
                <label for="Login"></label>
                <input type="text" placeholder="Логин" style="text-align: center" name="Login" id="Login" required>
            </div>
            <div class="password">
                <label for="password"></label>
                <input type="password" placeholder="Пароль" style="text-align: center" name="password" id="password" required>
            </div>
            <input type="submit" value="Авторизоваться" style="text-align: center; margin-top: 5%" id="form_button" />
        </form><!-- // End form -->
    </center>
</div><!-- // End #container -->


</body>
</html>