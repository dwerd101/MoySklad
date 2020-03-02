<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 02.03.2020
  Time: 2:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <h1><span style="color: #FF0066">&bull;</span> Login <span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>
        <form action="/login" method="post">
            <div class="login">
                <label for="login"></label>
                <input type="text" placeholder="login" style="text-align: center" name="login" id="login" required>
            </div>
            <div class="password">
                <label for="password"></label>
                <input type="password" placeholder="password" style="text-align: center" name="password" id="password" required>
            </div>
            <input type="submit" value="Login" style="text-align: center; margin-top: 5%" id="form_button" />
        </form>
    </center>
</div>
<form>
    <center>
        <input type="button" value="SignUp" onClick='location.href="/signUp"' id="buttonLeft"/>
    </center>
</form>

</body>
</html>
