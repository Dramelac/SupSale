<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container-fluid">

        <div class="navbar-header">
            <a class="navbar-brand" href="<%=request.getContextPath()%>/index"> <img src="<c:url value="/img/logo.png" />" class="nav_bar_logo"/>
            </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <c:if test="${not empty username}">
                    <li><a href="<%=request.getContextPath()%>/user/addadvert"><p class="buttons_header">Add advert</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/user/advertmanager"><p class="buttons_header">Advert manager</p></a></li>

                    <c:if test="${isAdmin}">
                        <li><a href="<%=request.getContextPath()%>/admin/"><p class="buttons_header">Admin panel</p></a></li>
                    </c:if>
                </c:if>
            </ul>
            <form method="GET" action="<%=request.getContextPath()%>/search" class="nav navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" name="q" class="search_input" placeholder="Search">

                <button type="submit" class="submit_search">Submit</button>
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty username}">
                    <li><a href="<%=request.getContextPath()%>/register"><p class="buttons_header">Register</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/login"><p class="buttons_header">Login</p></a></li>
                </c:if>
                <c:if test="${not empty username}">
                    <li><a href="<%=request.getContextPath()%>/user/profile"><p class="buttons_header">Profile</p></a></li>
                    <li><a href="<%=request.getContextPath()%>/user/logout"><p class="buttons_header">Logout</p></a></li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
