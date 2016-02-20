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
	<div>
		<!--<jsp:include page="fishForm.html" />  -->
		<s:form action="FishUpdate" theme="xhtml" method="POST" cssClass="fishForm" >
		<s:textfield name="name" maxlength="100" cssClass="txtfield"  label="Name*"></s:textfield>
		<s:textfield name="price" cssClass="txtfield" label="Price"/>
		<s:textarea name = "description" cssClass="txtarea" label="Description"></s:textarea>
		<s:textfield name="image" maxlength="256" cssClass="txtfield" label="Image Url"></s:textfield>
		<s:submit cssClass="button"></s:submit>
		</s:form>
		<div>
			<a href="FishsEditor">To all fishs</a>
		</div>
	</div>
</body>
</html>