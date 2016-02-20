<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="page">
		<div id="header">
			<ul id="login">
				<li class="first"><a href="register">Register</a><span>/</span>
				</li>
				<li><a href="login">My Account</a></li>
			</ul>
			<ul id="service">
				<li class="first"><a href="help.html">Help</a><span>/</span></li>
				<li><a href="contacts.html">Contact Us</a></li>
			</ul>
			<div>
				<a href="index" id="logo"></a>
				<div>
					<p>Shopping Cart: 0 item</p>
					<p>$ 0.00</p>
				</div>
			</div>
		</div>

		<div id="content">
			<sitemesh:write property='body' />
		</div>
		<div id="footer">
			<div id="footnote">
				<a href="index" class="logo"></a> <span>&#169; Copyright
					&#169; 2012. All rights reserved</span>
			</div>
			<div class="navigation">
				<div class="primary">
					<h3>Shop</h3>
					<ul>
						<li><a href="products.html">Products</a></li>
						<li><a href="featured.html">Featured Products</a></li>
						<li><a href="clearance.html">Clearance</a></li>
						<li><a href="cards.html">Gift Card</a></li>
					</ul>
				</div>
				<div class="secondary">
					<h3>About</h3>
					<ul>
						<li><a href="about.html">The Company</a></li>
						<li><a href="shipping.html">Shipping FAQ's</a></li>
						<li><a href="blog.html">Blog</a></li>
						<li><a href="help.html">Help</a></li>
					</ul>
				</div>
			</div>
			<div id="connect">
				<h3>lets be friends &amp; Share us to the world</h3>
				<ul>
					<li><a href="http://freewebsitetemplates.com/go/facebook/"
						target="_blank" class="fb" title="Facebook"></a></li>
					<li><a href="http://freewebsitetemplates.com/go/twitter/"
						target="_blank" class="twitter" title="Twitter"></a></li>
					<li><a href="http://freewebsitetemplates.com/go/googleplus/"
						target="_blank" class="googleplus" title="Googleplus"></a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>