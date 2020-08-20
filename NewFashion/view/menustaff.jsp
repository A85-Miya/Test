<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="manage.Staff" %>
<%
Staff staff = (Staff)request.getAttribute("staff");
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

	<div class="box-above2"><h3><%=staff.getStaffname() %> スタッフページ</h3></div>

	<div class="box">

	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>