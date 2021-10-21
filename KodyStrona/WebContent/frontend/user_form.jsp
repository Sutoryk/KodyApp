<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: arexo
  Date: 23.09.2021
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Title</title>
</head>
<body>
<div align="center">
<h1> Zarejestruj się</h1>
</div>
<jsp:directive.include file="header.jsp"/>

<div align="center">

    <form action="create_user" method="post" onsubmit="return validateFormInput()">
        <table>
    <tr>
        <td align="right">Email:</td>
       <td align="left"><input type="text" id="email" name= "email" size="20"/></td>
    </tr>
            <tr>
        <td align="right">Passsword</td>
        <td align="left"> <input type="password" id="password" name = "password" size="20"/></td>
                </tr>

            <tr>
                <td align="center">
                    <input type="submit" value="Save">
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Cancel">
                </td>

            </tr>
</table>
    </form>
</div>




</div>

<footer>
    <jsp:directive.include file ="footer.jsp"/>

</footer>
</body>
<script type="text/javascript">
    function validateFormInput(){
        var fieldEmail = document.getElementById("email");
        var fieldPassowrd = document.getElementById("password");

        if(fieldEmail.value.length==0){
            alert("Email is required!");
            fieldEmail.focus();
            return false;

        }
        if(fieldPassowrd.value.length==0){
            alert("Password is required");
            fieldEmail.focus();
            return false;

        }
        return true;


    }
</script>
</html>
