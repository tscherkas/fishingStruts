<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style2.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<sx:head />
</head>
<body>
	<div>
		<p>Creating new trip</p>
		<s:form action="CreateTrip" method="post">

			<s:label for="trip.cater.id">Cater:</s:label>
			<s:select name="trip.cater.id" list="catersList" listKey="id"
				listValue="name"></s:select>
			<sx:datetimepicker name="trip.departureDate"
				label="Departure date (dd-MMM-yyyy)" displayFormat="dd-MMM-yyyy"
				value="%{'2015-12-18'}" />
			<sx:datetimepicker name="trip.arrivalDate"
				label="Arrival date (dd-MMM-yyyy)" displayFormat="dd-MMM-yyyy"
				value="%{'2015-12-19'}" />

			<s:submit value="Create" />

		</s:form>
	</div>
	<div id="list_block" class="datagrid">
		<table>
			<thead>
				<tr>
					<th>№</th>
					<th>Departure date</th>
					<th>Arrival date</th>
					<th>Cater name</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="tripsList">
					<tr>
						<td><s:property value="id" /></td>

						<td><s:property value="departureDate" /></td>

						<td><s:property value="arrivalDate" /></td>

						<td><s:property value="cater.name" /></td>
						<td><s:form action="DeleteTrip" method="post">
								<s:hidden name="model.trip.id" value="%{id}"></s:hidden>
								<s:submit value="Delete"></s:submit>
							</s:form></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>