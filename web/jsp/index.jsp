<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SupSale - Index</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container">
    <div class="text_index row">
        <img src="<c:url value="/img/logo.png" />" class="col-md-2 logo"/>
        <div class="col-md-offset-1 col-md-8">
            <p>Supsales is a second-hand advert selling site.You can publish an ad to sell an object. You can list ads and search
                for an article by search engine.
                On the Supsale website, you can search ads in all the following categories : Vehicles, Jobs, Real Estate,
                Multimedia, Professional Equipment, House, Leisure, Services, Other.
            </p>
            <p>Actualy they are ${userCount} users and ${advertCount} ads online !</p>
        </div>
    </div>

    <div class="row">
        <div class="filter col-md-2">
            <p>Filter by categorie : </p>
            <ul >
                <c:forEach items="${categorieList}" var="option">
                    <li class="categories"><a href="search?q=${option}">${option.name}</a></li>
                </c:forEach>
            </ul>
        </div>

        <div class="col-md-offset-1 col-md-9">
            <c:forEach var="a" items="${list}">
                <div class="advertIndex">
                    <p>Name : ${a.name} </p>
                    <p>Price : ${a.price} €</p>
                    <p>Date : ${a.publishDate} </p>
                    <c:if test="${not empty a.imageUrl}">
                        <img src="${a.imageUrl}" class="imageadvert">
                    </c:if>
                    <br>
                    <a href="<%=request.getContextPath()%>/view?id=${a.id}">View</a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="include/javascript.jsp" %>
</body>
</html>
