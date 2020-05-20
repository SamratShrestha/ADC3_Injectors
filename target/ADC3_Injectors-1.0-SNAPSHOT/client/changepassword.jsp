<%@include file="/WEB-INF/templates/dashboardheader.jsp"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("cusername") == null) {
        response.sendRedirect("../index.jsp");
    }

%>
<div class="row justify-content-center" id="mtop">
    <div class="col-md-6">
        <jsp:include page="/WEB-INF/templates/message.jsp"/>
        <div class="card">
            <header class="card-header">
                <h3 class="card-title mt-2">Change Password</h3>
            </header>
            <article class="card-body">
                <form action="changepassword" method="POST">

                    <div class="form-group">
                        <label>Old Password</label>
                        <input class="form-control" type="password" name="oldpassword" required minlength="6">
                    </div> 
                    <div class="form-group">
                        <label>New Password</label>
                        <input class="form-control" type="password" name="password" required minlength="6">
                    </div> 
                    <div class="form-group">
                        <label>Re Password</label>
                        <input class="form-control" type="password" name="repassword" required minlength="6">
                    </div> 
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block">Change</button>
                    </div>       
                </form>
            </article> 
        </div> 
    </div> 
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>