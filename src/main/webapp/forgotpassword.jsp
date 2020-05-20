<%@include file="/WEB-INF/templates/header.jsp" %>
<div class="container">
    <div class="row justify-content-center">
        <div class="text-center">
            <h3><i class="fa fa-lock fa-4x"></i></h3>
            <h2 class="text-center">Forgot Password?</h2>
            <p>You can reset your password here.</p>
            <form action="forgotpassword" method="POST">
                <div class="form-group">
                    <input placeholder="Username" type="text" name="username" required>
                </div>
                <div class="form-group">
                    <input class="btn btn-primary" value="Send My Password" type="submit">
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>

