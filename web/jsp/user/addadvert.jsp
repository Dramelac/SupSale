<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Advert</title>
    <%@ include file="../include/style.jsp" %>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="container">
<h1>Hello ${username}, what do you want to add?</h1>
<br>
<br>
<form action="addadvert" method="POST">
    <label class="ajust_labels">
        Name of product :

    </label> <input type="text" name="advertname">
    <br><br>
    <label class="ajust_labels">
        Its description :

    </label><input type="text" name="description">
    <br><br>
    <label class="ajust_labels">
        Categorie :

    </label><select name="categorie">
    <option value=""></option>
    <c:forEach items="${categorieList}" var="option">
        <option value="${option}">
            <c:out value="${option.name}"></c:out>
        </option>
    </c:forEach>
</select>
    <br><br>
    <label class="ajust_labels">
        Image url :
    </label> <input type="text" name="image">
    <br><br>
    <label class="ajust_labels">
        Its price :

    </label> <input type="text" name="price">
        €
    <br><br>
    <input type="submit" value="Add advert" class="button">
</form>
</div>

<%@ include file="../include/javascript.jsp" %>
</body>
</html>