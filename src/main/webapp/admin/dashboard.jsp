<jsp:include page="/WEB-INF/templates/header.jsp"/>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("../index.jsp");
    }

%>

<jsp:include page="/WEB-INF/templates/message.jsp"/>
<h1>Welcome ${username}</h1>
<a href="addclient.jsp">Add Client</a>
<form action="logout" method="POST">
    <input type="submit" value="Logout">
</form>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>