<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@include file="/WEB-INF/templates/header.jsp" %>
<%
    String username = (String) session.getAttribute("reset");
    String right_answer = "";
    Connection con = new DbConnection().createConnection();
    String password = request.getParameter("password");
    String repassword = request.getParameter("repassword");
    if (password.equals(repassword) && !(password.isEmpty())) {
        PreparedStatement pstm = con.prepareStatement("update users set password=?,oldpassword=? where username=?");
        pstm.setString(1, password);
        pstm.setString(2, password);
        pstm.setString(3, (String) session.getAttribute("reset"));
        int i = pstm.executeUpdate();
        if (i != 0) {
            session.setAttribute("success-message", "Password Updated Successfully");
            response.sendRedirect("index.jsp");
        } else {
            session.setAttribute("faliure-message", "Password Not Updated");
            response.sendRedirect("resetpassword.jsp");
        }

    } else {
        session.setAttribute("faliure-message", "Both password must match");
        response.sendRedirect("resetpassword.jsp");
    }

%>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>
