<%--
  Created by IntelliJ IDEA.
  User: Dobriks
  Date: 12.03.2017
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <script type="text/javascript" src="resources/js/jquery-2.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.js"></script>
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/admin.css">
</head>
<body>
<div id="top-nav" class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-toggle"></span>
            </button>
            <a class="navbar-brand" href="#">User Page</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i>${login}<span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                    </ul>
                </li>

                <li><form action="/logout" method="post" id="logoutForm" style="display: none">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
                    <a href="#" onclick="$('#logoutForm').submit();"><i class="glyphicon glyphicon-lock"></i> Logout</a>
                </li>
            </ul>
        </div>
    </div><!-- /container -->
</div>

</body>
</html>
