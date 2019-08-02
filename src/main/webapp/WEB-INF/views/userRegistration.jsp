<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>${msg}</p>
	<p>${errmsg}</p>

	<table width="50%">
		<tr>
			<th>id</th>
			<th>fullName</th>
			<th>userName</th>
			<th>emailId</th>
			<th>mobileNumber</th>
			<th>barcode</th>
			<th>Action</th>

		</tr>
		<c:forEach items="${registeredUserList}" var="user"
			varStatus="tagStatus">
			<tr>
				<td>${user.id}</td>
				<td>${user.fullName}</td>
				<td>${user.userName}</td>
				<td>${user.emailId}</td>
				<td>${user.mobileNumber}</td>
				<td>${user.barcode}</td>
				<td>
					<form action="userActivationProcess" method="post">
						<input id="userIds" name="userIds" type="hidden"
							value="${user.id}" /> <input id="operationType"
							name="operationType" type="hidden" /> <input type="text"
							name="reason" id="reason" /> <input type="submit" value="Accept"
							id="accept" onclick="submitForm(this)" /> <input type="submit"
							value="Reject" id="reject" onclick="submitForm(this)" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<script>
   function submitForm(x){
      if(x.value=='Accept'){
         document.getElementById('operationType').value='ACCEPT';
      }
      else if(x.value=='Reject'){
          document.getElementById('operationType').value='REJECT';
       }
      document.forms[0].submit();
   }
</script>

</body>
</html>