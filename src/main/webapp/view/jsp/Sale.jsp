<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.03.2020
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Sale</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
    <h1><span style="color: #FF0066">&bull;</span>Документы<span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>

        <form action="${pageContext.request.contextPath}/window/sale/view_all_documents" method="post" enctype="multipart/form-data">
            <input type="file" value="Добавить"  style="text-align: center; margin-top: 1%; padding: 30px 55px;" id="form_button"  multiple="multiple" />
            <input type="submit" value="Отправить" style="text-align: center; margin-top: 1%; padding: 30px 55px;" id="form_button1" />
        </form>
        <h2><span style="color: #FF0066">&bull;</span>Другие операции<span style="color: #FF0066">&bull;</span></h2>
        <form action="${pageContext.request.contextPath}/window/sale/view_all_document" method="post">
            <input type="submit" value="Посмотреть" style="text-align: center; margin: -5%; padding: 30px 73px;"  id="form_button3"/>
        </form>
        <form action="${pageContext.request.contextPath}/window/" method="post">
            <input type="submit" value="Назад" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button2"  />
        </form>
    </center>
</div>
</body>
</html>