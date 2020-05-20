<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">

    </head>
    <body>
        <%@include file="/WEB-INF/templates/redirect.jsp" %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Injectors</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
                    </li>   
                    <li class="nav-item">
        <!--                <a class="nav-link" href="${pageContext.request.contextPath}/register.jsp">Register</a>-->
                    </li> 
                </ul>
                <%
                    if (session.getAttribute("username") != null) {
                %>

                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="logout"><strong>Logout</strong></a>
                    </li> 
                </ul>
                <%}%>
            </div>
        </nav>        