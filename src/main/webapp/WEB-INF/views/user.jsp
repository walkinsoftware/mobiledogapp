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
<title>User DashBoard</title>
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
<link href="Admin/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Waves Effect Css -->
<link href="Admin/plugins/node-waves/waves.css" rel="stylesheet" />

<!-- Animation Css -->
<link href="Admin/plugins/animate-css/animate.css" rel="stylesheet" />

<!-- JQuery DataTable Css -->
<link
	href="Admin/plugins/jquery-datatable/skin/bootstrap/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- Custom Css -->
<link href="Admin/css/style.css" rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="Admin/css/themes/all-themes.css" rel="stylesheet" />
</head>
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
				class="bars"></a> <a class="navbar-brand" href="index.html">User
				Dashboard</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse"></div>
	</div>
	</nav>
	<!-- #Top Bar -->
	<section> <!-- Left Sidebar --> <aside id="leftsidebar"
		class="sidebar"> <!-- User Info -->
	<div class="user-info">
		<div class="image">
			<img src="../../images/user.png" width="48" height="48" alt="User" />
		</div>
		<div class="info-container">
			<div class="name" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">John Doe</div>
			<div class="email">john.doe@example.com</div>
			<div class="btn-group user-helper-dropdown">
				<i class="material-icons" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
				<ul class="dropdown-menu pull-right">
					<li><a href="javascript:void(0);"><i
							class="material-icons">person</i>Profile</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="javascript:void(0);"><i
							class="material-icons">group</i>Followers</a></li>
					<li><a href="javascript:void(0);"><i
							class="material-icons">shopping_cart</i>Sales</a></li>
					<li><a href="javascript:void(0);"><i
							class="material-icons">favorite</i>Likes</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="javascript:void(0);"><i
							class="material-icons">input</i>Sign Out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- #User Info --> <!-- Menu -->
	<div class="menu">
		<ul class="list">
			<li class="header">MAIN NAVIGATION</li>
			<li><a href="Report.jsp"> <i class="material-icons"></i> <span>Home</span>
			</a></li>


			<li class="active"><a href="javascript:void(0);"
				class="menu-toggle"> <i class="material-icons">view_list</i>
					<li><a
						href="./queryUsersTrackingDetails?mobileNumber=${loginUser.mobileNumber}">Report</a></li>
					<li><a
						href="./queryUserDetailsListByName?userName=&mobileNumber=">SimRemovel</a></li>
					<li><a
						href="./queryUserDetailsListByName?userName=&mobileNumber=">Emergency</a></li></li>
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
			<h2>Track Your Location By Longitude and Lattitude</h2>
		</div>
		<!-- Basic Examples -->



		<section id="rep">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<div class="body">
						<div class="table-responsive">
							<h3
								style="font-family: Times New Roman; color: darkcyan; text-align: center;">Track
								User Details</h3>

							<table
								class="table table-bordered table-striped table-hover dataTable js-exportable">
								<br>
								<thead>
									<tr>
										<th>ID</th>
										<th>LONGITUDE</th>
										<th>LATTITUDE</th>
										<th>DATE&TIME</th>
										<th>Action</th>

									</tr>
								</thead>

								<tr>
									<td>001</td>
									<td>77.5540185</td>
									<td>12.9847091</td>
									<td>Sat Jul 13 2019 19:02:05</td>
									<td><a href="loginuser?id"
										class="btn btn-success btn-rounded" style="margin: 2px;">View
											Map</a></td>


								</tr>



								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>

		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<h3
						style="font-family: Times New Roman; color: darkcyan; text-align: center;">Map
						View</h3>

				</div>
			</div>
		</div>
		<section id="emrgency">
		<div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="card">

					<div class="body">
						<div class="table-responsive">
							<h3
								style="font-family: Times New Roman; color: darkcyan; text-align: center;">Emergency</h3>

							<p>${msg}</p>
							<p>${errmsg}</p>
							<table width="50%">
								<tr>
									<th>id</th>
									<th>longitude</th>
									<th>latitude</th>
									<th>insertedTime</th>
								</tr>
								<c:forEach items="${usersTrackingDetails}" var="user"
									varStatus="tagStatus">
									<tr>
										<td>${user.id}</td>
										<td>${user.longitude}</td>
										<td>${user.lattitude}</td>
										<td>${user.insertedTime}</td>
									</tr>
								</c:forEach>
							</table>

							</br>
							<table width="50%">
								<tr>
									<th>id</th>
									<th>longitude</th>
									<th>latitude</th>
									<th>insertedTime</th>
									<th>Image</th>
								</tr>
								<c:forEach items="${simRemovalDtos}" var="user"
									varStatus="tagStatus">
									<tr>
										<td>${user.id}</td>
										<td>${user.longitude}</td>
										<td>${user.lattitude}</td>
										<td>${user.insertedDate}</td>
										<td><img width="50%" height="30%" alt="user Image" src="data:image/jpeg;base64,${user.imageStr}"></td>
									</tr>
								</c:forEach>
							</table>
							
							</br>
							<table width="50%">
								<tr>
									<th>id</th>
									<th>longitude</th>
									<th>latitude</th>
									<th>insertedTime</th>
									<th>Image</th>
								</tr>
								<c:forEach items="${emergenceDetails}" var="user"
									varStatus="tagStatus">
									<tr>
										<td>${user.id}</td>
										<td>${user.longitude}</td>
										<td>${user.lattitude}</td>
										<td>${user.insertedDate}</td>
										<td><img alt="${user.image}" src="${user.image}"></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
		<!-- #END# Exportable Table -->
	</div>
	</section>

	<!-- Jquery Core Js -->
	<script src="Admin/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script src="Admin/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Select Plugin Js -->
	<script src="Admin/plugins/bootstrap-select/js/bootstrap-select.js"></script>

	<!-- Slimscroll Plugin Js -->
	<script src="Admin/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script src="Admin/plugins/node-waves/waves.js"></script>

	<!-- Jquery DataTable Plugin Js -->
	<script src="Admin/plugins/jquery-datatable/jquery.dataTables.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
	<script
		src="Admin./plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
	<script
		src="Admin/plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

	<!-- Custom Js -->
	<script src="Admin/js/admin.js"></script>
	<script src="Admin/js/pages/tables/jquery-datatable.js"></script>

	<!-- Demo Js -->
	<script src="Admin/js/demo.js"></script>
	<script src="assets/js/myjs.js"></script>

</body>
</html>