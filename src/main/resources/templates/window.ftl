<html>
<head>
    <title>Login</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="container">
    <h1><span style="color: #FF0066">&bull;</span>Документы<span style="color: #FF0066">&bull;</span></h1>
    <div class="underline">
    </div>
    <center>

        <form action="/window/arrival" method="post" >
            <input type="submit" value="Поступление"  style="text-align: center; margin-top: 1%; padding: 30px 55px;" id="form_button"   />
        </form>
        <form action="/window/sale" method="post">
            <input type="submit" value="Продажа" style="text-align: center; margin: -4%; padding: 30px 73px;"  id="form_button1"  />
        </form>
        <form action="/window/moving" method="post">
            <input type="submit" value="Перемещение"  id="form_button2" style="padding: 30px 55px;"  />
        </form>

        <form action="/logout" method="post">
            <input type="submit" value="Выход"  id="form_button3" style="padding: 30px 55px;"  />
        </form>
    </center>
</div>


</body>
</html>
