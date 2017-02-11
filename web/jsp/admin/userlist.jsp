<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Users list : </h1>


    <c:forEach var="u" items="${userList}">
    <div class="advertIndex">
        <div class="advertName" <c:if test="${u.isAdmin}">style="color: red"</c:if>>${u.username} </div>
        <a href="<%=request.getContextPath()%>/admin/removeuser?id=${u.id}" class="button_style2">Remove</a> |

        <c:if test="${u.isAdmin}">
            <a href="<%=request.getContextPath()%>/admin/setadmin?id=${u.id}&isAdmin=false" class="button_style2">Demote Admin</a>
        </c:if>
        <c:if test="${not u.isAdmin}">
            <a href="<%=request.getContextPath()%>/admin/setadmin?id=${u.id}&isAdmin=true" class="button_style2">Promote Admin</a>
        </c:if>
        <br>
    </div>
    </c:forEach>
    <div>
        <%@ include file="../include/javascript.jsp" %>
</body>
</html>
