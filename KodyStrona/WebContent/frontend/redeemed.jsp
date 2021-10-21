<%--
  Created by IntelliJ IDEA.
  User: arexo
  Date: 17.10.2021
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:directive.include file="header.jsp"/>
    <title>Title</title>
</head>
<body>
<a href="viewservlet">view bought code</a>
<form action="Redeem2Servlet" method ="post">
        <div align="center" >
            <img src = "../images/10pln.png"/>
        </div>
        <div align="center">
            <form>
                Wpisz swój kod: <input id="value" name = "value"type="value" size="10"><br/>
                &nbsp;Podaj email <input id = "email" name = "email" type="text" size="10"/>
                &nbsp;Podaj wartosc swojego kodu <input id = "wartosc" name = "wartosc" type="value" size="10"/>
                <br/>
                <input type="submit" value="zatwierdź">

            </form>
        </div>

</form>
<p>Welcome ${username}</p>
<jsp:directive.include file="footer.jsp"/>
</body>
</html>
