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
	<s:if test="trip!=null">
		<h2>
			Selected cater:
			<s:property value="trip.cater.name" />
		</h2>
		<h3>
			Departure date :
			<s:property value="trip.departureDate" />
		</h3>
		<h3>
			Arrival date :
			<s:property value="trip.arrivalDate" />
		</h3>
	</s:if>
	<a href="TeamsAndTrips">Back to trips</a>
</body>
</html>