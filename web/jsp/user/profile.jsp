<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale- Profile</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Hello ${username}</h1>

    <c:if test="${user.isAdmin}">
        <div class="alert alert-info">
            <a href="<%=request.getContextPath()%>/admin/">You are admin ! You can access to the admin pannel here</a>
        </div>
    </c:if>

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
        <label class="ajust_labels">
            First name :

        </label> <input type="text" name="firstname" value="${user.firstname}">
        <br> <br>
        <label class="ajust_labels">
            Last name :

        </label><input type="text" name="lastname" value="${user.lastname}">
        <br> <br>
        <label class="ajust_labels">
            E-mail <span class="mandatory">*</span>:

        </label><input type="text" name="email" value="${user.email}">
        <br> <br>
        <label class="ajust_labels">
            Address :

        </label><input type="text" name="address" value="${user.address}">
        <br> <br>
        <label class="ajust_labels">
            Phone number :

        </label> <input type="text" name="phonenumber" value="${user.phonenumber}">
        <br> <br>
        <br>
        <h2>Change password :</h2>
        <label class="ajust_labels">
            New password :

        </label><input type="password" name="password">
        <br> <br>
        <label class="ajust_labels">
            Verify new password :

        </label><input type="password" name="check_password">
        <br> <br>
        <label class="ajust_labels">
            Current password :

        </label><input type="password" name="old_password">
        <br> <br>
        <input type="submit" value="Update" class="button">

    </form>
</div>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>
