<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><a href="CaterEdit">Create a new cater</a></div>
	<form action="CaterUpdate">
		<s:hidden name="model.id"></s:hidden>
		<table>
			<tbody>
				<tr>
					<td><label>Name*</label></td>
					<td><s:textfield name="model.name" class="txtfield" /></td>
				</tr>
				<tr>
					<td><label>Image URL</label></td>
					<td><s:textfield name="model.image" class="txtfield" /></td>
				</tr>
				<tr>
					<td colspan="2" class="last"><input type="submit"
						value="Submit" class="button"> <span>* = Required
							Field</span></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form action="CaterDelete">
		<s:hidden name="model.id"></s:hidden>
		<table>
			<tbody>
				<tr>
					<td colspan="2" class="last"><input type="submit"
						value="Delete" class="button"> <span>*
							= Required Field</span></td>
					</form>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>