<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container">
<c:if test="${not empty filter}">
    <h3>Result search for : ${filter}</h3>
</c:if>

<c:if test="${fn:length(resultList) > 0}">
    ___________________________________________
    <c:forEach var="a" items="${resultList}">
        <div class="advert">
            <a href="<%=request.getContextPath()%>/view?id=${a.id}">
                <p>Name : ${a.name} </p>
            </a>
            ___________________________________________
        </div>
    </c:forEach>
</c:if>
<c:if test="${fn:length(resultList) == 0}">
    <p>No product found.</p>
</c:if>
</div>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
