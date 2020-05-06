<jsp:include page="/WEB-INF/templates/header.jsp"/>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");

    if (session.getAttribute("username") != null) {
        response.sendRedirect("dashboard.jsp");
    }
%>

<div class="sidebar">
    <div class="text">   
        <h2>Application Login Page</h2>
        <p> Login or Register to access page</p>
    </div>
</div>
<div class="main">
    <h2>Admin Login</h2>
    <form action="dashboard" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="username" class="form-control" id="username" name="username" placeholder="Enter username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="form-group">
            <a href="forgotpassword.jsp">Forgot Password?</a>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>


<jsp:include page="/WEB-INF/templates/footer.jsp"/>