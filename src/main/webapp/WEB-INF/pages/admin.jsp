<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <title>admin page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="resources/adminLTE/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/adminLTE/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resources/adminLTE/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <%--<link href="resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="resources/adminLTE/plugins/iCheck/flat/blue.css">

    <!-- jvectormap -->
    <link rel="stylesheet" href="resources/adminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- Date Picker -->
    <link rel="stylesheet" href="resources/adminLTE/plugins/datepicker/datepicker3.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="resources/adminLTE/plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="resources/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="resources/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="resources/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <![endif]-->

</head>
<div class="modal modal-form fade" id="savedCommercial-modal"  role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel7">Saved Commercial Invoice</h4>
            </div>
            <div class="modal-body" id="savedCommercial-body">
                <%--<form id="searchCommercial-form" data-parsley-validate class="form-horizontal form-label-left">--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-4 col-sm-4 col-xs-12" for="daterange-btn3">Date range button:<span class="required">*</span>--%>
                        <%--</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<button type="button" class="form-control col-md-8 col-xs-12 btn btn-default pull-right daterange-btn" id="daterange-btn3">--%>
                                                    <%--<span>--%>
                                                      <%--<i class="fa fa-calendar"></i> Date range picker--%>
                                                    <%--</span>--%>
                                <%--<i class="fa fa-caret-down"></i>--%>
                            <%--</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>

                        <%--<label class="control-label col-md-4 col-sm-4 col-xs-12" for="search-name-commercial">Invoice Name--%>
                        <%--</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="text" name="client" id="search-name-commercial"  class="form-control col-md-8 col-xs-12" autocomplete="off">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</form>--%>
            </div>
            <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                <%--<button type="submit" class="btn btn-success" id="searchCommercialInvoice-submit">Search</button>--%>
            <%--</div>--%>

        </div>
    </div>
</div>


<div class="modal modal-form fade bs-example-modal-nm" id="searchCommercial-modal"  role="dialog" aria-hidden="true" style="display: none;">

    <div class="modal-dialog modal-nm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel6">Search Commercial Invoices</h4>
            </div>
            <div class="modal-body">
                <form id="searchCommercial-form" data-parsley-validate class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" for="daterange-btn3">Date range button:<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <button type="button" class="form-control col-md-8 col-xs-12 btn btn-default pull-right daterange-btn" id="daterange-btn3">
                                                    <span>
                                                      <i class="fa fa-calendar"></i> Date range picker
                                                    </span>
                                <i class="fa fa-caret-down"></i>
                            </button>
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="control-label col-md-4 col-sm-4 col-xs-12" for="search-name-commercial">Invoice Name
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" name="client" id="search-name-commercial"  class="form-control col-md-8 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="searchCommercialInvoice-submit">Search</button>
            </div>

        </div>
    </div>
</div>
<div class="modal modal-form fade bs-example-modal-nm" id="searchInvoicesFarm-modal"  role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-nm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel3">Search invoices from Farm</h4>
            </div>
            <div class="modal-body">
                <form id="searchInvoicesFarm-form" data-parsley-validate class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" for="daterange-btn">Date range button:<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <button type="button" class="form-control col-md-8 col-xs-12 btn btn-default pull-right daterange-btn" id="daterange-btn">
                                                    <span>
                                                      <i class="fa fa-calendar"></i> Date range picker
                                                    </span>
                                <i class="fa fa-caret-down"></i>
                            </button>
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="control-label col-md-4 col-sm-4 col-xs-12" for="search-invoiceFarm-client">Client
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" name="client" id="search-invoiceFarm-client"  class="form-control col-md-8 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="searchInvoicesFarm-submit">Search</button>
            </div>

        </div>
    </div>
</div>
<div class="modal modal-form fade bs-example-modal-nm" id="searchInvoicesShipment-modal"  role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-nm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel4">Search invoices for Shipment</h4>
            </div>
            <div class="modal-body">
                <form id="searchInvoicesShipment-form" data-parsley-validate class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-4 col-sm-4 col-xs-12" for="daterange-btn2">Date range button:<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <button type="button" class="form-control col-md-8 col-xs-12 btn btn-default pull-right daterange-btn" id="daterange-btn2">
                                                    <span>
                                                      <i class="fa fa-calendar"></i> Date range picker
                                                    </span>
                                <i class="fa fa-caret-down"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="searchInvoicesShipment-submit">Search</button>
            </div>

        </div>
    </div>
</div>
<div class="modal modal-form fade bs-example-modal-nm" id="deleteEmployee-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-nm">
        <div class="modal-content">
            <input id="user-employee-delete" style="display: none">

            </input>
            <input id="pos-employee-delete" style="display: none">

            </input>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Delete Employee</h4>
            </div>
            <div class="modal-body">
                <form id="deleteEmployee-form" data-parsley-validate class="form-horizontal form-label-left">
                    Are you sure delete this Employee?
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="deleteEmployee-submit">Confirm</button>
            </div>

        </div>
    </div>
</div>
<div class="modal modal-form fade bs-example-modal-nm" id="editEmployee-modal"  role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-nm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="editEmployeeLabel">Edit Employee</h4>
            </div>
            <input id="edit-employee-pos" style="display: none">
            <div class="modal-body">
                <form id="editEmployee-form" data-parsley-validate class="form-horizontal form-label-left">

                    <input id="edit-employee-login" style="display: none">
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-name">Login<span class="required">*</span>--%>
                        <%--</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="text" id="edit-employee-name" name="username" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>

                        <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-password">Password<span class="required">*</span>--%>
                        <%--</label>--%>
                        <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                            <%--<input type="password" id="edit-employee-password" name="password" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="edit-employee-firstname">First Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="edit-employee-firstname" name="firstname" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="edit-employee-lastname">Last Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="edit-employee-lastname" name="lastname" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="edit-employee-position">Position<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="edit-employee-position" name="position" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="edit-employee-role">Role<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control col-md-7 col-xs-12" name="role" id="edit-employee-role">
                                <option value="ROLE_ADMIN">ADMIN</option>
                                <option value="ROLE_USER">USER</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="editEmployee-submit">Change</button>
            </div>

        </div>
    </div>
</div>
<div class="modal modal-form fade bs-example-modal-nm" id="addEmployee-modal"  role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-nm">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="addEmployeeLabel">Add new Employee</h4>
            </div>
            <div class="modal-body">
                <form id="addEmployee-form" data-parsley-validate class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-name">Login<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="employee-name" name="username" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">

                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-password">Password<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="password" id="employee-password" name="password" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-firstname">First Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="employee-firstname" name="firstname" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-lastname">Last Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="employee-lastname" name="lastname" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-position">Position<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="employee-position" name="position" required="required" class="form-control col-md-7 col-xs-12" autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="employee-role">Role<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <select class="form-control col-md-7 col-xs-12" name="role" id="employee-role">
                            <option value="ROLE_ADMIN">ADMIN</option>
                            <option value="ROLE_USER">USER</option>
                        </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success" id="addEmployee-submit">Create</button>
            </div>

        </div>
    </div>
</div>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>L</b>Gr</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Lakshmi</b>Group</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">

                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="/admin/getAvatar/${login}"  onerror="this.src='/resources/images/admin.png'" class="user-image" alt="User Image">
                            <span class="hidden-xs">${firstname} ${lastname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="/admin/getAvatar/${login}"  onerror="this.src='/resources/images/admin.png'" class="img-circle" alt="User Image">

                                <p>
                                    ${firstname} ${lastname} - ${position}

                                </p>
                            </li>

                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat" onclick="getProfile();">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/admin/getAvatar/${login}"  onerror="this.src='/resources/images/admin.png'" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${firstname} ${lastname}</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">Genereal</li>

                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>Tables</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a style=" cursor: pointer;" onclick="getFarm();"><i class="fa fa-circle-o text-red"></i> Farms</a></li>

                    </ul>
                    <%--<ul class="treeview-menu">--%>
                        <%--<li><a style=" cursor: pointer;"><i class="fa fa-pie-chart text-red"></i> Charts</a></li>--%>

                    <%--</ul>--%>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="ion ion-clipboard"></i> <span>Invoices</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a style=" cursor: pointer;" onclick="getInvoiceFromFarm();"><i class="fa fa-circle-o text-red"></i>from farm</a></li>
                        <li><a style=" cursor: pointer;" onclick="getInvoiceShipment();"><i class="fa fa-circle-o text-red"></i>for shipment</a></li>
                        <li><a style=" cursor: pointer;" onclick="getCommercialInvoice();"><i class="fa fa-circle-o text-red"></i>commercial</a></li>

                    </ul>
                </li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i> <span>Charts</span>
                        <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a style=" cursor: pointer;" onclick="getGraphicsFarm();">
                            <i class="fa fa-circle-o text-red"></i> graphics farms</a></li>

                    </ul>
                </li>
                <li class="header">User Managment</li>
                <li class="treeview">
                    <a href="#" onclick="getPageUsers();">
                        <i class="fa fa-users"></i> <span>Users</span>
                    </a>
                </li>
            </ul>
        </section>
    </aside>

    <div class="content-wrapper"  role="main" id="main">

        <div class="right_col">

            <div class="modal modal-form fade bs-example-modal-nm" id="deleteProduct-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">
                        <input id="id-product-delete" style="display: none">

                        </input>
                        <input id="id-farmOfProduct-delete" style="display: none">

                        </input>
                        <input id="position-product-delete" style="display: none">

                        </input>
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">Delete Product</h4>
                        </div>
                        <div class="modal-body">
                            <form id="deleteProduct-form" data-parsley-validate class="form-horizontal form-label-left">
                                Are you sure delete this Product?
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="deleteProduct-submit">Confirm</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal modal-form fade bs-example-modal-nm" id="deleteFarm-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">
                        <input id="id-farm-delete" style="display: none">

                        </input>
                        <input id="position-farm-delete" style="display: none">

                        </input>
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">Delete Farm</h4>
                        </div>
                        <div class="modal-body">
                            <form id="deleteFarm-form" data-parsley-validate class="form-horizontal form-label-left">
                                Are you sure delete Farm?
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="deleteFarm-submit">Confirm</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal modal-form fade bs-example-modal-nm" id="editFarm-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">
                        <input id="id-farm-edit" style="display: none">

                        </input>
                        <input id="position-farm-edit" style="display: none">

                        </input>
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">edit Farm</h4>
                        </div>
                        <div class="modal-body">
                            <form id="editFarm-form" data-parsley-validate class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="farm-name">Farm Name<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="edit-farm-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="editFarm-submit">Change</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal fade bs-example-modal-lg" id="shipment-invoice-modal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel1">Create invoice for Shipment</h4>
                        </div>
                        <div class="modal-body">
                            <div id="shipment-invoice-modal-id" style="display: none"></div>
                            <form class="form-horizontal">
                                <div class="well" style="overflow: auto">
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Invoice Name
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="ion ion-clipboard"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="shipment-invoice" placeholder="Invoice Name">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Invoice Date
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="shipment-invoice-date" placeholder="First Name" aria-describedby="inputSuccess2Status4">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Cross Curs USD->EUR
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-eur"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="shipment-invoice-USD_EUR" placeholder="USD->EUR">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Cross Curs EUR->USD
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-usd"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="shipment-invoice-EUR_USD" placeholder="EUR->USD">
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="ln_solid"></div>
                                <div style="overflow:auto;">
                                    <table id="table-shipment-invoice" class="table table-responsive table-striped  table-bordered">

                                        <thead>
                                        <tr>
                                            <th>Farm Name</th>
                                            <th>Box</th>
                                            <th>Sort</th>
                                            <th>Label Client</th>
                                            <th>Type</th>
                                            <%--<th>Date</th>--%>
                                            <th>number stems in Box</th>
                                            <th>price for stem</th>
                                            <th>price for Box</th>
                                            <th>Currency</th>
                                            <th>price (cross)</th>
                                            <th>price Box(cross)</th>
                                            <th>id Invoice Farm</th>
                                            <th>id Product</th>
                                            <th>idProductionInvoiceFarm</th>
                                            <%--<th style="width: 12%">product</th>--%>
                                            <%--<th style="width: 12%">grading</th>--%>
                                            <%--<th style="width: 12%">number stems in Box</th>--%>
                                            <%--<th style="width: 12%">price, <span class="fa farm-invoice-mainCurrency"></span></th>--%>
                                            <%--<th style="width: 12%">price(discount), <span class="fa farm-invoice-mainCurrencyDiscount"></span></th>--%>
                                            <%--<th style="width: 12%">discount, %</th>--%>
                                            <%--<th style="width: 12%">price(cross), <span class="fa farm-invoice-crossCurrency"></span></th>--%>
                                            <%--<th style="width: 12%">price(discount cross), <span class="fa farm-invoice-crossCurrencyDiscount"></span></th>--%>
                                            <%--<th>idProduct</th>--%>
                                            <%--<th>idFerm</th>--%>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>

                                <%--<div class="ln_solid"></div>--%>
                                <table class="col-md-4 col-sm-4 col-xs-12 table table-responsive table-bordered" id="shipment-invoice-totalPrice" style="float:right">
                                    <tr>
                                        <th>total Price, <span class="fa farm-invoice-mainCurrency"></span>:</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<th>total Price with discount, <span class="fa farm-invoice-mainCurrencyDiscount"></span> :</th>--%>
                                        <%--<td style='font-weight:bold;'></td>--%>
                                    <%--</tr>--%>
                                    <tr>
                                        <th>total Price(cross), <span class="fa farm-invoice-crossCurrency"></span>:</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                    <%--<tr>--%>
                                        <%--<th>total Price(cross) with discount, <span class="fa farm-invoice-crossCurrencyDiscount"></span>:</th>--%>
                                        <%--<td style='font-weight:bold;'></td>--%>
                                    <%--</tr>--%>
                                </table>
                            </form>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="create-shipment-invoice-btn-save">Save changes</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal fade bs-example-modal-lg" id="farm-invoice-modal" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">Create invoice from Farm</h4>
                        </div>
                        <div id="curr-invoiceFarm" style="display: none"></div>
                        <div class="modal-body">
                            <div id="farm-invoice-modal-id" style="display: none"></div>
                            <form class="form-horizontal">
                                <div class="well" style="overflow: auto">
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Invoice Name
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="ion ion-clipboard"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-name" placeholder="Invoice Name">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Client Name
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-clientName" placeholder="Client Name">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Invoice Date
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-date" placeholder="First Name" aria-describedby="inputSuccess2Status4">
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-3 col-xs-12">
                                        Cross Curs
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa" id="invoiceFarm-currencyOther"></i>
                                            </div>
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-crossCurs" maxlength="6"  placeholder="Cross Curs">
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="ln_solid"></div>
                                <div style="overflow:auto;">
                                    <table id="table-farm-invoice" class="table table-responsive table-striped  table-bordered">

                                        <thead>
                                        <tr>
                                            <th style="width: 12%">product</th>
                                            <th style="width: 12%">grading, sm</th>
                                            <th style="width: 12%">number stems in Box</th>
                                            <th style="width: 12%">price, <span class="fa farm-invoice-mainCurrency"></span></th>
                                            <th style="width: 12%">price(discount), <span class="fa farm-invoice-mainCurrencyDiscount"></span></th>
                                            <th style="width: 12%">discount, %</th>
                                            <th style="width: 12%">price(cross), <span class="fa farm-invoice-crossCurrency"></span></th>
                                            <th style="width: 12%">price(discount cross), <span class="fa farm-invoice-crossCurrencyDiscount"></span></th>
                                            <th>idProduct</th>
                                            <th>idFerm</th>
                                            <%--<th>idProductionInvoiceFarm</th>--%>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>

                                <div class="ln_solid"></div>
                                <table class="col-md-4 col-sm-4 col-xs-12 table table-responsive table-bordered" id="farm-invoice-totalPrice" style="float:right">
                                    <tr>
                                        <th>total Price, <span class="fa farm-invoice-mainCurrency"></span>:</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                    <tr>
                                        <th>total Price with discount, <span class="fa farm-invoice-mainCurrencyDiscount"></span> :</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                    <tr>
                                        <th>total Price(cross), <span class="fa farm-invoice-crossCurrency"></span>:</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                    <tr>
                                        <th>total Price(cross) with discount, <span class="fa farm-invoice-crossCurrencyDiscount"></span>:</th>
                                        <td style='font-weight:bold;'></td>
                                    </tr>
                                </table>
                            </form>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="createInvoiceFarm-btn-save">Save changes</button>
                        </div>

                    </div>
                </div>
            </div>
            <div class="modal modal-form fade bs-example-modal-nm" id="editProduct-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="editProduct-modal-tittle">Edit Production to Farm</h4>
                        </div>
                        <div class="modal-body">
                            <form id="editProduction-form" data-parsley-validate class="form-horizontal form-label-left">
                                <input id="position-product-edit" style="display: none">
                                </input>
                                <input id="id-product-edit" style="display: none">
                                </input>
                                <input id="id-farmOfProduct-edit" style="display: none">
                                </input>
                                <%--idProduct: $('#id-product-edit').val(),--%>
                                <%--idFarm:idFarm,--%>
                                <%--product: $('#product-name-edit').val(),--%>
                                <%--grading: $('#product-grading-edit').val(),--%>
                                <%--numberStemsInBox: $('#product-numberStemsInBox-edit').val(),--%>
                                <%--price: $('#product-price-edit').val(),--%>
                                <%--type: $('#product-type-edit').val(),--%>
                                <%--variety: $('#product-variety-edit').val()--%>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-variety">Variety<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input name="variety" id="product-variety-edit" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="product-type-edit">Type<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" name="type" id="product-type-edit">
                                            <option value="STD">STD</option>
                                            <option value="SPRAY">SPRAY</option>
                                        </select>
                                    </div>
                                </div>
                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Type<span class="required">*</span>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                        <%--<input name="type" type="text" id="product-type-edit" required="required" class="form-control col-md-7 col-xs-12">--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-grading">Grading, sm<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input name="grading" type="number" id="product-grading-edit" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-numberStemsInBox">Number Stems in box<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" name="numberStemsInBox" id="product-numberStemsInBox-edit" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="farm-name">Product Name<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" name="product" id="product-name-edit" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Price<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" name="price" step="0.001" id="product-price-edit" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="editProduct-submit">Submit</button>
                        </div>

                    </div>
                </div>
            </div>



            <div class="modal modal-form fade bs-example-modal-nm" id="addProduction-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="addProduction-modal-tittle">Add Production to Farm</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addProduction-form" data-parsley-validate class="form-horizontal form-label-left">
                                <input id="id-farm-foradd" style="display: none">

                                </input>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-variety">Variety<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="product-variety" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="employee-role">Type<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <select class="form-control" name="type" id="product-type">
                                            <option value="STD">STD</option>
                                            <option value="SPRAY">SPRAY</option>
                                        </select>
                                    </div>
                                </div>
                                <%--<div class="form-group">--%>
                                    <%--<label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Type<span class="required">*</span>--%>
                                    <%--</label>--%>
                                    <%--<div class="col-md-6 col-sm-6 col-xs-12">--%>
                                        <%--<input type="text" id="product-type" required="required" class="form-control col-md-7 col-xs-12">--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-grading">Grading, sm<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" id="product-grading" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-numberStemsInBox">Number Stems in box<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" id="product-numberStemsInBox" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-name">Product Name<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="product-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Price<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="number" id="product-price" step="0.001" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>


                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="addProduct-submit">Submit</button>
                        </div>

                    </div>
                </div>
            </div>


            <%--<div class="example-modal fade" id="searchInvoicesFarm-modal">--%>
                <%--<div class="modal">--%>
                    <%--<div class="modal-dialog">--%>
                        <%--<div class="modal-content">--%>
                            <%--<div class="modal-header">--%>
                                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                                    <%--<span aria-hidden="true">&times;</span></button>--%>
                                <%--<h4 class="modal-title">Default Modal</h4>--%>
                            <%--</div>--%>
                            <%--<div class="modal-body">--%>
                                <%--<p>One fine body&hellip;</p>--%>
                            <%--</div>--%>
                            <%--<div class="modal-footer">--%>
                                <%--<button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>--%>
                                <%--<button type="button" class="btn btn-primary">Save changes</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<!-- /.modal-content -->--%>
                    <%--</div>--%>
                    <%--<!-- /.modal-dialog -->--%>
                <%--</div>--%>
                <%--<!-- /.modal -->--%>
            <%--</div>--%>


            <div class="modal modal-form fade bs-example-modal-nm" id="addFarm-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
                <div class="modal-dialog modal-nm">
                    <div class="modal-content">

                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel2">Add new Farm</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addFarm-form" data-parsley-validate class="form-horizontal form-label-left">

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="farm-name">Farm Name<span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <input type="text" id="farm-name" name="farmName" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="radio-div">Currency<span class="required">*</span></label>
                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                        <label class="radio-inline">
                                            USD:
                                            <input type="radio" class="flat radio-inline" name="currency" id="farm-USD" value="USD" checked required="required">
                                        </label>
                                        <label class="radio-inline">
                                            EUR:
                                            <input type="radio" class="flat radio-inline" name="currency" id="farm-EUR" value="EUR" required="required">
                                        </label>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success" id="addFarm-submit">Submit</button>
                        </div>

                    </div>
                </div>
            </div>




            <br/>
        </div>
        <div class="modal modal-form fade bs-example-modal-nm" id="update-profile-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
            <div class="modal-dialog modal-nm">
                <div class="modal-content">

                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" class="place-progress" id="update-profile">Update Profile</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-3">

                                <!-- Profile Image -->
                                <div class="box box-primary">
                                    <div class="box-body box-profile">
                                        <img class="img-responsive" id="preload-profile" src="/admin/getAvatar/${login}"  onerror="this.src='/resources/images/admin.png'" alt="User profile picture">

                                        <h3 class="profile-username text-center"></h3>
                                        <p class="text-muted text-center" profile-username-position></p>
                                    </div>
                                    <input type="file"  name="file" id="fileLoader"  value="browse" onchange="readURL(this);" />
                                    <input type="button" id="fileSubmit" value="change image"/>
                                </div>
                            </div>
                            <!-- /.col -->
                            <div class="col-md-9">
                                <div class="box box-primary" id="profile" class="x_panel">
                                    <div class="box-header">
                                        <i class="fa fa-user"></i>
                                        <h3 class="box-title">Profile</h3>

                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <div class="x_content">
                                            <form id="update-profile-form" data-parsley-validate class="form-horizontal form-label-left">
                                                <%--<input id="update-profile-login" style="display: none" value="${login}">--%>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="profile-name">Name
                                                    </label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" id="profile-name" name="firstname" value ="${firstname}"name="profileName" class="form-control" autocomplete="off">
                                                    </div>
                                                </div>
                                                <p>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-name">Last Name
                                                    </label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" id="profile-lastName" name="lastname" value ="${lastname}" name="profileLastName" class="form-control" autocomplete="off">
                                                    </div>
                                                </div>
                                                <p>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="employee-name">Position
                                                    </label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" id="profile-position" name="position" value ="${position}" name="profileLastName" class="form-control" autocomplete="off">
                                                    </div>
                                                </div>
                                                <p>

                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-success" id="update-profile-submit">Submit</button>
                    </div>

                </div>
            </div>
        </div>

        <%--<section class="content" id="profileDiv" style="display: none">--%>

            <%----%>
        <%--</section>--%>

        <section class="content" id="graphics-content" style="display: none">
            <div class="row">
                <div class="col-md-6">
                    <div class="box box-danger">
                        <div class="box-header with-border">
                            <h3 class="box-title">Donut Chart</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <canvas id="pieChart" style="height:250px"></canvas>
                            <div id="legend" class="chart-legend"></div>
                        </div>
                     </div>
                </div>
                 <div class="col-md-6">
                     <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">Line Chart</h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="chart">
                                <canvas id="lineChart" style="height:250px"></canvas>
                            </div>
                        </div>
                    </div>
                 </div>
             </div>
         </section>
        <!-- Main content -->
        <div id="content-main">
            <section class="content">
                <div class="box box-primary" id="employeeDiv" class="x_panel" style="display: none">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">Employee</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="x_content">
                            <div class="table-responsive">
                                <table id="employee-table" class="table table-hover table-striped table-responsive table-bordered">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>login</th>
                                        <th>first name</th>
                                        <th>last name</th>
                                        <th>position</th>
                                        <th>role</th>
                                        <th>status</th>
                                        <th>edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="nav-tabs-custom" id="invoiceShipmentDiv" style="display: none">
                    <ul id="tab-list" class="nav nav-tabs">
                        <li class="active"><a href="#tabInvoiceShipment" data-toggle="tab">Invoices for Shipment</a></li>
                    </ul>
                    <div class="tab-content" id="tab-content">
                        <div class="tab-pane active" id="tabInvoiceShipment">
                            <div class="box-body">


                                <div class="x_content">


                                    <div class="table-responsive">

                                        <table id="invoiceShipment-table" class="table table-hover table-striped table-responsive jambo_table bulk_action table-bordered">
                                            <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th style="width: 13%">Id</th>
                                                <th style="width: 13%">Name</th>
                                                <th style="width: 13%">Date</th>
                                                <th style="width: 13%">cross usd_eur</th>
                                                <th style="width: 13%">cross eur_usd</th>
                                                <th style="width: 13%">total price usd</th>
                                                <th style="width: 13%">total price eur</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            </tbody>
                                        </table>
                                    </div>


                                </div>

                            </div>
                        </div>

                    </div>
                    <!-- /.tab-content -->
                </div>

                <div class="box box-primary" id="invoiceFarmDiv" class="x_panel" style="display: none">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">Invoices from Farm</h3>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">


                        <div class="x_content">


                            <div class="table-responsive">

                                <table id="invoiceFarm-table" class="table table-hover table-striped table-responsive jambo_table bulk_action table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="width: 5%"></th>
                                        <th style="width: 5%"></th>
                                        <th style="width: 5%">Id</th>
                                        <th style="width: 5%">Farm</th>
                                        <th style="width: 5%">Client</th>
                                        <th style="width: 5%">Name</th>
                                        <th style="width: 5%">Date</th>
                                        <th style="width: 5%">Currency</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>


                        </div>

                    </div>
                </div>
                <div class="box box-primary" id="invoiceCommercialDiv" class="x_panel" style="display: none">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">Commercial Invoices</h3>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">


                        <div class="x_content">


                            <div class="table-responsive">

                                <table id="invoiceCommerce-table" class="table table-hover table-striped table-responsive jambo_table bulk_action table-bordered">
                                    <thead>
                                    <tr>

                                        <th style="width: 5%"></th>

                                        <th style="width: 5%">id</th>
                                        <th style="width: 5%">name</th>
                                        <th style="width: 5%">date</th>
                                        <th style="width: 5%">terms net</th>
                                        <th style="width: 5%">agent</th>
                                        <th style="width: 5%">mod of transport</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>


                        </div>

                    </div>
                </div>
                <div class="box box-primary" id="farmTableDiv" class="x_panel" style="display: none">
                    <div class="box-header">
                        <i class="ion ion-clipboard"></i>
                        <h3 class="box-title">Table Farms</h3>

                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">


                        <div class="x_content">


                            <div class="table-responsive">

                                <table id="farmTable" class="table table-hover table-striped table-responsive jambo_table bulk_action table-bordered">
                                    <thead>
                                    <tr>
                                        <th style="width: 5%"></th>
                                        <th style="width: 5%">Id</th>
                                        <th style="width: 5%">Farm</th>
                                        <th style="width: 5%">Currency</th>
                                        <th style="min-width: 25%">Edit</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                </table>
                            </div>


                        </div>

                    </div>
                </div>
            </section>
        </div>


    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">

        </div>

    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->

        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">


            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">

            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>

</div>
<div id="shipment-invoice-html" style="display: none">
    <div class="row">
        <div class="col-xs-12">
            <h2 class="page-header">
               <i class="fa fa-globe"></i> Commercial Invoice
                <a type="button" id="generate-commercial" onClick="a_onClick()" href="#" class="btn btn-primary pull-right" style="margin-right: 5px;">
                <i class="fa fa-file-excel-o"></i> generate Commercial
                </a>
                    <%--<small class="pull-right">Date: <span class="tab-shipment-date"></span></small>--%>
            </h2>
        </div>
        <!-- /.col -->
    </div>
    <!-- info row -->
    <div class="row invoice-info">
        <div class="col-sm-6 invoice-col">

            <table id="consigne" class="table table-striped">
                <thead>
                <tr>
                <th>Consigne:</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                </tbody>

            </table>
        </div>
        <!-- /.col -->
        <div class="col-sm-6">
            <div class="table-responsive">

                <table id="commercial-tableH1" class="table table-striped">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <th>Date:</th>
                        <td><input class="form-control col-md-8 col-xs-12 tab-shipment-date"></td>
                    </tr>
                    <tr>
                        <th>COMMERCIAL INVOICE NO.:</th>
                        <td><input class="form-control col-md-8 col-xs-12 tab-shipment-invoice"></td>
                    </tr>
                    <tr>
                        <th>TERMS NET</th>
                        <td><input class="form-control col-md-8 col-xs-12"></td>
                    </tr>
                    <tr>
                        <th>AGENT</th>
                        <td><input class="form-control col-md-8 col-xs-12"></td>
                    </tr>
                    <tr>
                        <th>MOD OF TRANSPORT</th>
                        <td><input class="form-control col-md-8 col-xs-12"></td>
                    </tr>
                    </tbody>

                </table>
            </div>
            <div class="table-responsive">
            <table id="commercial-tableH2" class="table table-striped">
                <thead></thead>
                <tbody>
                <tr>
                    <th>FLT NO.:</th>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <th>MAWB:</th>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                <tr>
                    <th>AWB:</th>
                    <td><input class="form-control col-md-8 col-xs-12"></td>
                </tr>
                </tbody>
            </table>
            </div>
            <div class="table-responsive">
            <table class="table table-striped">
                <thead></thead>
                <tbody>
                <tr>
                    <th>Commision per Stem:</th>
                    <td><input id="commisionPerStem" class="form-control col-md-8 col-xs-12"></td>
                </tr>
                </tbody>
            </table>
            </div>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col">


        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
<br>
    <!-- Table row -->

    <div class="row">
        <div class="col-xs-12 table-responsive">
            <table class="table table-striped tab-shipment-invoice-table">
                <thead>
                <tr>
                    <th data-override="variety">variety</th>
                    <th data-override="countBox">boxes</th>
                    <th data-override="count">stems</th>
                    <th data-override="total">total</th>
                    <th data-override="totalCross">total Cross</th>

                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
     </div>

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="resources/adminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>

<!-- Bootstrap 3.3.6 -->
<script src="resources/adminLTE/bootstrap/js/bootstrap.min.js"></script>


<!-- Sparkline -->
<script src="resources/adminLTE/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="resources/adminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="resources/adminLTE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="resources/adminLTE/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="resources/adminLTE/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="resources/adminLTE/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="resources/adminLTE/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="resources/adminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="resources/adminLTE/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resources/adminLTE/dist/js/app.min.js"></script>

<!-- AdminLTE for demo purposes -->
<script src="resources/adminLTE/dist/js/demo.js"></script>
<link href="resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/select2/dist/css/select2.css" rel="stylesheet">

<script src="resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"></script>
<script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
<script src="resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="resources/vendors/parsleyjs/dist/parsley.min.js"></script>
<script src="resources/js/dataTables.cellEdit.js"></script>
<script src="resources/vendors/iCheck/icheck.min.js"></script>
<script src="resources/vendors/nprogress/nprogress.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="resources/adminLTE/plugins/chartjs/Chart.js"></script>
<script src="resources/build/js/custom.js"></script>

<script src="//kendo.cdn.telerik.com/2016.3.914/js/kendo.all.min.js"></script>
<script src="resources/js/pdf/html2canvas.js"></script>
<script src="resources/js/pdf/jspdf.min.js"></script>
<script src="resources/js/pdf/from_html.js"></script>
<script src="resources/js/pdf/split_text_to_size.js"></script>
<script src="resources/js/pdf/standard_fonts_metrics.js"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.1.3/Chart.js"></script>--%>
<script src="resources/js/functions.js"></script>
<script src="resources/js/FileSaver.js"></script>
<script src="resources/js/project.js"></script>
<script src="resources/js/dataTables.cellEdit.js"></script>
<script src="resources/js/sum().js"></script>
<script src="resources/js/jquery.tabletojson.js"></script>
<script src="resources/vendors/select2/dist/js/select2.js"></script>

<%--<script src="resources/adminLTE/plugins/chartjs/dist/Chart.js"></script>--%>
<%--<script src="resources/vendors/select2/dist/js/select2.js"></script>--%>
<script>function readURL(input){
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#preload-profile')
                .attr('src', e.target.result);

        };

        reader.readAsDataURL(input.files[0]);
    }
}</script>
<style type="text/css">
    .blockDiv {
        position: absolute;
        top: 0px;
        left: 0px;
        background-color: #FFF;
        width: 0px;
        height: 0px;
        z-index: 10;
    }
    .modal {
        /*position: relative;*/
        /*top: auto;*/
        /*bottom: auto;*/
        /*right: auto;*/
        /*left: auto;*/
        /*display: block;*/
        z-index: 100000000;
    }
    .daterangepicker{
        /*overflow-x: scroll;*/
        overflow: visible;
        position:absolute;
        height: 350px;
        max-height: 500px;
        /*width: 100%;*/
        overflow-y: scroll;
        -webkit-overflow-scrolling:touch;
        z-index: 1000000000 !important;
    }
    /*.modal {*/
        /*background: transparent !important;*/
    /*}*/
    .spinner {
        left: 50%;
        margin-left: -4em;
        color: red;
    }
    td.details-control {
        position:relative;
    }
    td.show-invoice:before {
        content: "\f14c";
        margin: 5px 5px 5px 5px;
        font-family: FontAwesome;
        font-size:150%;
        top:0;
        cursor: pointer;
    }
    tr.shownInv td.show-invoice:before {
        content: "\f14c";
        margin: 5px 5px 5px 5px;
        font-size:150%;
        opacity: 0.5;
        font-family: FontAwesome;
        top:0;
    }
    td.details-control:before {
        content: "\f138";
        margin: 5px 5px 5px 5px;
        font-family: FontAwesome;
        font-size:150%;
        /*left:5px;*/
        /*right:5px;*/
        /*position:absolute;*/
        top:0;
        /*background: url('/resources/images/chevron-circle-right.png') no-repeat center!important;*/
        cursor: pointer;
    }
    tr.shown td.details-control:before {
        content: "\f13a";
        margin: 5px 5px 5px 5px;
        font-size:150%;
        font-family: FontAwesome;
        /*left:5px;*/
        /*right:5px;*/
        /*position:absolute;*/
        top:0;
        /*background: url('/resources/images/chevron-circle-down.png') no-repeat center!important;*/
    }
</style>

<link href="resources/css/project.css" rel="stylesheet">
<style>

    .doughnut-legend li span{
        display: inline-block;
        width: 12px;
        height: 12px;
        margin-right: 5px;
    }
    .doughnut-legend {
        list-style: none;
    }
    #tab-list .close {
        margin-left: 7px;
    }
    .text_editor {
        border: none;
        /*background: #ddd;*/
        color: #000;
        font-size: 14px;
        font-family: arial;
        width: 200px;
        cursor: text;
    }
</style>
</body>
</html>

