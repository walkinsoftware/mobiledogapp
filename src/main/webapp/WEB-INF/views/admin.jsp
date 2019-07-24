<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>MobileDog Admin DashBoard</title>
    <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

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

<label>Login USer Details</label></br>
<label>${loginUser.username}</label>
<label >${loginUser.roleId}</label>
<label >${msg}</label>

</br>
<form:form method="post" action="registeredUserList" modelAttribute="user">
	<table>
	<tr>
		<th>No.</th>
		<th>User Name</th>
		<th>Full name</th>
		<th>Mobile Number</th>
		<th>emailId</th>
		<th>Bar Code</th>
	</tr>
	<c:forEach items="${registeredUserList}" var="userDetails" varStatus="status">
		<tr>
			<td align="center">${status.count}</td>
			<td><input name="userDetails[${status.index}].firstname" value="${userDetails.userName}"/></td>
			<td><input name="userDetails[${status.index}].lastname" value="${userDetails.fullName}"/></td>
			<td><input name="userDetails[${status.index}].email" value="${userDetails.mobileNumber}"/></td>
			<td><input name="userDetails[${status.index}].phone" value="${userDetails.emailId}"/></td>
			<td><input name="userDetails[${status.index}].phone" value="${userDetails.barcode}"/></td>
		</tr>
	</c:forEach>
</table>	
<br/>

</form:form>
</body>
</html>