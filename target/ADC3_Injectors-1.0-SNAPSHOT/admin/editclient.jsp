<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.DbConnection"%>
<%@include file="/WEB-INF/templates/dashboardheader.jsp"%>

<%    Connection con = DbConnection.createConnection();
    PreparedStatement pstm = con.prepareStatement("select * from users where id=?");
    pstm.setString(1, request.getParameter("id"));
    ResultSet rs = pstm.executeQuery();
    if (rs.next()) {
%>
<div class="row justify-content-center" id="mtop">
    <div class="col-md-6">
        <jsp:include page="/WEB-INF/templates/message.jsp"/>
        <div class="card">
            <header class="card-header">
                <h4 class="card-title mt-2">Edit Client Page</h4>
            </header>
            <article class="card-body">
                <form action="editclient" method="POST">
                    <div class="form-row">
                        <div class="col form-group">
                            <label>First name: </label> 
                            <input type="text" value="<%= rs.getString("firstname")%>" class="form-control" placeholder="Firstname" name="firstname" required>

                        </div> <!-- form-group end.// -->
                        <div class="col form-group">
                            <label>Last name: </label>
                            <input type="text" value="<%= rs.getString("lastname")%>" class="form-control" placeholder="Lastname" name="lastname" required>

                        </div> <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->
                    <div class="form-group">
                        <label>Username: </label>
                        <input type="text" value="<%= rs.getString("username")%>" class="form-control" placeholder="Username" name="username" required>

                    </div>
                    <div class="form-group">
                        <label>Email address: </label>
                        <input type="text" value="<%= rs.getString("email")%>" class="form-control" placeholder="email" name="email" required>

                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <label>Phone: </label>
                        <input type="text" value="<%= rs.getString("phone")%>" class="form-control" placeholder="phone" name="phone" required>

                    </div>

                    <div class="form-group">
                        <label>Gender: </label>
                        <input type="text" value="<%= rs.getString("gender")%>" class="form-control" placeholder="gender" name="gender" required>

                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Address: </label>
                            <input type="text" value="<%= rs.getString("address")%>" class="form-control" placeholder="address" name="address" required>

                        </div> 
                        <div class="form-group col-md-6">
                            <label>Country: </label>
                            <input type="text" value="<%= rs.getString("country")%>" class="form-control" placeholder="country" name="country" required>

                        </div>
                        <input type="hidden" value="<%= rs.getInt("id")%>" name="id">

                    </div> 
                    <button type="submit" class="btn btn-primary btn-block">Edit Client</button>

                </form>

            </article>
        </div> 
    </div>
</div>
<%}%>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>