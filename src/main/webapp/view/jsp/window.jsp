<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 2020-02-07
  Time: 17:27
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
    <h1><span style="color: #FF0066">&bull;</span>Документы<span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>
<%--        Тестирование --%>
        <form action="${pageContext.request.contextPath}/window/" method="post" enctype="multipart/form-data">
            <input type="file" value="Поступление" name="fileName1" style="text-align: center; margin-top: 1%; padding: 30px 55px;" id="form_button"  multiple="multiple" />
            <input type="submit" value="Продажа" style="text-align: center; margin: -4%; padding: 30px 73px;" />
        </form>
        <form action="" method="post">
            <input type="submit" value="Продажа" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button1"  multiple="multiple"/>
        </form>
        <form action="" method="post">
            <input type="submit" value="Перемещение"  id="form_button2" style="padding: 30px 55px;"  multiple="multiple"/>
        </form>
    </center>
</div>


</body>
</html>

