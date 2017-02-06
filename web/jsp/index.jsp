<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale - Index</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="text_index">
    <img src="<c:url value="/img/logo.png" />" class="logo"/>
    <p>Supsale is a second-hand advert selling site.You can publish an ad to sell an object. You can list ads and search
        for an article by search engine.
        On the Supsale website, you can search ads in all the following categories : Vehicles, Jobs, Real Estate,
        Multimedia, Professional Equipment, House, Leisure, Services, Other.
    </p>
    <p>Actualy they are ${userCount} users and ${advertCount} ads online !</p>
</div>
<div>
    <p>Filter by categorie : </p>
    <ul>
        <c:forEach items="${categorieList}" var="option">
            <li><a href="search?q=${option}">${option.name}</a></li>
        </c:forEach>
    </ul>
</div>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
