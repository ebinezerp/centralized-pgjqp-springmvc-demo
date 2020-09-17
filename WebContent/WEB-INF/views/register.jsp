<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="register" method="POST" modelAttribute="user">
		<table>
			<tr>
				<td class="errorMsgs">${errorMessage}</td>
			</tr>
			<tr>
				<td><label>Fullname</label></td>
				<td><sf:input path="fullname" /></td>
				<td class="errorMsgs">${errorMessages.fullnameError}</td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><sf:input path="email" /></td>
				<td class="errorMsgs">${errorMessages.emailError}</td>
			</tr>
			<tr>
				<td><label>Mobile</label></td>
				<td><sf:input path="mobile" /></td>
				<td class="errorMsgs">${errorMessages.mobileError}</td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><sf:password path="password" /></td>
				<td class="errorMsgs">${errorMessages.passwordError}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><sf:button type="submit">Register</sf:button></td>
			</tr>

		</table>

	</sf:form>
</body>
</html>