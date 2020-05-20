<jsp:include page="/WEB-INF/templates/header.jsp" />

<!--<form action="addclient" method="POST">-->
<%
    if (session.getAttribute("username") != null) {
        response.sendRedirect("../admin/dashboard.jsp");
    }
%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("cusername") == null) {
        response.sendRedirect("../index.jsp");
    }

%>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <header class="card-header">
                <h4 class="card-title mt-2">Sign Up</h4>
            </header>
            <article class="card-body">
                <!--form starts-->
                <form action="register" method="POST">
                    <div class="form-row">
                        <div class="col form-group">
                            <label>First name </label>   
                            <input type="text" class="form-control" placeholder="Firstname" name="firstname" required>
                        </div> <!-- form-group end.// -->
                        <div class="col form-group">
                            <label>Last name</label>
                            <input type="text" class="form-control" placeholder="Lastname" name="lastname" required>
                        </div> <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->
                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" placeholder="Username" name="username" required minlength="3">
                    </div>
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" required>
                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="number" class="form-control" placeholder="Phone" name="phone" required minlength="10" maxlength="10">
                    </div>

                    <div class="form-group">
                        <label>Gender</label>
                        <label class="form-check form-check-inline">
                            <span class="form-check-label"> Male </span>
                            <input class="form-check-input" type="radio" name="gender" value="male" checked >

                        </label>
                        <label class="form-check form-check-inline">
                            <span class="form-check-label"> Female</span>
                            <input class="form-check-input" type="radio" name="gender" value="female">

                        </label>
                    </div> <!-- form-group end.// -->
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Secret Question</label>
                            <select id="inputState" class="form-control">
                                <option>What is you favorite memory?</option>
                            </select>
                        </div> 
                        <div class="form-group col-md-6">
                            <label>Answer</label>
                            <input type="text" class="form-control" placeholder="Answer" name="answer" required>
                        </div>
                    </div> <!-- form-row.// -->
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Address</label>
                            <input type="text" class="form-control" placeholder="Address" name="address">

                        </div> 
                        <div class="form-group col-md-6">
                            <label>Country</label>
                            <input type="text" class="form-control" placeholder="Country" name="country">
                        </div>
                    </div> 
                    <div class="form-group">
                        <label>Create password</label>
                        <input class="form-control" type="password" name="password" required minlength="6">
                    </div>
                    <div class="form-group">
                        <label>Confirm password</label>
                        <input class="form-control" type="password" name="repassword" required minlength="6">
                    </div>
                    <!-- form-group end.// -->  
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </div> <!-- form-group// -->      
                </form>
                <!--form ends-->
            </article> <!-- card-body end .// -->
            <div class="border-top card-body text-center">Have an account? <a href="${pageContext.request.contextPath}/login.jsp">Log In</a></div>
        </div> <!-- card.// -->
    </div> <!-- col.//-->
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp" />