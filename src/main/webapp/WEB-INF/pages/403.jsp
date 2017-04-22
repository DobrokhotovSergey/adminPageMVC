<%--
  Created by IntelliJ IDEA.
  User: Dobriks
  Date: 23.04.2017
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Access denied</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="resources/adminLTE/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- NProgress -->
    <link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="resources/build/css/custom.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
            <div class="col-middle">
                <div class="text-center text-center">
                    <h1 class="error-number">403</h1>
                    <h2>Access denied</h2>
                    <h2>${msg}</h2>
                    <p>Full authentication is required to access this resource. <a href="#">Report this?</a>
                    </p>
                    <div class="mid_center">
                        <h3>Search</h3>
                        <form>
                            <div class="col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->
    </div>
</div>

<!-- jQuery -->
<script src="resources/adminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap -->
<script src="resources/adminLTE/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="resources/adminLTE/plugins/fastclick/fastclick.js"></script>
<!-- NProgress -->
<script src="resources/vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<%--<script src="../build/js/custom.min.js"></script>--%>
</body>
</html>

