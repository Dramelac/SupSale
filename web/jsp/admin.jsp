<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale- Profile</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<h1>Hello admin ${username}</h1>

<p><a href="<%=request.getContextPath()%>/admin/users">Manage users</a></p>
<p><a href="<%=request.getContextPath()%>/admin/ads">Manage ads</a></p>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
