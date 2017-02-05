<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="advert">
    <h1>${advert.name} </h1>
    <p>Categorie : ${advert.categorie.name}</p>
    <p>${advert.description}</p>

    <c:if test="${not empty advert.imageUrl}">
        <img src="${advert.imageUrl}">
    </c:if>

    <p>Posted by ${owner} at ${advert.publishDate}</p>
    <p>Price : ${advert.price}€</p>
</div>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
