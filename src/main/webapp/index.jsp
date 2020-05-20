<%@include file="/WEB-INF/templates/header.jsp" %>
<div id="sidebar">
    <div class="text">   
        <h2>Injectors</h2>
        <p> Login as Admin or Client</p>
    </div>
</div>
<div class="main">
    <div style="margin-bottom: 3rem">
        <a href="admin/login"><button class="btn btn-primary btn-lg btn-block">Login as Admin</button></a>
    </div>
    <div>
        <a href ="client/login"><button class="btn btn-secondary btn-lg btn-block">Login as Client</button></a>
    </div> 
</div>


<jsp:include page="WEB-INF/templates/footer.jsp"/>