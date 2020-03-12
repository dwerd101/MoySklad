
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.03.2020
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.moysklad.model.ArrivalOfProduct" %>
<%@ page import="com.moysklad.view.ArrivalProductViewImpl" %>
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
        <th style="color: white; text-align: center" >Продукт ID</th>
        <th style="color: white; text-align: center" >Имя продукта</th>
        <th style="color: white; text-align: center" >Кол-во</th>
        <th style="color: white; text-align: center" >Цена</th>
    </tr>
    <c:forEach items="${arrivalProduct}" var="product">
        <tr>
            <td style="color: white; text-align: center" >${product.numberId}</td>
            <td style="color: white; text-align: center">${product.warehouseId}</td>
            <td style="color: white; text-align: center">${product.listOfProductId}</td>
            <td style="color: white; text-align: center">${product.productId}</td>
            <td style="color: white; text-align: center">${product.productName}</td>
            <td style="color: white; text-align: center">${product.quantity}</td>
            <td style="color: white; text-align: center">${product.price}</td>
        </tr>
    </c:forEach>
</table>

    <center>
        <form action="${pageContext.request.contextPath}/window/arrival" method="post">
            <input type="submit" value="Назад" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button2"  />
        </form>
    </center>
    </center>
</div>
</body>
</html>
