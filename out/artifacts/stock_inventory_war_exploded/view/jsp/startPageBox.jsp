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
    <title>Calculator</title>
    <link href="${pageContext.request.contextPath}/view/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container" style=" border: solid 3px ${cookie.color.value}" >
    <h1><span style="color: ${cookie.color.value} ">&bull;</span> Square of Box <span style="color: ${cookie.color.value}">&bull;</span></h1>
    <div class="underline" style="border-bottom: solid 2px ${cookie.color.value}"></div>

<form method="post" action="/square">

    <label for="side1"></label>
        <input class="input-field" placeholder="First Side" type="text" style="text-align: center; border-bottom: solid 2px ${cookie.color.value}" id="side1" name="side1">
    <label for="side2">
        <input class="input-field" placeholder="Second Side" type="text" style="text-align: center; border-bottom: solid 2px ${cookie.color.value}" id="side2" name="side2" >
    </label>
    <center>
    <input type="submit" value="Calculate" id="form_button" style="border: solid 2px ${cookie.color.value}">
    </center>

</form>



    <form method="post" action="/square">
        <label for="colors">
            <select name="colors" id="colors" style="border-bottom: solid 2px ${cookie.color.value}">
                <option value="black">Черный</option>
                <option value="white">Белый</option>
                <option value="#FF0066">Оригинал</option>
            </select>
        </label>
        <center>
            <input type="submit" value="Change" id="form_button1" style="border: solid 2px ${cookie.color.value}">
        </center>
    </form>

</div>
</body>
</html>
