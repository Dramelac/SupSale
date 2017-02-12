<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <img src="<c:url value="/img/logo.png" />" class="logo"/>
            <h5>Enter your informations to register</h5>
        </div>
        <div class="col-md-offset-1 col-md-8">
            <c:if test="${failed}">
                <div class="alert alert-danger">
                    <strong>Failed!</strong> ${message}
                </div>
            </c:if>
            <form action="register" method="POST" class="login">
                <label class="labels_register">
                    First name

                </label>
                <br>
                <input type="text" name="firstname" class="inputs_register" value="${firstname}">
                <br>
                <label class="labels_register">
                    Last name
                </label>
                <br>
                <input type="text" name="lastname" class="inputs_register" value="${lastname}">

                <br>
                <label class="labels_register">
                    E-mail <span class="mandatory">*</span>

                </label> <br><input type="text" name="email" class="inputs_register" value="${email}"">
                <br>
                <label class="labels_register">
                    Address

                </label> <br><input type="text" name="address" class="inputs_register" value="${address}">
                <br>
                <label class="labels_register">
                    Phone number

                </label> <br><input type="text" name="phonenumber" class="inputs_register" value="${phonenumber}">
                <br>
                <label class="labels_register">
                    Username <span class="mandatory">*</span>

                </label> <br><input type="text" name="username" class="inputs_register" value="${username}">
                <br>
                <label class="labels_register">
                    Password <span class="mandatory">*</span>

                </label> <br><input type="password" name="password" class="inputs_register">
                <br>
                <label class="labels_register">
                    Password verification <span class="mandatory">*</span>

                </label> <br> <input type="password" name="passwordverif" class="inputs_register">
                <br>
                <input type="submit" value="Register" class="button">

            </form>
        </div>
    </div>
</div>
<%@ include file="include/javascript.jsp" %>
</body>
</html>




