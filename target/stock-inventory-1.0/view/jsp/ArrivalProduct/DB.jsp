<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 2020-03-11
  Time: 03:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.moysklad.model.interfaceModel.Model" %>
<%@ page import="java.util.List" %>
<%@ page import="com.moysklad.model.interfaceModel.Model" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>DataBase</title>
    <link href="/view/css/styles.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="container">

    <center>
        <h1><span style="color: #FF0066">&bull;</span> Успешно <span style="color: #FF0066">&bull;</span></h1>
        <div class="underline">
        </div>
        <form action="/window/" method="post">
            <input type="submit" value="Назад" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button1"  />
        </form>
        <h2><span style="color: #FF0066">&bull;</span> Отчеты <span style="color: #FF0066">&bull;</span></h2>
        <form action="${pageContext.request.contextPath}/window/arrival/send/report_general_list_of_product/error" method="post">
            <input type="text" placeholder="Необязательно: Введите имя товара" style="text-align: center" name="productName" id="productName" >
             <%List<Model> reports = (List<Model>) request.getAttribute("reports");%>
            <% try { %>
            <% if(reports.size()==0) { %>
            <p>Ошибка</p>
            <% } else  {} %>
            <% }catch (NullPointerException e) {} %>
            <input type="submit" value="Общий список товаров" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button2"  />
        </form>
        <form action="/window/arrival/report_stock_balances_success" method="post">
            <input type="text" placeholder="Необязательно: Введите имя склада" style="text-align: center" name="" id="warehouseName" >
            <input type="submit" value="Остатки товаров на складах" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button3"  />
        </form>
    </center>
</div>
</body>
</html>