<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Advert</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<h1>Editing product : </h1>
<br>
<br>
<form action="updateadvert" method="POST">
    <input type="hidden" name="id" value="${advert.id}">
    <label>
        Name of product :
        <input type="text" name="advertname" value="${advert.name}">
    </label>
    <br>
    <label>
        Its description :
        <input type="text" name="description" value="${advert.description}">
    </label>
    <br>
    <label>
        Categorie :
        <select name="categorie">
            <option value=""></option>
            <c:forEach items="${categorieList}" var="option">
                <option value="${option}">
                    <c:out value="${option.name}"></c:out>
                </option>
            </c:forEach>
        </select>
    </label>
    <br>
    <label>
        Image url :
        <input type="text" name="image" value="${advert.imageUrl}">
    </label>
    <br>
    <label>
        Its price :
        <input type="text" name="price" value="${advert.price}">
    </label>
    <br>
    <input type="submit" value="Update advert">
</form>


<%@ include file="../include/javascript.jsp" %>
</body>
</html>