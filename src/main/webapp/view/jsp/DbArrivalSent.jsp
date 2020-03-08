<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 2020-03-07
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.moysklad.model.ArrivalOrSaleOfProduct" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DataBase</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="container">
    <br>
    <center>
        <table style="border-spacing: 20px;">
            <tr>
                <th style="color: white; text-align: center">Номер ID</th>
                <th style="color: white; text-align: center">Номер Склада ID</th>
                <th style="color: white; text-align: center" >Список Товаров ID</th>
            </tr>
            <c:forEach items="${sentArrivalProduct}" var="product">
                <tr>
                    <td style="color: white; text-align: center" >${product.numberId}</td>
                    <td style="color: white; text-align: center">${product.warehouseId}</td>
                    <td style="color: white; text-align: center">${product.listOfProductId}</td>
                </tr>
            </c:forEach>
        </table>

        <center>


            <form action="${pageContext.request.contextPath}/window/arrival/view_all_documents" method="post">
                    <label for="numberId"></label>
                    <input type="text" placeholder="Номер ID" style="text-align: center" name="numberId" id="numberId" required>
                    <label for="warehouseId"></label>
                    <input type="text" placeholder="Склад ID" style="text-align: center" name="warehouseId" id="warehouseId" required>
                    <label for="listOfProduct"></label>
                    <input type="text" placeholder="Список Товаров ID" style="text-align: center" name="listOfProduct" id="listOfProduct" required>
                    <input type="submit" value="Редактировать" style="text-align: center; margin-top: 5%; padding: 30px 73px;"  id="form_button" />
            </form>
            <form action="${pageContext.request.contextPath}/window/arrival/send" method="post">
                <input type="submit" value="Отправить в Базу Данных" style="text-align: center; margin: -10%; padding: 30px 32px;"  id="form_button1"  />
            </form>
            <form action="${pageContext.request.contextPath}/window/arrival" method="post">
                <input type="submit" value="Назад" style="text-align: center; margin: -10%; padding: 30px 112px;"  id="form_button2"  />
            </form>

        </center>
    </center>
</div>
</body>
</html>