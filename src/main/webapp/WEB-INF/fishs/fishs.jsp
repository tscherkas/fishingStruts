<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available fish</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js">
	
</script>
<!-- 
<script type="text/javascript">
	$(document).ready(function() {
		$(".edit_delete").click(function() {
			var id = $(this).siblings()[0].innerHTML;

			var body = 'id=' + encodeURIComponent(id);
			$.ajax({
				type : "POST",
				url : "FishEdit",
				data : body,
				success : function(msg) {
					alert(msg);
					$(".hidden").show(500);
				}
			});
		});
	});
</script>
-->

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".edit_delete")
								.click(
										function() {
											var id = $(this).siblings()[0].innerHTML;
											var name = $(this).siblings()[2].innerHTML;
											var description = $(this)
													.siblings()[3].innerHTML;
											var price = $($(this).siblings()[4])
													.children()[1].innerHTML;
											var image_src = $(
													$(this).siblings()[1])
													.children()[0]
													.getAttribute("src");

											$("#input_id").attr("value", id);
											$("#delete_id").attr("value", id);
											$("#input_name")
													.attr("value", name);
											$("#input_description").val(
													description);
											$("#input_price").attr("value",
													price);
											$("#input_image").attr("value",
													image_src);

											$("#list_block").hide();
											$("#form_block").show();
										});

					});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#to_all_fishs").click(function() {

			$("#new_fish").text("Create new fish");
			$("#list_block").show();
			$("#form_block").hide();
		});
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#new_fish").click(function() {
			$("#list_block").hide();
			$("#form_block").show();
			$("#new_fish").text("Clear");
			$("#input_id").attr("value", "0");
			$("#delete_id").attr("value", "0");
			$("#input_name").val('');
			$("#input_description").val('');
			$("#input_price").val('');
			$("#input_image").val('');
		});
	});
</script>

</head>
<body>
	<div class="products">
		<h2>Product</h2>
		<div id="new_fish">Create new fish</div>
		<div id="list_block">
			<ul>
				<s:iterator value="model">
					<li class="fish">
						<div class="hidden">
							<s:property value="id" />
						</div> <a href="products.html"> <img
							src="<s:property value="image" />" alt="8" height="183"
							width="171" />
					</a> <em><s:property value="name" /></em>
						<p>
							<s:property value="description" />
						</p>
						<div class="purchase">
							<span> $ </span><a><s:property value="price" /></a>
						</div>
						<div class="edit_delete">EDIT / DELETE</div>
					</li>
				</s:iterator>
			</ul>
		</div>
		<div id="form_block" class="hidden">
		<jsp:include page="fishForm.html"/>
			<div id="to_all_fishs">To all fishs</div>
		</div>
	</div>
</body>
</html>