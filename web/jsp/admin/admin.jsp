<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale- Profile</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Hello admin ${username}</h1>


    <p><a href="<%=request.getContextPath()%>/admin/users" class="button_style2">Manage users</a></p>
    <p><a href="<%=request.getContextPath()%>/admin/advert" class="button_style2">Manage ads</a></p>
</div>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>
