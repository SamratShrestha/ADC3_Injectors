<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.DbConnection"%>
<%@include file="/WEB-INF/templates/dashboardheader.jsp"%>
<style>
    .card label{
        font-size: 18px !important;
        color:black;
    }
    .card label:first-child{
        font-weight:bold;
    }
</style>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("cusername") == null) {
        response.sendRedirect("../index.jsp");
    }

%>
<%    Connection con = DbConnection.createConnection();
    PreparedStatement pstm = con.prepareStatement("select * from users where username=?");
    pstm.setString(1, (String) session.getAttribute("cusername"));
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
%>
<div class="row justify-content-center" id="mtop">
    <div class="col-md-6">
        <jsp:include page="/WEB-INF/templates/message.jsp"/>
        <div class="card">
            <header class="card-header">
                <h4 class="card-title mt-2" style="font-style:italic;font-weight:bolder">Profile Page</h4>
            </header>
            <article class="card-body">

                <div class="form-row">
                    <div class="col form-group">
                        <label>First name: </label> 
                        <label><%= rs.getString("firstname")%></label>
                    </div> <!-- form-group end.// -->
                    <div class="col form-group">
                        <label>Last name: </label>
                        <label><%= rs.getString("lastname")%></label>

                    </div> <!-- form-group end.// -->
                </div>
                <div class="form-group">
                    <label>Username: </label>
                    <label><%= rs.getString("username")%></label>

                </div>
                <div class="form-group">
                    <label>Email address: </label>
                    <label><%= rs.getString("email")%></label>

                </div> <!-- form-group end.// -->
                <div class="form-group">
                    <label>Phone: </label>
                    <label><%= rs.getString("phone")%></label>

                </div>

                <div class="form-group">
                    <label>Gender: </label>
                    <label><%= rs.getString("gender")%></label>

                </div>

                <div class="form-group">
                    <label>Address: </label>
                    <label><%= rs.getString("address")%></label>


                </div>

                <div class="form-group">
                    <label>Country: </label>
                    <label><%= rs.getString("country")%></label>

                </div>


                <a href="editprofile.jsp"><button class="btn btn-primary">Edit</button></a>
            </article>
        </div> 
    </div>
</div>
<%}%>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>
