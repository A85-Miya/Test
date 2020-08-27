<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Order,manage.Wear" %>
<%
Order order = (Order)request.getAttribute("order");
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
			height:150px;
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
			<table style="margin:0 auto">
			<tr>
				<td>商品名</td>
					<%
					for (int i = 0; i < wearList.size(); i++) {
						if (order.getId().equals(wearList.get(i).getId())) {
					%>
				<td><%=wearList.get(i).getName() %></td>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<td>注文日</td>
				<td><%=order.getDate() %></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><%=order.getQuantity() %></td>
			</tr>
			</table>
					<%
					for (int i = 0; i < wearList.size(); i++) {
						if (order.getId().equals(wearList.get(i).getId())) {
					%>
				<img src="<%=wearList.get(i).getImage() %>"  alt="<%=wearList.get(i).getName() %>" width="150" height="150">
					<%
						}
					}
					%>

		</div>
	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>