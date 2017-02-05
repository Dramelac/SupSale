<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Advert</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<h1>Hello ${username}, what do you want to add?</h1>
<br>
<br>
<form action="addadvert" method="POST">
    <label>
        Name of product :
        <input type="text" name="advertname">
    </label>
    <br>
    <label>
        Its description :
        <input type="text" name="description">
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
        <input type="text" name="image">
    </label>
    <br>
    <label>
        Its price :
        <input type="text" name="price">
    </label>
    <br>
    <input type="submit" value="Add advert">
</form>


<%@ include file="../include/javascript.jsp" %>
</body>
</html>