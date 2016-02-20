<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available caters</title>


</head>
<body>
	<h2>Caters</h2>
	<div id="list_block" class="products">
		<ul>
			<s:iterator value="model">
				<li class="fish">
					
					<img src="<s:property value="image" />" height="183" width="171" />
										
				    <em><s:property value="name" /></em>
				    
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>