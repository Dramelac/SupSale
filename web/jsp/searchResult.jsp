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
    <c:forEach var="a" items="${resultList}">
        <div class="advertIndex col-md-12">
            <a href="<%=request.getContextPath()%>/view?id=${a.id}">
                <div class="advertName">
                        ${a.name}
                </div>
                <div class="row">
                    <div class="col-md-offset-1 col-md-7">
                        <c:if test="${not empty a.imageUrl}">
                            <img src="${a.imageUrl}" class="imageadvert">
                        </c:if>
                        <c:if test="${empty a.imageUrl}">
                            <img src="<%=request.getContextPath()%>/img/no-img.png" class="imageadvert">
                        </c:if>
                    </div>
                    <div class="col-md-offset-1 col-md-3">
                        <p>Categorie : ${a.categorie} </p>
                        <p>Price : ${a.price} €</p>
                        <p>Date : ${a.publishDate} </p>
                    </div>
                </div>
                <br>
            </a>
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
