
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kody - Kup swoj giftcard </title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<a href="viewservlet">view bought code</a>
<a href="ViewMyBalanceservlet">view balance</a>
<div align="center">
    <h1>You have succesfully logged in  !</h1>

    <p>Welcome ${username}</p>
    <p>Dodamy kod ${value}</p>


</div>


<div align ="center">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="view_cart"> Cart </a> |
    <a href="kup_kod"> Kup Kod </a> |

    <form action="RedeemServlet" method ="post">
    <table>
        <tr><br>
            <td><br></td>
            <td><input type="submit" value="Redeem Code" id="Redeem"></td>
        </tr>
        </table>
    </form>
</div>

<footer>
    <jsp:directive.include file ="footer.jsp"/>

</footer>
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
        font-size:30px;
        font-weight:bold;
        padding:20px 35px;
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
