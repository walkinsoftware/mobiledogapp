<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Admin DashBoard</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>

<!-- Date picker -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/jquery.datepick.css">
<script type="text/javascript" src="assets/js/jquery.plugin.js"></script>
<script type="text/javascript" src="assets/js/jquery.datepick.js"></script>

<!-- date picker Ends -->
<!-- Calender Start -->
<link href="assets/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/semantic.min.css" rel="stylesheet"
	type="text/css" />
<script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="assets/js/semantic.min.js"></script>
<!-- Calender ENds -->
<!-- Favicon-->
<link rel="icon" href="../../favicon.ico" type="image/x-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" type="text/css">

<!-- Bootstrap Core Css -->
<link href="admin/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="admin/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="admin/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- JQuery DataTable Css -->
<link
	href="admin/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- Custom Css -->
<link href="admin/css/style.css" rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="admin/css/themes/all-themes.css" rel="stylesheet" />
</head>
<body class="theme-red">
	<!-- Page Loader -->
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="preloader">
				<div class="spinner-layer pl-red">
					<div class="circle-clipper left">
						<div class="circle"></div>
					</div>
					<div class="circle-clipper right">
						<div class="circle"></div>
					</div>
				</div>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<!-- #END# Page Loader -->
	<!-- Overlay For Sidebars -->
	<div class="overlay"></div>
	<!-- #END# Overlay For Sidebars -->
	<!-- Search Bar -->
	<div class="search-bar">
		<div class="search-icon">
			<i class="material-icons">search</i>
		</div>
		<input type="text" placeholder="START TYPING...">
		<div class="close-search">
			<i class="material-icons">close</i>
		</div>
	</div>
	<!-- #END# Search Bar -->
	<!-- Top Bar -->
	<nav class="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="javascript:void(0);" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-collapse"
				aria-expanded="false"></a> <a href="javascript:void(0);"
				class="bars"></a> <a class="navbar-brand" href="index.html">Report
				Dashboard</a>
		</div>
		
	</div>
	</nav>
	<!-- #Top Bar -->
	<section> <!-- Left Sidebar --> <aside id="leftsidebar"
		class="sidebar"> <!-- User Info -->
	<div class="user-info">
		<div class="image">
		</div>
		
	</div>
	<!-- #User Info --> <!-- Menu -->
	<div class="menu">
		<ul class="list">
			<li class="header">MAIN NAVIGATION</li>
			<li><a href="Report.jsp"> <i class="material-icons"></i> <span></span>
			</a></li>


			<li class="active"><a href="javascript:void(0);"
				class="menu-toggle"> <i class="material-icons">view_list</i> <span>Report</span>
			</a>
				<ul class="ml-menu">

					<li class=""><a href="./adminDashboard">Back</a></li>

				</ul></li>
	</div>
	<!-- #Menu --> <!-- Footer -->
	<div class="legal">
		<div class="copyright">
			&copy; 2018 - 2019 <a href="javascript:void(0);">Walkin Software
				Technologies PVT LTD</a>.
		</div>
		<div class="version">
			<b>Version: </b> 1.0.5
		</div>
	</div>
	<!-- #Footer --> </aside> <!-- #END# Left Sidebar --> <!-- Right Sidebar --> <!-- #END# Right Sidebar -->
	</section>

	<section class="content">
	<div class="container-fluid">

		<div class="block-header">
			<h2>Mobile Dog user Report</h2>
		</div>
		<!-- Basic Examples -->


		<<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<div class="body">

						 <table class="table table-bordered table-striped table-hover dataTable js-exportable"><br><br>
                                    <thead>
                                        <tr>
                                            <th>id</th>
			<th>fullName</th>
			<th>userName</th>
			<th>emailId</th>
			<th>mobileNumber</th>
			<th>barcode</th>
			<th>Action</th>
                                            
                                        </tr>
                                    </thead>
									
									<c:forEach items="${userDetailsList}" var="user"
										varStatus="tagStatus">
										<tr>
											<td>${user.id}</td>
											<td>${user.fullName}</td>
											<td>${user.userName}</td>
											<td>${user.emailId}</td>
											<td>${user.mobileNumber}</td>
											<td>${user.barcode}</td>
											<td>${user.isActive}</td>

										</tr>
									</c:forEach>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Exportable Table -->
	</div>
	</section>

	<!-- Jquery Core Js -->
	<script src="admin/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="admin/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Select Plugin Js -->
	<script src="admin/plugins/bootstrap-select/js/bootstrap-select.js"></script>

	<!-- Slimscroll Plugin Js -->
	<script src="admin/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="admin/plugins/node-waves/waves.js"></script>

	<!-- Jquery DataTable Plugin Js -->
	<script src="admin/plugins/jquery-datatable/jquery.dataTables.js"></script>
	<script
		src="admin/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
	<script
		src="admin./plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
	<script
		src="admin/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

	<!-- Custom Js -->
	<script src="admin/js/admin.js"></script>
	<script src="admin/js/pages/tables/jquery-datatable.js"></script>

	<!-- Demo Js -->
	<script src="admin/js/demo.js"></script>
	<script src="assets/js/myjs.js"></script>

</body>

</html>