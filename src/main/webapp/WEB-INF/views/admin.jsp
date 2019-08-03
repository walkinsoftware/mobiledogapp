<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>MobileDog Admin DashBoard</title>
<!-- Favicon-->
<link rel="icon" href="favicon.ico" type="image/x-icon">

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

<!-- Morris Chart Css-->
<link href="Admin/plugins/morrisjs/morris.css" rel="stylesheet" />

<!-- Custom Css -->
<link href="Admin/css/style.css" rel="stylesheet">

<!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
<link href="Admin/css/themes/all-themes.css" rel="stylesheet" />
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

	${adminDashboardDetails} ${adminDashboardDetails.totalUsers}
	${adminDashboardDetails.totalRejectedUsers}
	${adminDashboardDetails.totalActiveUsers}
	${adminDashboardDetails.totalRegisteredUsers}

	<!-- #END# Search Bar -->
	<!-- Top Bar -->
	<nav class="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="javascript:void(0);" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-collapse"
				aria-expanded="false"></a> <a href="javascript:void(0);"
				class="bars"></a> <a class="navbar-brand" href="index.html">ADMIN
				DASHBOARD</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<!-- Call Search -->
				<li><a href="javascript:void(0);" class="js-search"
					data-close="true"><i class="material-icons">search</i></a></li>
				<!-- #END# Call Search -->
				<!-- Notifications -->
				<li class="dropdown"><a href="javascript:void(0);"
					class="dropdown-toggle" data-toggle="dropdown" role="button"> <i
						class="material-icons">notifications</i> <span class="label-count">7</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">NOTIFICATIONS</li>
						<li class="body">
							<ul class="menu">
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-light-green">
											<i class="material-icons">person_add</i>
										</div>
										<div class="menu-info">
											<h4>12 new members joined</h4>
											<p>
												<i class="material-icons">access_time</i> 14 mins ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-cyan">
											<i class="material-icons">add_shopping_cart</i>
										</div>
										<div class="menu-info">
											<h4>4 sales made</h4>
											<p>
												<i class="material-icons">access_time</i> 22 mins ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-red">
											<i class="material-icons">delete_forever</i>
										</div>
										<div class="menu-info">
											<h4>
												<b>Nancy Doe</b> deleted account
											</h4>
											<p>
												<i class="material-icons">access_time</i> 3 hours ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-orange">
											<i class="material-icons">mode_edit</i>
										</div>
										<div class="menu-info">
											<h4>
												<b>Nancy</b> changed name
											</h4>
											<p>
												<i class="material-icons">access_time</i> 2 hours ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-blue-grey">
											<i class="material-icons">comment</i>
										</div>
										<div class="menu-info">
											<h4>
												<b>John</b> commented your post
											</h4>
											<p>
												<i class="material-icons">access_time</i> 4 hours ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-light-green">
											<i class="material-icons">cached</i>
										</div>
										<div class="menu-info">
											<h4>
												<b>John</b> updated status
											</h4>
											<p>
												<i class="material-icons">access_time</i> 3 hours ago
											</p>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<div class="icon-circle bg-purple">
											<i class="material-icons">settings</i>
										</div>
										<div class="menu-info">
											<h4>Settings updated</h4>
											<p>
												<i class="material-icons">access_time</i> Yesterday
											</p>
										</div>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="javascript:void(0);">View All
								Notifications</a></li>
					</ul></li>
				<!-- #END# Notifications -->
				<!-- Tasks -->
				<li class="dropdown"><a href="javascript:void(0);"
					class="dropdown-toggle" data-toggle="dropdown" role="button"> <i
						class="material-icons">flag</i> <span class="label-count">9</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">TASKS</li>
						<li class="body">
							<ul class="menu tasks">
								<li><a href="javascript:void(0);">
										<h4>
											Footer display issue <small>32%</small>
										</h4>
										<div class="progress">
											<div class="progress-bar bg-pink" role="progressbar"
												aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
												style="width: 32%"></div>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<h4>
											Make new buttons <small>45%</small>
										</h4>
										<div class="progress">
											<div class="progress-bar bg-cyan" role="progressbar"
												aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
												style="width: 45%"></div>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<h4>
											Create new dashboard <small>54%</small>
										</h4>
										<div class="progress">
											<div class="progress-bar bg-teal" role="progressbar"
												aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
												style="width: 54%"></div>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<h4>
											Solve transition issue <small>65%</small>
										</h4>
										<div class="progress">
											<div class="progress-bar bg-orange" role="progressbar"
												aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
												style="width: 65%"></div>
										</div>
								</a></li>
								<li><a href="javascript:void(0);">
										<h4>
											Answer GitHub questions <small>92%</small>
										</h4>
										<div class="progress">
											<div class="progress-bar bg-purple" role="progressbar"
												aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"
												style="width: 92%"></div>
										</div>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="javascript:void(0);">View All
								Tasks</a></li>
					</ul></li>
				<!-- #END# Tasks -->
				<li class="pull-right"><a href="javascript:void(0);"
					class="js-right-sidebar" data-close="true"><i
						class="material-icons">more_vert</i></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<!-- #Top Bar -->
	<section> <!-- Left Sidebar --> <aside id="leftsidebar"
		class="sidebar"> <!-- User Info -->
	<div class="user-info">
		<div class="image">
			<!--                     <img src="images/nagesh.jpg" width="48" height="48" alt="User" />
 -->
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
			<li class="active"><a href="index.html"> <i
					class="material-icons">home</i> <span>Home</span>
			</a></li>
			<!--<li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">widgets</i>
                            <span>Widgets</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="javascript:void(0);" class="menu-toggle">
                                    <span>Cards</span>
                                </a>
                                <ul class="ml-menu">
                                    <li>
                                        <a href="pages/widgets/cards/basic.html">Basic</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/cards/colored.html">Colored</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/cards/no-header.html">No Header</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0);" class="menu-toggle">
                                    <span>Infobox</span>
                                </a>
                                <ul class="ml-menu">
                                    <li>
                                        <a href="pages/widgets/infobox/infobox-1.html">Infobox-1</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/infobox/infobox-2.html">Infobox-2</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/infobox/infobox-3.html">Infobox-3</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/infobox/infobox-4.html">Infobox-4</a>
                                    </li>
                                    <li>
                                        <a href="pages/widgets/infobox/infobox-5.html">Infobox-5</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
						<li>
                        <a href="javascript:void(0);" class="menu-toggle">
                            <i class="material-icons">swap_calls</i>
                            <span>User Interface (UI)</span>
                        </a>
                        <ul class="ml-menu">
                            <li>
                                <a href="pages/ui/alerts.html">Alerts</a>
                            </li>
                            <li>
                                <a href="pages/ui/animations.html">Animations</a>
                            </li>
                            <li>
                                <a href="pages/ui/badges.html">Badges</a>
                            </li>

                            <li>
                                <a href="pages/ui/breadcrumbs.html">Breadcrumbs</a>
                            </li>
                            <li>
                                <a href="pages/ui/buttons.html">Buttons</a>
                            </li>
                            <li>
                                <a href="pages/ui/collapse.html">Collapse</a>
                            </li>
                            <li>
                                <a href="pages/ui/colors.html">Colors</a>
                            </li>
                            <li>
                                <a href="pages/ui/dialogs.html">Dialogs</a>
                            </li>
                            <li>
                                <a href="pages/ui/icons.html">Icons</a>
                            </li>
                            <li>
                                <a href="pages/ui/labels.html">Labels</a>
                            </li>
                            <li>
                                <a href="pages/ui/list-group.html">List Group</a>
                            </li>
                            <li>
                                <a href="pages/ui/media-object.html">Media Object</a>
                            </li>
                            <li>
                                <a href="pages/ui/modals.html">Modals</a>
                            </li>
                            <li>
                                <a href="pages/ui/notifications.html">Notifications</a>
                            </li>
                            <li>
                                <a href="pages/ui/pagination.html">Pagination</a>
                            </li>
                            <li>
                                <a href="pages/ui/preloaders.html">Preloaders</a>
                            </li>
                            <li>
                                <a href="pages/ui/progressbars.html">Progress Bars</a>
                            </li>
                            <li>
                                <a href="pages/ui/range-sliders.html">Range Sliders</a>
                            </li>
                            <li>
                                <a href="pages/ui/sortable-nestable.html">Sortable & Nestable</a>
                            </li>
                            <li>
                                <a href="pages/ui/tabs.html">Tabs</a>
                            </li>
                            <li>
                                <a href="pages/ui/thumbnails.html">Thumbnails</a>
                            </li>
                            <li>
                                <a href="pages/ui/tooltips-popovers.html">Tooltips & Popovers</a>
                            </li>
                            <li>
                                <a href="pages/ui/waves.html">Waves</a>
                            </li>
                        </ul>
                    </li>

                    </li> -->
			<!--
					FORMS START
					-->

			<li><a href="javascript:void(0);" class="menu-toggle"> <i
					class="material-icons">view_list</i> <span>Reports</span>
			</a>
				<ul class="ml-menu">

					<li><a href="./registeredUserList">User Registration</a></li>
					<li><a href="./queryUserDetailsListByName?userName=&mobileNumber=">User Records</a></li>

					<%-- <li><form action="registeredUserList"><input type="submit" value="User Registration"></form></li>
					<li><form action="queryUserDetailsListByName"><input type="submit" value="User Records"></form></li> --%>

				</ul></li>
			<!--  Medias-->
			<!-- Example pages-->
	</div>
	<!-- #Menu --> <!-- Footer -->
	<div class="legal">
		<div class="copyright">
			&copy; 2019- 2020 <a href="javascript:void(0);">WalkinSoftware
				Technologies PVT LTD</a>.
		</div>
		<div class="version">
			<b>Version: </b> 1.0.5
		</div>
	</div>
	<!-- #Footer --> </aside> <!-- #END# Left Sidebar --> <!-- Right Sidebar --> <aside
		id="rightsidebar" class="right-sidebar"> <!-- #END# Right Sidebar --></section>

	<section class="content">
	<div class="container-fluid">
		<div class="block-header">
			<h2>DASHBOARD</h2>
		</div>

		<!-- Widgets -->
		<div class="row clearfix">
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-pink hover-expand-effect">
					<div class="icon"></div>
					<div class="content">
						<div class="text">NEW TASKS</div>
						<div class="number count-to" data-from="0" data-to="125"
							data-speed="15" data-fresh-interval="20"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-cyan hover-expand-effect">
					<div class="icon">
						<i class="material-icons">help</i>
					</div>
					<div class="content">
						<div class="text">NEW TICKETS</div>
						<div class="number count-to" data-from="0" data-to="257"
							data-speed="1000" data-fresh-interval="20"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-light-green hover-expand-effect">
					<div class="icon">
						<i class="material-icons">forum</i>
					</div>
					<div class="content">
						<div class="text">NEW COMMENTS</div>
						<div class="number count-to" data-from="0" data-to="243"
							data-speed="1000" data-fresh-interval="20"></div>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="info-box bg-orange hover-expand-effect">
					<div class="icon">
						<i class="material-icons">person_add</i>
					</div>
					<div class="content">
						<div class="text">NEW VISITORS</div>
						<div class="number count-to" data-from="0" data-to="1225"
							data-speed="1000" data-fresh-interval="20"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- #END# Widgets -->
		<!-- CPU Usage -->
		<!-- #END# CPU Usage -->
		<!-- #END# Visitors -->
		<!-- Latest Social Trends -->
		<!-- #END# Latest Social Trends -->
		<!-- Answered Tickets -->
		<!-- #END# Answered Tickets -->
	</div>

	<div class="row clearfix">
		<!-- Task Info -->
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="card">
				<div class="header">
					<h2>MobileDog User Details</h2>
					<!-- graphs start-->
					<script>
						window.onload = function() {

							var chart = new CanvasJS.Chart(
									"chartContainer",
									{
										exportEnabled : true,
										animationEnabled : true,
										title : {
											text : "Mobile DOG Report"
										},
										legend : {
											cursor : "pointer",
											itemclick : explodePie
										},
										data : [ {
											type : "pie",
											showInLegend : true,
											toolTipContent : "{name}: <strong>{y}%</strong>",
											indexLabel : "{name} - {y}%",
											dataPoints : [ {
												y : 26,
												name : "Acive",
												exploded : true
											}, {
												y : 20,
												name : "Approval Waiting"
											}, {
												y : 5,
												name : "Rejected"
											}, {
												y : 3,
												name : "total Count"
											},

											]
										} ]
									});
							chart.render();
						}

						function explodePie(e) {
							if (typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined"
									|| !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
								e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
							} else {
								e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
							}
							e.chart.render();

						}
					</script>

					<!--graph Ends-->

					<div id="chartContainer" style="height: 350px; width: 100%;"></div>
					<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
				</div>
			</div>
		</div>
	</div>
	<!-- #END# Task Info --> <!-- Browser Usage --> <!-- #END# Browser Usage -->
	</div>
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

	<!-- Jquery CountTo Plugin Js -->
	<script src="Admin/plugins/jquery-countto/jquery.countTo.js"></script>

	<!-- Morris Plugin Js -->
	<script src="Admin/plugins/raphael/raphael.min.js"></script>
	<script src="Admin/plugins/morrisjs/morris.js"></script>

	<!-- ChartJs -->
	<script src="Admin/plugins/chartjs/Chart.bundle.js"></script>

	<!-- Flot Charts Plugin Js -->
	<script src="Admin/plugins/flot-charts/jquery.flot.js"></script>
	<script src="Admin/plugins/flot-charts/jquery.flot.resize.js"></script>
	<script src="Admin/plugins/flot-charts/jquery.flot.pie.js"></script>
	<script src="Admin/plugins/flot-charts/jquery.flot.categories.js"></script>
	<script src="Admin/plugins/flot-charts/jquery.flot.time.js"></script>

	<!-- Sparkline Chart Plugin Js -->
	<script src="Admin/plugins/jquery-sparkline/jquery.sparkline.js"></script>

	<!-- Custom Js -->
	<script src="Admin/js/admin.js"></script>
	<script src="Admin/js/pages/index.js"></script>

	<!-- Demo Js -->
	<script src="Admin/pages/demo.js"></script>
</body>
</html>
