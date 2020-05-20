<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("username") != null) {
        response.sendRedirect("admin/dashboard.jsp");
    }
     if (session.getAttribute("cusername") != null) {
        response.sendRedirect("client/dashboard.jsp");
    }

%>