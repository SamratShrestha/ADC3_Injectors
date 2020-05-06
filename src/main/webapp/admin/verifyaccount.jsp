<jsp:include page="/WEB-INF/templates/header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="text-center">
            <h3><i class="fa fa-lock fa-4x"></i></h3>
            <p>Hello,${reset}. Answer the security question.</p>
            <form action="_verifyaccount.jsp" method="POST">
                <div class="form-group">
                    <label>Secret Question</label>
                    <select id="inputState" class="form-control">
                        <option>What is you favourite memory?</option>
                    </select>
                </div> 
                <div class="form-group">
                    <label>Answer</label>
                    <input type="text" class="form-control" placeholder="Answer" name="answer" required>
                </div>
                <input type="submit" value="Send" class="btn btn-primary">
            </form>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>
