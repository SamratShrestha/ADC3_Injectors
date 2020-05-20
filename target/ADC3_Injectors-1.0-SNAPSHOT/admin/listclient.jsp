<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource var="clientlistsource" driver="com.mysql.cj.jdbc.Driver" 
                   url="jdbc:mysql://localhost:3306/injectors" user="niit" password="" />

<%@include file="/WEB-INF/templates/dashboardheader.jsp"%>
<sql:query var="clientlist" dataSource="${clientlistsource}">
    select * from users;
</sql:query>
<table class="table table-striped" id="mtop">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Username</th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <c:forEach begin="0"   varStatus="loop" var="client" items="${clientlist.rows}">

        <tbody>

            <tr>
        <div >   
            <th scope="row">${loop.index+1}</th>
            <td style="font-weight:${client.isadmin==1?"bold":""}">${client.username}</td>
            <td style="font-weight:${client.isadmin==1?"bold":""}">${client.phone}</td>
            <td style="font-weight:${client.isadmin==1?"bold":""}">${client.address}</td>
            <td><input type="hidden" name="id" value="${client.id}">
                <a href="editclient.jsp?id=${client.id}"><button class="btn btn-primary">Edit</button></a>
                <c:if test = "${client.acc_status == true}">
                    <a href="blockclient?id=${client.id}"><button class="btn btn-secondary">Block</button></a>
                </c:if>
                <c:if test = "${client.acc_status == false}">
                    <a href="unblockclient?id=${client.id}"><button class="btn btn-secondary">Unblock</button></a>
                </c:if>
                <a href="deleteclient?id=${client.id}"><button class="btn btn-danger">Delete</button></a></td>
        </div>    
    </tr>
</tbody>
</c:forEach>
</table>
<jsp:include page="/WEB-INF/templates/message.jsp"/>
<jsp:include page="/WEB-INF/templates/footer.jsp"/>

