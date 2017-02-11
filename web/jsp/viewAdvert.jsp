<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container">
    <div class="advert">
        <h1>${advert.name} </h1>
        <p>Categorie : ${advert.categorie.name}</p>
        <p>${advert.description}</p>

        <c:if test="${not empty advert.imageUrl}">
            <img src="${advert.imageUrl}">
        </c:if>

        <p>Posted by ${owner.username} at ${advert.publishDate}</p>
        <p>Price : ${advert.price}€</p>
        <br>

        <c:if test="${isOwner}">
            <h2>You are the owner</h2>
            <a href="<%=request.getContextPath()%>/user/updateadvert?id=${advert.id}">Edit</a> |
            <a href="<%=request.getContextPath()%>/user/removeadvert?id=${advert.id}">Remove</a><br>
        </c:if>

        <c:if test="${(!isOwner) and (not empty username) }">
            <form name="contact_form" method="POST">
                <label>
                    Telephone number of the owner: ${owner.phonenumber}
                </label>
                <br>
                <label>
                    Content of your mail to the owner:
                </label>
                <br>
                <textarea name="email_content"></textarea>
                <br><br>
                <input type="submit" value="Send email" class="button">
            </form>
        </c:if>
    </div>
</div>
<%@ include file="include/javascript.jsp" %>
</body>
</html>
