<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="margins">
<h1>Users list : </h1>

_________________________________________
<c:forEach var="u" items="${userList}">
    <div class="advert">
        <p <c:if test="${u.isAdmin}">style="color: red"</c:if>>Name : ${u.username} </p> |
        <a href="<%=request.getContextPath()%>/admin/removeuser?id=${u.id}">Remove</a>
        <c:if test="${u.isAdmin}">
            <a href="<%=request.getContextPath()%>/admin/setadmin?id=${u.id}&isAdmin=false">Demote Admin</a>
        </c:if>
        <c:if test="${not u.isAdmin}">
            <a href="<%=request.getContextPath()%>/admin/setadmin?id=${u.id}&isAdmin=true">Promote Admin</a>
        </c:if>
        <br>
        _________________________________________
    </div>
</c:forEach>
<div>
<%@ include file="../include/javascript.jsp" %>
</body>
</html>
