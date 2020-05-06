<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.DbConnection"%>
<%@page import="java.sql.Connection"%>
<jsp:include page="/WEB-INF/templates/header.jsp"/>
<%
    String username = (String) session.getAttribute("reset");
    String right_answer="";
    Connection con = new DbConnection().createConnection();
    PreparedStatement pstm = con.prepareStatement("select answer from admin where username=?");
    pstm.setString(1, username);
    ResultSet rs = pstm.executeQuery();
    if(rs.next()){
         right_answer = rs.getString(1);
    }
    String answer = request.getParameter("answer");
    out.println(answer);
    out.println("the right answer is"+right_answer);
    if(answer.equalsIgnoreCase(right_answer)){
        response.sendRedirect("resetpassword.jsp");
    }else{
        response.sendRedirect("verifyaccount.jsp");
    }
    
%>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>
