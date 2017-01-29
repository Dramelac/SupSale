<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<form action="login" method="POST">
    <label>
        Username :
        <input type="text" name="username">
    </label><br/>
    <label>
        Password :
        <input type="password" name="password">
    </label><br/>
    <input type="submit" value="Log in">
</form>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
