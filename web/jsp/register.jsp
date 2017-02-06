<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<c:if test="${failed}">
    <div class="alert alert-danger">
        <strong>Failed!</strong> This account or email already exist.
    </div>
</c:if>
<c:if test="${wrongpassword}">
    <div class="alert alert-danger">
        <strong>Failed!</strong> ${message2}
    </div>
</c:if>
<img src="<c:url value="/img/logo.png" />"class="logo"/>
<form action="register" method="POST" class="login">
    <label class="labels_register">
        First name

    </label>
    <br>
    <input type="text" name="firstname" class="inputs_register">
    <br>
    <label class="labels_register">
        Last name
    </label>
    <br>
        <input type="text" name="lastname" class="inputs_register">

    <br>
    <label class="labels_register">
        E-mail

    </label> <br><input type="text" name="email" class="inputs_register">
    <br>
    <label class="labels_register">
        Address

    </label> <br><input type="text" name="address" class="inputs_register">
    <br>
    <label class="labels_register">
        Phone number

    </label> <br><input type="text" name="phonenumber" class="inputs_register">
    <br>
    <label class="labels_register">
        Username

    </label>  <br><input type="text" name="username" class="inputs_register">
    <br>
    <label class="labels_register">
        Password

    </label> <br><input type="password" name="password" class="inputs_register">
    <br>
    <label class="labels_register">
        Password verification

    </label> <br> <input type="password" name="passwordverif" class="inputs_register">
    <br>
    <input type="submit" value="Register" class="button">

</form>
<%@ include file="include/javascript.jsp" %>
</body>
</html>




