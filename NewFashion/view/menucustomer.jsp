<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="manage.Customer" %>
<%
Customer customer = (Customer)request.getAttribute("customer");
%>

<html>

	<head>
		<title>fashion</title>
		<style>
		.box{
			text-align:center;
		}
		.box-above{
			width:100%;
			height:400px;
			text-align:center;
			background-color:#FFFFFF;
		}
		.box-above2{
			width:100%;
			height:50px;
			text-align:center;
			background-color:#FFFFFF;
		}
		.box-left{
			width:25%;
			background-color:#E5E5E5;
		}
		.box-right{
			width:75%;
			background-color:#FFFFAA;
		}
		.box-bottom{
			width:100%;
			height:50px;
			text-align:center;
			background-color:#A7CE02;
		}
		.float-left{
			float:left;
		}
		.clearfix:after{
			content:"";
			display:block;
			clear:both;
		}
		</style>
	</head>

	<body>


	<div class="box"><%@include file="header.jsp" %></div>

	<div class="box-above2"></div>

	<div class="box clearfix">
		<div class="box-left float-left"><%@include file="leftmenu.jsp" %></div>

		<div class="box-right float-left">
		<h3>マイページ</h3>
		<h4>カート</h4>
		<h4>お客様情報</h4>

		</div>
	</div>
	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>