<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Admin Page </title>

    <!-- Bootstrap -->
    <link href="resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- bootstrap-progressbar -->
    <link href="resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="resources/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="resources/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="resources/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="resources/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <%--<link href="https://cdn.datatables.net/select/1.2.1/css/select.dataTables.min.css" rel="stylesheet">--%>
    <link href="resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="resources/build/css/custom.css" rel="stylesheet">
    <link href="resources/css/project.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="resources/css/datepicker.css">--%>
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

        .spinner {
            left: 50%;
            margin-left: -4em;
        }
    </style>
</head>

<body class="nav-md">
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
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="radio-div">Currency<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12" id="radio-div">
                            <label class="radio-inline">
                                USD:
                                <input type="radio" class="flat radio-inline" name="farmEditCurrency" id="farm-editUSD" value="USD" checked required="required">
                            </label>
                            <label class="radio-inline">
                                EUR:
                                <input type="radio" class="flat radio-inline" name="farmEditCurrency" id="farm-editEUR" value="EUR" required="required">
                            </label>
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
                                 <div class="control-group">
                                        <div class="controls">
                                            <div class="col-md-12 ">
                                                <input type="text" class="form-control has-feedback-left" id="invoiceFarm-name" placeholder="Invoice Name">
                                                <span class="fa fa-list-alt form-control-feedback left" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-12">
                            Client Name

                                    <div class="control-group">
                                        <div class="controls">
                                            <div class="col-md-12">
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-clientName" placeholder="Client Name">
                                            <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                            </div>
                                        </div>
                                    </div>

                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-12">
                           Invoice Date
                                 <fieldset>
                                    <div class="control-group">
                                        <div class="controls">
                                            <div class="col-md-12">
                                                <input type="text" class="form-control has-feedback-left" id="invoiceFarm-date" placeholder="First Name" aria-describedby="inputSuccess2Status4">
                                                <span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>
                                                <span id="inputSuccess2Status4" class="sr-only">(success)</span>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-12">
                            Cross Curs
                            <fieldset>
                                <div class="control-group">
                                    <div class="controls">
                                        <div class="col-md-12">
                                            <input type="text" class="form-control has-feedback-left" id="invoiceFarm-crossCurs" placeholder="Cross Curs">
                                            <span class="fa form-control-feedback left" id="invoiceFarm-currencyOther" aria-hidden="true"></span>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                    </div>
                    <div class="clearfix"></div>
                    </div>
                    <div class="ln_solid"></div>

                    <table id="table-farm-invoice" class="table table-responsive table-striped jambo_table bulk_action table-bordered">

                        <thead>
                        <tr>
                            <th style="width: 12%">product</th>
                            <th style="width: 12%">grading</th>
                            <th style="width: 12%">number stems in Box</th>
                            <th style="width: 12%">price, <span class="fa farm-invoice-mainCurrency"></span></th>
                            <th style="width: 12%">price(discount), <span class="fa farm-invoice-mainCurrencyDiscount"></span></th>
                            <th style="width: 12%">discount, %</th>
                            <th style="width: 12%">price(cross), <span class="fa farm-invoice-crossCurrency"></span></th>
                            <th style="width: 12%">price(discount cross), <span class="fa farm-invoice-crossCurrencyDiscount"></span></th>
                            <th>idProduct</th>
                            <th>idFerm</th>
                        </tr>
                        </thead>
                    </table>
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
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="farm-name">Product Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-name-edit" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-grading">Grading<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="product-grading-edit" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-numberStemsInBox">Number Stems in box<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="product-numberStemsInBox-edit" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Price<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="money" id="product-price-edit" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Type<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-type-edit" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-variety">Variety<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-variety-edit" required="required" class="form-control col-md-7 col-xs-12">
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="farm-name">Product Name<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-grading">Grading<span class="required">*</span>
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Price<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="number" id="product-price" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-price">Type<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-type" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product-variety">Variety<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="product-variety" required="required" class="form-control col-md-7 col-xs-12">
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
                            <input type="text" id="farm-name" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="radio-div">Currency<span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <label class="radio-inline">
                                USD:
                                <input type="radio" class="flat radio-inline" name="farmCurrency" id="farm-USD" value="USD" checked required="required">
                            </label>
                            <label class="radio-inline">
                                EUR:
                                <input type="radio" class="flat radio-inline" name="farmCurrency" id="farm-EUR" value="EUR" required="required">
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
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a class="site_title"><span>Lakshmi Group</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="resources/images/serg.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>Serg</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">

                                </ul>
                            </li>


                            <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a onclick="getFarm();">Farm</a></li>
                                    <li><a>Production</a></li>

                                </ul>
                            </li>
                            <li><a><i class="fa fa-list"></i> Invoices <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a onclick="invoiceFromFarm();">from Farm</a></li>
                                    <li><a>to Client</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">

                                </ul>
                            </li>

                        </ul>
                    </div>
                    <div class="menu_section">
                        <h3>Live On</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-bug"></i> Additional Pages <span
                                    class="fa fa-chevron-down"></span></a>

                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="resources/images/serg.png" alt="">Serg
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                                <li><a href="javascript:;"> Profile</a></li>
                                <li>
                                    <a href="javascript:;">
                                        <span class="badge bg-red pull-right">50%</span>
                                        <span>Settings</span>
                                    </a>
                                </li>
                                <li><a href="javascript:;">Help</a></li>
                                <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                            </ul>
                        </li>


                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main" id="main">
         <div>
             <%--<div class="row">--%>
             <%--<div class="col-md-12">--%>
             <%--<div class="x_panel">--%>
             <%--<div class="x_title">--%>
             <%--<h2>Invoice Design <small>Sample user invoice design</small></h2>--%>
             <%--<ul class="nav navbar-right panel_toolbox">--%>
             <%--<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>--%>
             <%--</li>--%>
             <%--<li class="dropdown">--%>
             <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>--%>
             <%--<ul class="dropdown-menu" role="menu">--%>
             <%--<li><a href="#">Settings 1</a>--%>
             <%--</li>--%>
             <%--<li><a href="#">Settings 2</a>--%>
             <%--</li>--%>
             <%--</ul>--%>
             <%--</li>--%>
             <%--<li><a class="close-link"><i class="fa fa-close"></i></a>--%>
             <%--</li>--%>
             <%--</ul>--%>
             <%--<div class="clearfix"></div>--%>
             <%--</div>--%>
             <%--<div class="x_content">--%>

             <%--<section class="content invoice">--%>
             <%--<!-- title row -->--%>
             <%--<div class="row">--%>
             <%--<div class="col-xs-12 invoice-header">--%>
             <%--<h1>--%>
             <%--<i class="fa fa-globe"></i> Invoice.--%>
             <%--<small class="pull-right">Date: 16/08/2016</small>--%>
             <%--</h1>--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--</div>--%>
             <%--<!-- info row -->--%>
             <%--<div class="row invoice-info">--%>
             <%--<div class="col-sm-4 invoice-col">--%>
             <%--From--%>
             <%--<address>--%>
             <%--<strong>Iron Admin, Inc.</strong>--%>
             <%--<br>795 Freedom Ave, Suite 600--%>
             <%--<br>New York, CA 94107--%>
             <%--<br>Phone: 1 (804) 123-9876--%>
             <%--<br>Email: ironadmin.com--%>
             <%--</address>--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--<div class="col-sm-4 invoice-col">--%>
             <%--To--%>
             <%--<address>--%>
             <%--<strong>John Doe</strong>--%>
             <%--<br>795 Freedom Ave, Suite 600--%>
             <%--<br>New York, CA 94107--%>
             <%--<br>Phone: 1 (804) 123-9876--%>
             <%--<br>Email: jon@ironadmin.com--%>
             <%--</address>--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--<div class="col-sm-4 invoice-col">--%>
             <%--<b>Invoice #007612</b>--%>
             <%--<br>--%>
             <%--<br>--%>
             <%--<b>Order ID:</b> 4F3S8J--%>
             <%--<br>--%>
             <%--<b>Payment Due:</b> 2/22/2014--%>
             <%--<br>--%>
             <%--<b>Account:</b> 968-34567--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--</div>--%>
             <%--<!-- /.row -->--%>

             <%--<!-- Table row -->--%>
             <%--<div class="row">--%>
             <%--<div class="col-xs-12 table">--%>
             <%--<div class="table-responsive">--%>
             <%--<table class="table table-striped">--%>
             <%--<thead>--%>
             <%--<tr>--%>
             <%--<th>Qty</th>--%>
             <%--<th>Product</th>--%>
             <%--<th>Serial #</th>--%>
             <%--<th style="width: 59%">Description</th>--%>
             <%--<th>Subtotal</th>--%>
             <%--</tr>--%>
             <%--</thead>--%>
             <%--<tbody>--%>
             <%--<tr>--%>
             <%--<td>1</td>--%>
             <%--<td>Call of Duty</td>--%>
             <%--<td>455-981-221</td>--%>
             <%--<td>El snort testosterone trophy driving gloves handsome gerry Richardson helvetica tousled street art master testosterone trophy driving gloves handsome gerry Richardson--%>
             <%--</td>--%>
             <%--<td>$64.50</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<td>1</td>--%>
             <%--<td>Need for Speed IV</td>--%>
             <%--<td>247-925-726</td>--%>
             <%--<td>Wes Anderson umami biodiesel</td>--%>
             <%--<td>$50.00</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<td>1</td>--%>
             <%--<td>Monsters DVD</td>--%>
             <%--<td>735-845-642</td>--%>
             <%--<td>Terry Richardson helvetica tousled street art master, El snort testosterone trophy driving gloves handsome letterpress erry Richardson helvetica tousled</td>--%>
             <%--<td>$10.70</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<td>1</td>--%>
             <%--<td>Grown Ups Blue Ray</td>--%>
             <%--<td>422-568-642</td>--%>
             <%--<td>Tousled lomo letterpress erry Richardson helvetica tousled street art master helvetica tousled street art master, El snort testosterone</td>--%>
             <%--<td>$25.99</td>--%>
             <%--</tr>--%>
             <%--</tbody>--%>
             <%--</table>--%>
             <%--</div>--%>

             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--</div>--%>
             <%--<!-- /.row -->--%>

             <%--<div class="row">--%>
             <%--<!-- accepted payments column -->--%>
             <%--<div class="col-xs-6">--%>
             <%--<p class="lead">Payment Methods:</p>--%>
             <%--<img src="images/visa.png" alt="Visa">--%>
             <%--<img src="images/mastercard.png" alt="Mastercard">--%>
             <%--<img src="images/american-express.png" alt="American Express">--%>
             <%--<img src="images/paypal.png" alt="Paypal">--%>
             <%--<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">--%>
             <%--Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra.--%>
             <%--</p>--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--<div class="col-xs-6">--%>
             <%--<p class="lead">Amount Due 2/22/2014</p>--%>
             <%--<div class="table-responsive">--%>
             <%--<table class="table">--%>
             <%--<tbody>--%>
             <%--<tr>--%>
             <%--<th style="width:50%">Subtotal:</th>--%>
             <%--<td>$250.30</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<th>Tax (9.3%)</th>--%>
             <%--<td>$10.34</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<th>Shipping:</th>--%>
             <%--<td>$5.80</td>--%>
             <%--</tr>--%>
             <%--<tr>--%>
             <%--<th>Total:</th>--%>
             <%--<td>$265.24</td>--%>
             <%--</tr>--%>
             <%--</tbody>--%>
             <%--</table>--%>
             <%--</div>--%>
             <%--</div>--%>
             <%--<!-- /.col -->--%>
             <%--</div>--%>
             <%--<!-- /.row -->--%>

             <%--<!-- this row will not appear when printing -->--%>
             <%--<div class="row no-print">--%>
             <%--<div class="col-xs-12">--%>
             <%--<button class="btn btn-default" onclick="window.print();"><i class="fa fa-print"></i> Print</button>--%>
             <%--<button class="btn btn-success pull-right"><i class="fa fa-credit-card"></i> Submit Payment</button>--%>
             <%--<button class="btn btn-primary pull-right" style="margin-right: 5px;"><i class="fa fa-download"></i> Generate PDF</button>--%>
             <%--</div>--%>
             <%--</div>--%>
             <%--</section>--%>
             <%--</div>--%>
             <%--</div>--%>
             <%--</div>--%>
             <%--</div>--%>
         </div>



            <div id="invoiceFarmDiv" class="x_panel" style="display: none">
                <div class="x_title">
                    <h2>Invoices from Farm</h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Settings 1</a>
                                </li>
                                <li><a href="#">Settings 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                        Here you can see the Invoices from Farm
                    </p>
                    <div class="table-responsive">


                    </div>


                </div>
            </div>
            <div id="farmTableDiv" class="x_panel" style="display: none">
                <div class="x_title">
                    <h2>Table Farms </h2>
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false"><i class="fa fa-wrench"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Settings 1</a>
                                </li>
                                <li><a href="#">Settings 2</a>
                                </li>
                            </ul>
                        </li>
                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                        Here you can see the names of farms
                    </p>
                    <div class="table-responsive">

                    <table id="farmTable" class="table table-striped table-responsive jambo_table bulk_action table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 5%"></th>
                            <th style="width: 5%">Id</th>
                            <th style="width: 75%">Farm</th>
                            <th style="width: 75%">Currency</th>
                            <th style="min-width: 15%">Edit</th>
                        </tr>
                        </thead>
                    </table>
                    </div>


                </div>
            </div>


            <!-- top tiles -->


            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">

                </div>

            </div>
            <br/>


        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Lakshmi Group
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="resources/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="resources/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="resources/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="resources/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="resources/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="resources/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="resources/vendors/Flot/jquery.flot.js"></script>
<script src="resources/vendors/Flot/jquery.flot.pie.js"></script>
<script src="resources/vendors/Flot/jquery.flot.time.js"></script>
<script src="resources/vendors/Flot/jquery.flot.stack.js"></script>
<script src="resources/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="resources/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="resources/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="resources/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="resources/vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="resources/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="resources/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="resources/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="resources/vendors/moment/min/moment.min.js"></script>
<script src="resources/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<link href="resources/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="resources/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

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
<script src="resources/vendors/pnotify/dist/pnotify.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.buttons.js"></script>
<%--<script src="https://cdn.datatables.net/select/1.2.1/js/dataTables.select.min.js"></script>--%>
<script src="resources/vendors/iCheck/icheck.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="resources/build/js/custom.js"></script>
<script src="resources/js/project.js"></script>
<script src="resources/js/dataTables.cellEdit.js"></script>
<script src="resources/js/sum().js"></script>
<script src="resources/js/jquery.tabletojson.js"></script>
<%--<script type="text/javascript" src="resources/js/bootstrap-datepicker.js"></script>--%>
<script type="text/javascript" language="javascript">


</script>
</body>
</html>
