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
		<p>Create new catch</p>
		<s:form action="CreateCatch" method="post">

			<s:label for="catch_.trip.id" label="Trip"/>
			<s:select name="catch_.trip.id" list="tripsList" listKey="id"
				listValue="id"></s:select>
				
			<s:label for="catch_.fish.id" label="Fish"/>
			<s:select name="catch_.fish.id" list="fishsList" listKey="id"
				listValue="name"></s:select>
			
			<s:label for="catch_.weight" label="Weight"/>
			<s:textfield name="catch_.weight" value="1.0"/>
			
			<s:submit value="Create" />

		</s:form>
	</div>
	<div id="list_block" class="datagrid">
		<table>
			<thead>
				<tr>
					<th>Trip №</th>
					<th>Fish</th>
					<th>Weight</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="catchesList">
					<tr>
						<td><s:property value="trip.id" /></td>

						<td><s:property value="fish.name" /></td>

						<td><s:property value="weight" /></td>
						
						<td><s:form action="DeleteCatch" method="post">
								<s:hidden name="model.catch_.id" value="%{id}"></s:hidden>
								<s:submit value="Delete"></s:submit>
							</s:form></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</body>
</html>