<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 2020-03-09
  Time: 01:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="container">
    <h1><span style="color: #FF0066">&bull;</span>Документы<span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>
        <h1><span style="color: #FF0066">&bull;</span> Успешно <span style="color: #FF0066">&bull;</span></h1>
        <div class="underline">
        </div>
        <form action="${pageContext.request.contextPath}/window/" method="post">
            <input type="submit" value="Назад" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button1"  />
        </form>
    </center>
</div>
</body>
</html>
