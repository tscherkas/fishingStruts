<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available caters</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".edit_delete").click(function() {
			var id = $(this).siblings()[0].innerHTML;
			var name = $(this).siblings()[2].innerHTML;
			var image = $(this).siblings()[1].getAttribute("src");

			$("#input_id").attr("value", id);
			$("#del_id").attr("value", id);
			$("#input_name").attr("value", name);
			$("#input_image").attr("value", image);

			$("#list_block").hide();
			$("#form_block").show();
			$("#to_all_caters").show();
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#create_cater").click(function() {
			

			$("#input_id").attr("value", 0);
			$("#input_name").attr("value", "");
			$("#input_image").attr("value", "");

			$("#list_block").hide();
			$("#delete_cater").hide();
			$("#form_block").show();
			$("#to_all_caters").show();
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#to_all_caters").click(function() {
			$("#list_block").show();
			$("#form_block").hide();
			$("#to_all_caters").hide();
			$("#delete_cater").show();
		});
	});
</script>

</head>
<body>
	<h2>Caters</h2>
	<div id="list_block" class="products">
		<div id="create_cater">New Cater...</div>
		<ul>
			<s:iterator value="model">
				<li class="fish">
					<div class="hidden">
						<s:property value="id" />
					</div>
					<img src="<s:property value="image" />" height="183"
					width="171" />

					<em><s:property value="name" /></em>

					<div class="edit_delete">EDIT / DELETE</div>
				</li>
			</s:iterator>
		</ul>
	</div>
	<div id="form_block" class="hidden">
		<form action="CaterUpdate" class=fishForm>
		<s:hidden id="input_id" name="model.id"></s:hidden>
		<table>
			<tbody>
				<tr>
					<td><label>Name*</label></td>
					<td><s:textfield id="input_name" name="name" class="txtfield" /></td>
				</tr>
				<tr>
					<td><label>Image URL</label></td>
					<td><s:textfield id="input_image" name="image" class="txtfield" /></td>
				</tr>
				<tr>
					<td colspan="2" class="last"><input type="submit"
						value="Submit" class="button"> <span>* = Required
							Field</span></td>
				</tr>
			</tbody>
		</table>
	</form>
		<form action="CaterDelete" id="delete_cater" class="FishForm">
			<s:hidden id="del_id" name="id"></s:hidden>
			<table>
				<tbody>
					<tr>
						<td colspan="2" class="last"><input type="submit"
							value="Delete" class="button"> <span>* = Required
								Field</span></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="to_all_caters" class="hidden">To all Caters</div>
</body>
</html>