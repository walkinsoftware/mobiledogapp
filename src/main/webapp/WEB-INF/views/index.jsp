
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mobile Dog App</title>

  </script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">


  	<meta charset="utf-8">
	    <link rel="shortcut icon" href="mobdog.png" style="height:60%; width:60%;">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet" type="text/css" href="carouselengine/carouselengine/initcarousel-1.css">
    <!-- End of head section HTML codes -->


	<!-- css -->
	<link rel="stylesheet" href="./assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="./assets/css/ionicons.min.css">
	<link rel="stylesheet" href="./assets/css/owl.carousel.css">
	<link rel="stylesheet" href="./assets/css/owl.theme.css">
	<link rel="stylesheet" href="./assets/css/animate.css">
	<link rel="stylesheet" href="./assets/css/style.css">
	<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
  padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 100%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
  position: absolute;
  right: 25px;
  top: 0;
  color: #000;
  font-size: 35px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: red;
  cursor: pointer;
}

/* Add Zoom Animation */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)}
  to {-webkit-transform: scale(1)}
}

@keyframes animatezoom {
  from {transform: scale(0)}
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
	<!-- fonts -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic|Roboto+Condensed:300italic,400italic,700italic,400,300,700|Oxygen:400,300,700' rel='stylesheet'>

	

    
</head>
<body id="home">

	<!-- ****************************** Preloader ************************** -->


	<!-- ****************************** Sidebar ************************** -->

	<nav id="sidebar-wrapper">
		<a id="menu-close" href="#" class="close-btn toggle"><i class="ion-ios-close-empty"></i></a>
	    <ul class="sidebar-nav">
		    <li><a href="#home">Home</a></li>
			<li><a href="#features">Features</a></li>
			<li><a href="#gallery">Gallery</a></li>
			<li><a href="#team">Development Team</a></li>
			<li><a href="#testimonial">Precious Reviews</a></li>
			<li><a href="#contact">Contact us</a></li>
<!-- 			<li><button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>
 --></li>
	    </ul>
	</nav>

	<!-- ****************************** Header ************************** -->

	<header class="sticky" id="header" style="height:11%;">
		<section class="container">
			<section class="row" id="logo_menu">
				<section class="col-xs-8"><a class="logo" href="">Mobile Dog</a></section>
				<section class="col-xs-4"><a id="menu-toggle" href="#" class="toggle wow rotateIn" data-wow-delay="1s"><i class="ion-navicon"></i></a></section>
			</section>
		</section>
	</header>

	<!-- ****************************** Banner ************************** -->


	<section id="banner" >
		<section class="container">
			<a class="slidedown wow animated zoomIn" data-wow-delay="2s" href="#features"><i class="ion-ios-download-outline"></i></a>
			<section class="row">
				<div class="col-md-6">
					<div class="headings">
						<h3 class="wow animated fadeInDown" style="font-family:san-sarif;">Welcome to MobileDog</h3>
						<p class="wow animated fadeInLeft" style="font-family:monospace;">This is the security and safety, app providing many more features  for MobileDog APP users</p>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-5">
								<div>
									<a href="https://play.google.com/store/apps/details?id=com.mobiledogabhinav.android&hl=en" class="polo-btn store wow animated bounceInUp" ><i class="ion-social-android"></i> Play Store</a>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-5">
								<div>
									<a href="#" class="polo-btn store wow animated bounceInUp" data-toggle="popover"><i class="ion-social-apple"></i> App Store</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			<div class="col-md-4">
					<div class="headings">
					<h3 style="color:darkcyan;font-family:monospace;">Login here</h3>
          <div style="color: red">${errMsg}</div>
<form action="userLogin" method="post" style="color:black;bo">
  User Name/Mobile Number:<br>
  <input type="text" id="uname" name="uname">
  <br>
  Password:<br>
  <input type="password" id="pwd" name="pwd">
  <br><br>
  <input type="submit"  class="btn btn-success"value="Submit">
</form>

					</div>
				</div>
				</div>
			</section>
		</section>
	</section>

	<!-- ****************************** Features Section ************************** -->

	<section id="features" class="block">
		<section class="container">
			<section class="row">
				<div class="title-box"><h1 class="block-title wow animated rollIn">
				<span class="bb-top-left"></span>
				<span class="bb-bottom-left"></span>
				Features
				<span class="bb-top-right"></span>
				<span class="bb-bottom-right"></span>
				</h1></div>
			</section>

			<section class="row">
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.3s">
					<i class="material-icons" style="color:#9b59b6">sd_card</i>
						<br><h2>SIM REMOVEL</h2>
						<p>After SIM removal or SIM insertion, MobileDog App will capture photo automatically with Location which send to www.mobiledog.in , registered user can login into www.mobiledog.in for checking captured photo & location.</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.3s">
<i class="material-icons" style="color: #FC0202;">phone_in_talk</i>
<br><h2>EMERGENCY CALLING</h2>
						<p>After pressing Power Button/Volume Down Button/Dashboard Emergency Button, MobileDog App will send SMS and make Phone Call automatically to alternative registered number (Care Taker) with user credentials for login into www.mobiledog.in and also send location to www.mobiledog.in, Care Taker can track the location of emergency person.</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.3s">
<i class="material-icons" style="color: #00ceb8;">gps_fixed</i>						<br><h2>GPS Tracking</h2>
						<p>Registered user can track his/her mobile location through www.mobiledog.in.</p>
					</div>
				</div>
				</section>

				<section class="row">
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
					<i class="material-icons" style="color:#23FF87 ;">phonelink_lock</i>
						<br><h2>Phone Protection</h2>
						<p>After SIM removal, MobileDog App will lock the mobile automatically.</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
					<i class="material-icons" style="color:#10F4C7;">notifications_active</i>
						<br><h2>Phone Theft Notification</h2>
						<p>After SIM removal, MobileDog App will show the notification (Phone is being tracked, Kindly handover the phone to +91**********). </p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
						<i class="material-icons" style="color:#DAC3DC;">collections</i>
						<br><h2>Super Cleaning</h2>
						<p>MobileDog App will clean junk files.</p>
					</div>
				</div>
			</section>
			<section class="row">
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
					<i class="material-icons" style="color:#6A6B92;">lock</i>
						<br><h2>App Lock</h2>
						<p> MobileDog App is protected by password (MPIN).</p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
					<i class="material-icons" style="color:#27ae60;">loop</i>
						<br><h2>Hidden App Scan</h2>
						<p>MobileDog App will display all installed App’s in mobile. It will help you to find the installed hidden App’s on your mobile. </p>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="feature-box wow animated flipInX" data-wow-delay="0.6s">
					<i class="material-icons" style="color:#F50B8B;">settings</i>
						<br><h2>Setting</h2>
						<p>User can enable or disable Location Tracking, Emergency & MPIN options.</p>
					</div>
				</div>
			</section>

			<div class="clearfix"></div>
		</section>
	</section>

	<!-- ****************************** Gallery Section ************************** -->

	<section id="gallery" class="block">
		<section class="container">
			<section class="row">
				<div class="title-box" style="color:#fff;"><h1 class="block-title wow animated rollIn">
				<span class="bb-top-left" style="border-color: #fff; "></span>
				<span class="bb-bottom-left" style="border-color: #fff; "></span>
				Gallery
				<span class="bb-top-right" style="border-color: #fff; "></span>
				<span class="bb-bottom-right" style="border-color: #fff; "></span>
				</h1></div>
			</section>
			<section class="row">
				<div class="col-xs-12">
					<div id="screenshots" class="owl-carousel owl-theme">
					  <div class="item"><img src="assets/img/screenshot-1.jpg" style="border-radius: 10%;"class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-2.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-3.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-4.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-5.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-6.jpg" style="border-radius: 10%;"  class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-3.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-2.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					  <div class="item"><img src="assets/img/screenshot-5.jpg" style="border-radius: 10%;" class="img_res wow animated zoomIn"></div>
					</div>
					 <div class="customNavigation">
					  <a class="btn prev gallery-nav wow animated bounceInLeft"><i class="ion-ios-arrow-left"></i></a>
					  <a class="btn next gallery-nav wow animated bounceInRight"><i class="ion-ios-arrow-right"></i></a>
					</div>
				</div>
			</section>
		</section>
	</section>

	<!-- ****************************** Team Section ************************** -->

	<section id="team" class="block">
		<section class="container">
			<section class="row">
				<div class="col-md-12">
					<div class="title-box">
						<h1 class="block-title wow animated rollIn">
							<span class="bb-top-left"></span>
							<span class="bb-bottom-left"></span>
							Development Team
							<span class="bb-top-right"></span>
							<span class="bb-bottom-right"></span>
						</h1>
					</div>
				</div>
			</section>
			<section class="row">
				<section class="col-md-3 col-sm-6">
					<div class="team-member wow animated fadeIn" data-wow-delay=="0.3s">
						<img src="images/1.jpg" class="img_res team-pic">
						<h2 class="wow animated fadeInDown" data-wow-delay=="0.7s">Full Stack Developer</h2>
											</div>
				</section>
				<section class="col-md-3 col-sm-6">
					<div class="team-member wow animated fadeIn" data-wow-delay=="0.3s">
						<img src="images/nourin.jpg" class="img_res team-pic">
						<h2 class="wow animated fadeInDown" data-wow-delay=="0.7s">Tester</h2>

					</div>
				</section>
				<section class="col-md-3 col-sm-6">
					<div class="team-member wow animated fadeIn" data-wow-delay=="0.3s">
						<img src="images/vinod.jpg" class="img_res team-pic">
						<h2 class="wow animated fadeInDown" data-wow-delay=="0.7s">UI/UX developer</h2>
											</div>
				</section>
				<section class="col-md-3 col-sm-6">
					<div class="team-member wow animated fadeIn" data-wow-delay=="0.3s">
						<img src="images/vishu.jpg" class="img_res team-pic">
						<h2 class="wow animated fadeInDown" data-wow-delay=="0.7s">MEAN Stack Develper</h2>
							</div>
				</section>
			</section>
		</section>
	</section>

	<!-- ****************************** Testimonial ************************** -->

	<section id="testimonial" class="block">
		<section class="container">
			<section class="row">
				<div class="title-box"><h1 class="block-title wow animated rollIn">
				<span class="bb-top-left"></span>
				<span class="bb-bottom-left"></span>
				Precious APP Reviews
				<span class="bb-top-right"></span>
				<span class="bb-bottom-right"></span>
				</h1></div>
			</section>
		</section>
		<section class="container">
			<section class="row">
				<section class="col-xs-12">
					<div id="review" class="owl-carousel owl-theme">
						<div class="item">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">
									<div class="client-pic"><img class="img_res" src="assets/img/dev-1.jpg"></div>
									<p class="review-star">
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star-outline"></i>
									</p>
								</div>
								<div class="col-sm-6">
									<p class="review-desc">
										This is one of the great app that can make really funny and viral videos! Premium video editing features for free!!! Really Awesome.
									</p>
									<p class="client-name">
Simth 									</p>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">
									<div class="client-pic"><img class="img_res" src="images/nagesh.jpg"></div>
									<p class="review-star">
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star-outline"></i>
									</p>
								</div>
								<div class="col-sm-6">
									<p class="review-desc">
										This is App is most usefull parents and children, Emergency women safety,over all its cool adn awesome App
									</p>
									<p class="client-name">
										Nageswar Rao
									</p>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">
									<div class="client-pic"><img class="img_res" src="assets/img/dev-3.jpg"></div>
									<p class="review-star">
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star-outline"></i>
									</p>
								</div>
								<div class="col-sm-6">
									<p class="review-desc">
										This is The best APp for the Women, and Mobile safety achived.
									</p>
									<p class="client-name">
										Anna Joe
									</p>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-1">
									<div class="client-pic"><img class="img_res" src="assets/img/dev-4.jpg"></div>
									<p class="review-star">
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star"></i>
										<i class="ion-ios-star-outline"></i>
									</p>
								</div>
								<div class="col-sm-6">
									<p class="review-desc">
										Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
										tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
										quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
									</p>
									<p class="client-name">
										Shahjahan Jewel
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</section>
		</section>
	</section>

	<!-- ****************************** Subscribe Section ************************** -->


	</section>



	<!----------------------------Video Gallery Start----------------------->



<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>


<!-- End of body section HTML codes -->



	<!--------------------------Video gallery Ends-------------------------->
	<!-- ****************************** Contact Section ************************** -->

	<section id="contact" class="block">
<div class="mapouter">
<div class="gmap_canvas"><iframe width="100%;" height="100%;" id="gmap_canvas" src="https://maps.google.com/maps?q=%23553%2C%2015th%20main%203rd%20stage%204th%20block%20basavedhwara%20nagar%20bangalore%20560079%2C%20Bengaluru%2C%20Karnataka%20560079&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.embedgooglemap.net/blog/best-wordpress-themes/">best wordpress themes</a></div><style>.mapouter{position:relative;text-align:right;height:400px;width:1349px;}.gmap_canvas {overflow:hidden;background:none!important;height:400px;width:1349px;}</style>
</div>	
		</section>

		<!-- ****************************** Footer ************************** -->

		<section id="footer">
			<section class="container">
				<section class="row">
					<div class="col-sm-6">
						<span>Developed By</span>
						<h1 class="footer-logo">
							<a href="https://www.walkinsoftwares.com/">WalkinSoftware Technologies PVT. LTD.</a>
						</h1>
					</div>
					<div class="col-sm-6">
						<p class="copyright">All &copy; Copyright Reserved 2019</p>
					</div>
				</section>
			</section>
		</section>


	<!-- All the scripts -->

	<script src="assets/js/jquery-2.1.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/wow.min.js"></script>
	<script src="assets/js/owl.carousel.js"></script>
	<script src="assets/js/script.js"></script>
	<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();
});
</script>

<script>
$(document).ready(function(){
  $(".ion-navicon").click(function(){
    $("sidebar-wrapper").fadeOut(1000);
  });

});
</script>
<script   src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous">
<!-- Insert to your webpage before the </head> -->
<script src="carouselengine/carouselengine/jquery.js"></script>
<script src="carouselengine/amazingcarousel.js"></script>
    <script src="carouselengine/carouselengine/initcarousel-1.js"></script>

</body>
</html>
