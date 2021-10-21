
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/menu.css"%></style>
<html>
<head>
    <title>Title</title>

</head>
<jsp:directive.include file="header.jsp"/>
<body>
<p>Balance ${balance}</p>
<div align="center">
    <h1></h1>

</div>

<div align="center">
    <form action="BuyServlet" method ="post">
        <table>
            <tr>
            <td align="center">
                <img src = "../images/10pln.png"/>
            </td>
            </tr>
            <tr>
                <td align="right">Wartosc kodu:</td>
                <td align="left"><input type="number" id="value" name= "value" size="20"/></td>
            </tr>

            <td><input type="submit" value="Buy 10" id="10"></td>

            </tr>
        </table>
    </form>
</div>

</body>
<style>
    input[type="submit"]{
        box-shadow: 0px 1px 0px 0px #fff6af;
        background:linear-gradient(to bottom, #ffec64 5%, #ffab23 100%);
        background-color:#ffec64;
        border-radius:6px;
        border:1px solid #ffaa22;
        display:inline-block;
        cursor:pointer;
        color:#333333;
        font-family:Arial;
        font-size:15px;
        font-weight:bold;
        padding:6px 24px;
        text-decoration:none;
        text-shadow:0px 1px 0px #ffee66;
        background:linear-gradient(to bottom, #ffab23 5%, #ffec64 100%);
        background-color:#ffab23;
        position:relative;
        top:1px;
        vertical-align: middle;
    }
</style>

</html>
