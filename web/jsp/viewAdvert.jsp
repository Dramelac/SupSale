<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advert Manager</title>
    <%@ include file="include/style.jsp" %>
</head>
<body>
<%@ include file="include/header.jsp" %>
<div class="container">
    <div class="advertIndex">
        <h1 class="advertName large">${advert.name} </h1>

        <div class="row">
            <div class="col-md-offset-1 col-md-7">
                <c:if test="${not empty advert.imageUrl}">
                    <img src="${advert.imageUrl}" class="imageadvert">
                </c:if>
                <c:if test="${empty advert.imageUrl}">
                    <img src="<%=request.getContextPath()%>/img/no-img.png" class="imageadvert">
                </c:if>
            </div>
            <div class="col-md-offset-1 col-md-3">
                <p>Categorie : ${advert.categorie} </p>
                <p>Posted by ${owner.username} at ${advert.publishDate}</p>
                <p>Price : ${advert.price}€</p>
            </div>
        </div>

        <div class="row col-md-offset-1">
            <p>${advert.description}</p>
        </div>

        <br>


        <c:if test="${isOwner}">
            <h2>You are the owner</h2>
            <a href="<%=request.getContextPath()%>/user/updateadvert?id=${advert.id}" class="button_style2">Edit</a> |
            <a href="<%=request.getContextPath()%>/user/removeadvert?id=${advert.id}"
               class="button_style2">Remove</a><br>
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
