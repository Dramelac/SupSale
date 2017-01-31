<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale- Profile</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<h1>Hello ${username}</h1>

<c:if test="${success}">
    <div class="alert alert-success">
        <strong>Success!</strong> ${message}
    </div>
</c:if>
<c:if test="${failed}">
    <div class="alert alert-danger">
        <strong>Failed!</strong> ${message}
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
    <br>
    <h2>Change password :</h2>
    <label>
        New password :
        <input type="password" name="password">
    </label>
    <br>
    <label>
        Verify new password :
        <input type="password" name="check_password">
    </label>
    <br>
    <label>
        Current password :
        <input type="password" name="old_password">
    </label>
    <br>
    <input type="submit" value="Update">

</form>

<c:if test="${user.isAdmin}">
    <div class="alert alert-info">
        <a href="<%=request.getContextPath()%>/admin/">You are admin ! You can access to the admin pannel here</a>
    </div>
</c:if>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
