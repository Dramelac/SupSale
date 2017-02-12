<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <img src="<c:url value="/img/logo.png" />" class="logo"/>
            <h5>Log in</h5>
        </div>
        <div class="col-md-offset-1 col-md-8">
            <c:if test="${failed}">
                <div class="alert alert-danger">
                    <strong>Failed!</strong> Your details are incorrect. Please try again.
                </div>
            </c:if>
            <form action="login" method="POST" class="login">
                <label>
                    Username :
                    <input type="text" name="username">
                </label><br/>
                <label>
                    Password :
                    <input type="password" name="password">
                </label><br/>
                <input type="submit" value="Log in" class="button">
            </form>
        </div>
    </div>
</div>
<%@ include file="include/javascript.jsp" %>
</body>
</html>
