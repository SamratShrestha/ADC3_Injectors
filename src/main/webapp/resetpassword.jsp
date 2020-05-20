<%@include file="/WEB-INF/templates/header.jsp" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    if (session.getAttribute("reset") == null || session.getAttribute("vaccount")==null) {
        response.sendRedirect("forgotpassword.jsp");
    }

%>

<div class="row justify-content-center">
            <form action="_resetpassword.jsp" method="POST">
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password" minlength="6">
                </div>
                <div class="form-group">
                    <label for="repassword">Confirm Password</label>
                    <input type="password" class="form-control" id="password" name="repassword" placeholder="Confirm Password" minlength="6">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
</div>


<jsp:include page="/WEB-INF/templates/footer.jsp"/>
