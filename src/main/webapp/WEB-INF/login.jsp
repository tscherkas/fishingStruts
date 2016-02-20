<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Accounts - Fishing Template</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="sign-in">
		<h2>Sign in</h2>
		<form action="login">
			<label>Email</label> <input type="text" name="email" value="" class="txtfield">
			<label>Password</label> <input type="password" name="password" value="" class="txtfield">
			<input type="submit" value="Submit" class="button">
		</form>
	</div>
</body>
</html>