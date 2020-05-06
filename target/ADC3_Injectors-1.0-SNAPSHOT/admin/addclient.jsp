<jsp:include page="/WEB-INF/templates/header.jsp" />

<!--<form action="addclient" method="POST">-->

<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <header class="card-header">
                <h4 class="card-title mt-2">Add Client</h4>
            </header>
            <article class="card-body">
                <form action="addclient" method="POST">
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
                        <input type="text" class="form-control" placeholder="Username" name="username" required>
                    </div>
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" placeholder="Email" name="email" required>
                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="number" class="form-control" placeholder="Phone" name="phone" required>
                    </div>

                    <div class="form-group">
                        <lable>Gender</lable>
                        <label class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="male" checked >
                            <span class="form-check-label"> Male </span>
                        </label>
                        <label class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="gender" value="female">
                            <span class="form-check-label"> Female</span>
                        </label>
                    </div> <!-- form-group end.// -->
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Secret Question</label>
                            <select id="inputState" class="form-control">
                                <option>What is you favourite memory?</option>
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
                        <input class="form-control" type="password" name="password" required>
                    </div> <!-- form-group end.// -->  
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block"> Register  </button>
                    </div> <!-- form-group// -->      
                </form>
            </article> <!-- card-body end .// -->
        </div> <!-- card.// -->
    </div> <!-- col.//-->
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp" />