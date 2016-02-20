<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Register - Fishing Template</title>
</head>
<body>
	<h2>Register</h2>
	<div class="registration">
		<form action="regme">
			<table>
				<tbody>
					<tr>
						<td><label>First Name*</label></td>
						<td><input type="text" name="firstName" value="" class="txtfield"></td>
					</tr>
					<tr>
						<td><label>Last Name*</label></td>
						<td><input type="text" name="lastName" value="" class="txtfield"></td>
					</tr>
					<tr>
						<td><label>Email*</label></td>
						<td><input type="text" name="email" value="" class="txtfield"></td>
					</tr>
					<tr>
						<td><label>Password*</label></td>
						<td><input type="password" name="password" value="" class="txtfield"></td>
					</tr>
					<tr>
						<td><label>Confirm Password*</label></td>
						<td><input type="password" name="repeatedPassword" value="" class="txtfield"></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><textarea name="address"></textarea></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td colspan="2" class="checkbox"><label for="checkbox"> -->
<!-- 								<input type="checkbox" id="checkbox"> Join Our -->
<!-- 								Newsletter -->
<!-- 						</label> <label for="terms"> <input type="checkbox" id="terms"> -->
<!-- 								I agree to the Terms of Use and Privacy Policy -->
<!-- 						</label></td> -->
<!-- 					</tr> -->
					<tr>
						<td colspan="2" class="last"><input type="submit"
							value="Submit" class="button"> <span>* = Required
								Field</span></td>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>