<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>
            Injectors
        </title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <!-- CSS Files -->
        <link href="${pageContext.request.contextPath}/static/css/paper-dashboard.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
    </head>


    <body>
       
        <div class="wrapper ">
            <div class="sidebar" data-color="white" data-active-color="danger">
                <div class="logo">
                    <a href="#" class="simple-text logo-mini">
                        <div class="logo-image-small">
                            <img src="${pageContext.request.contextPath}/static/images/logo-small.png">
                        </div>
                    </a>      
                    <a href="#" class="simple-text logo-normal">
                        Welcome ${username}   
                    </a>
                </div>
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li>
                            <a href="dashboard.jsp">
                                <p>Dashboard</p>
                            </a>
                        </li>
                        <li>
                            <a href="profile.jsp">
                                <p>Profile</p>
                            </a>
                        </li>
                        <li>
                            <a href="changepassword.jsp">
                                <p>Change Password</p>
                            </a>
                        </li>

                        <li>
                            <a href="history.jsp">
                                <p>History</p>
                            </a>
                        </li>
                        <%if (session.getAttribute("username") != null) {%>
                        <li>
                            <a href="addclient.jsp">
                                <p>Add Client</p>
                            </a>
                        </li>
                        <li>
                            <a href="listclient.jsp">
                                <p>List Client</p>
                            </a>
                        </li>
                        <li>
                            <a href="report.jsp">
                                <p>Report</p>
                            </a>
                        </li>
                        <%}%>

                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
                    <div class="container-fluid">
                        <div class="navbar-wrapper">
                            <div class="navbar-toggle">
                                <button type="button" class="navbar-toggler">
                                    <span class="navbar-toggler-bar bar1"></span>
                                    <span class="navbar-toggler-bar bar2"></span>
                                    <span class="navbar-toggler-bar bar3"></span>
                                </button>
                            </div>
                            <a class="navbar-brand" href="#">Injectors</a>
                        </div>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                            <span class="navbar-toggler-bar navbar-kebab"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">

                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="../logout"><strong>Logout</strong></a>

                                    <!--<a class="nav-link" href="${pageContext.request.contextPath}/logout"><strong>Logout</strong></a>-->
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- End Navbar -->
