<%@page contentType="text/html; charset=UTF-8" %>
<%
String message = (String)request.getAttribute("message");
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


	<div class="box-above">
		<h3>スタッフログイン</h3>
		<br>

		<%
		if (!(message.equals(""))) {
		%>
		<h4 style="color:red"><%=message %></h4>
		<%
		}
		%>

		<br>
		<form action="<%=request.getContextPath() %>/LoginStaff">
			スタッフID<input type="text" name="staffid" value="">
			パスワード<input type="text" name="staffpass" value="">
			<input type="submit" value="ログイン">
		</form>
	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>