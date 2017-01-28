<%--
  Created by IntelliJ IDEA.
  User: doria
  Date: 28/01/2017
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="register" method="POST">
    <label>
        firstname :
        <input type="text" name="firstname">
    </label>
    <br>
    <label>
        lastname :
        <input type="text" name="lastname">
    </label>
    <br>
    <label>
        email :
        <input type="text" name="email">
    </label>
    <br>
    <label>
        address :
        <input type="text" name="address">
    </label>
    <br>
    <label>
        phonenumber :
        <input type="text" name="phonenumber">
    </label>
    <br>
    <label>
        username :
        <input type="text" name="username">
    </label>
    <br>
    <label>
        password :
        <input type="password" name="password">
    </label>
    <br>
    <input type="submit" value="register">

</form>
</body>
</html>
