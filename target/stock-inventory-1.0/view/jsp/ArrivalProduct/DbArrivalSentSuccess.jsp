<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 2020-03-07
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DataBase</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">

</head>
<body>
<div id="container">

        <center>
            <h1><span style="color: #FF0066">&bull;</span> Успешно <span style="color: #FF0066">&bull;</span></h1>
            <div class="underline">
            </div>
            <form action="${pageContext.request.contextPath}/window/" method="post">
                <input type="submit" value="Назад" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button1"  />
            </form>
            <h2><span style="color: #FF0066">&bull;</span> Отчеты <span style="color: #FF0066">&bull;</span></h2>
            <form action="${pageContext.request.contextPath}/window/arrival/report_general_list_of_product_success" method="post">
                <input type="text" placeholder="Необязательно: Введите имя товара" style="text-align: center" name="productName" id="productName" >
                <input type="submit" value="Общий список товаров" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button2"  />
            </form>
            <form action="${pageContext.request.contextPath}/window/arrival/report_stock_balances_success" method="post">
                <input type="text" placeholder="Необязательно: Введите имя склада" style="text-align: center" name="" id="warehouseName" >
                <input type="submit" value="Остатки товаров на складах" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button3"  />
            </form>
        </center>
</div>
</body>
</html>