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
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<form action="register" method="POST">
    <label>
        First name :
        <input type="text" name="firstname">
    </label>
    <br>
    <label>
        Last name :
        <input type="text" name="lastname">
    </label>
    <br>
    <label>
        E-mail :
        <input type="text" name="email">
    </label>
    <br>
    <label>
        Address :
        <input type="text" name="address">
    </label>
    <br>
    <label>
        Phone number :
        <input type="text" name="phonenumber">
    </label>
    <br>
    <label>
        Username :
        <input type="text" name="username">
    </label>
    <br>
    <label>
        Password :
        <input type="password" name="password">
    </label>
    <br>
    <input type="submit" value="Register">

</form>
<%@ include file="include/javascript.jsp" %>
</body>
</html>