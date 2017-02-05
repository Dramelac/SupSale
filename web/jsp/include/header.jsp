<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style><%@ include file="/jsp/CSS/style.css"%></style>
<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/">SupSale</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:if test="${not empty username}">
                    <li><a href="<%=request.getContextPath()%>/user/addadvert"><p>Add advert</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/user/advertmanager"><p>Advert manager</p></a></li>

                    <c:if test="${isAdmin}">
                        <li><a href="<%=request.getContextPath()%>/admin/"><p>Admin panel</p></a></li>
                    </c:if>
                </c:if>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty username}">
                    <li><a href="<%=request.getContextPath()%>/register"><p class="navbar-text">Register</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/login"><p class="navbar-text">Login</p></a></li>
                </c:if>
                <c:if test="${not empty username}">
                    <li><a href="<%=request.getContextPath()%>/user/profile"><p class="navbar-text">Profile</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/user/logout"><p class="navbar-text">Logout</p></a></li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
