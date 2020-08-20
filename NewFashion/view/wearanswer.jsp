<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Wear" %>
<%
ArrayList<Wear> wearList = (ArrayList<Wear>)request.getAttribute("wear_list");
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


	<div class="box-above"><%@include file="frontpic.jsp" %></div>

	<div class="box-above2"><%@include file="search.jsp" %></div>

	<div class="box clearfix">
		<div class="box-left float-left"><%@include file="leftmenu.jsp" %></div>
		<div class="box-right float-left">

		<table>
		<tr>
		<%
		for (int i = 0; i < wearList.size(); i++) {
		%>
			<th><a href="<%=request.getContextPath() %>/WearDetail?id=<%=wearList.get(i).getId() %>">
				<%=wearList.get(i).getName() %></a></th>

			<th><img src="<%=wearList.get(i).getImage() %>" alt="<%=wearList.get(i).getName() %>" width="150" height="150"></th>

			<th><a href="<%=request.getContextPath() %>/InsertCart?id=<%=wearList.get(i).getId() %>">
				カートに入れる</a></th>

		<%
		}
		%>
		</tr>
		</table>

		</div>
	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>