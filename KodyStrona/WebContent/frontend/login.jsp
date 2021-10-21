
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<form action="login_user" method="post" onsubmit="return validateFormInput()">
    <div align="center" >
        <h2>Please login:</h2>
    <form>
        Email: <input id="email" name = "email"type="text" size="10"><br/>
        Password: <input id = "password" name = "password" type="text" size="10"/>
        <input type="submit" value="login">

    </form>
    </div>

    <jsp:directive.include file="footer.jsp"/>


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
