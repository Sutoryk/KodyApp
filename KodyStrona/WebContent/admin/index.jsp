<%--
  Created by IntelliJ IDEA.
  User: arexo
  Date: 17.09.2021
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Kody Administration</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>
    <div align="center"><
    <h1> Administartive Dashboard </h1>
    </div>
    <div align="center">
    <div>
        &nbsp;
        <a href="list_users">Users</a>
        <a href="customers">Customers</a>
        <a href="orders">Orders</a>
        <a href="reviews">Reviews</a>
        <a href="generatedcodes">Made Codes</a>
    </div>
        <hr/>
    <h2>Narzędzia</h2>
    <b>
        <a href="create_code">New Code</a>
        <a href="create_user">New User</a>
    </b>
    <hr/>
    <div>
        <h2>Recent transactions:</h2>

    </div>
        <div>
            <h2>Recent reviews:</h2>

        </div>
        <div>
            <h2>Statistics:</h2>

        </div>
    </div>


    <jsp:directive.include file="footer.jsp"/>
</body>
</html>
