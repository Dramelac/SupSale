<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<h1>Users list : </h1>

=========================================
<c:forEach var="u" items="${userList}">
    <div class="advert">
        <p <c:if test="${u.isAdmin}">style="color: red"</c:if>>Name : ${u.username} </p>
        <a href="<%=request.getContextPath()%>/admin/removeuser?id=${u.id}">Remove</a><br>
        =========================================
    </div>
</c:forEach>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>
