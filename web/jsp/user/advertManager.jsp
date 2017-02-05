<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<h1>Hello ${username}, this is your advert.</h1>

=========================================
<c:forEach var="a" items="${list}">
    <div class="advert">
        <p>Name : ${a.name} </p>
        <p>Content : ${a.description}</p>
        <p>Price : ${a.price}</p>
        =========================================
    </div>
</c:forEach>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>
