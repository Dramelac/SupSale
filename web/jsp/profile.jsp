<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale- Profile</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<h1>Hello ${username}</h1>

<c:if test="${result}">
    <div class="alert alert-success">
        <strong>Success!</strong> Profile successfully updated.
    </div>
</c:if>

<form action="profile" method="POST">
    <label>
        First name :
        <input type="text" name="firstname" value="${user.firstname}">
    </label>
    <br>
    <label>
        Last name :
        <input type="text" name="lastname" value="${user.lastname}">
    </label>
    <br>
    <label>
        E-mail :
        <input type="text" name="email" value="${user.email}">
    </label>
    <br>
    <label>
        Address :
        <input type="text" name="address" value="${user.address}">
    </label>
    <br>
    <label>
        Phone number :
        <input type="text" name="phonenumber" value="${user.phonenumber}">
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
