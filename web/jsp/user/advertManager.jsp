<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
    <h1>Hello ${username}, this is your advert.</h1>


    <c:forEach var="a" items="${list}">
        <div class="advertIndex">
            <div class="advertName">${a.name}</div>
            <br>
            <p>${a.description}</p><br>
            <a href="<%=request.getContextPath()%>/view?id=${a.id}" class="button_style2">View</a> |
            <a href="<%=request.getContextPath()%>/user/updateadvert?id=${a.id}" class="button_style2">Edit</a> |
            <a href="<%=request.getContextPath()%>/user/removeadvert?id=${a.id}" class="button_style2">Remove</a><br>
        </div>
    </c:forEach>

</div>
<%@ include file="../include/javascript.jsp" %>
</body>
</html>
