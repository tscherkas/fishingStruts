<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available fish</title>
</head>
<body>
	<h2>Fishs</h2>
	<div id="list_block" class="products">
		<ul>
			<s:iterator value="model">
				<li class="fish">
					<a href="products.html"> <img 
						src="<s:property value="image" />" alt="8" height="183"
						width="171" />
				</a> <em><s:property value="name" /></em>
					<p>
						<s:property value="description" />
					</p>
					<div class="purchase">
						<span> $ </span><a><s:property
									value="price" /></a>
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>