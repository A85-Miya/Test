<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Order,manage.Wear" %>
<%
ArrayList<Order> orderList = (ArrayList<Order>)request.getAttribute("order_list");
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
		<table style="margin:0 auto">
			<tr>
				<th>注文商品</th>
				<th>注文日</th>
				<th>数量</th>
				<th>数量変更・キャンセル</th>
			</tr>
			<tr>
				<%
				if (orderList != null) {
					for (int i = 0; i < orderList.size(); i++) {
				%>
					<%
					for (int j = 0; j < wearList.size(); j++) {
						if (wearList.get(j).getId().equals(orderList.get(i).getId())) {
					%>
				<th><a href="<%=request.getContextPath() %>/OrderDetail?id=<%=wearList.get(j).getId() %>">
						<%=wearList.get(j).getName() %></a></th>
					<%
						}
					}
					%>
				<th><%=orderList.get(i).getDate() %></th>
				<th><%=orderList.get(i).getQuantity() %></th>
				<th><form action="<%=request.getContextPath() %>/OrderDetail">
						<input type="submit" value="数量変更">
						<input type="hidden" name="cmd" value="update">
						<input type="hidden" name="orderid" value="<%=orderList.get(i).getOrderid() %>"></form>
					<form action="<%=request.getContextPath() %>/OrderDetail">
						<input type="submit" value="キャンセル">
						<input type="hidden" name="cmd" value="delete">
						<input type="hidden" name="orderid" value="<%=orderList.get(i).getOrderid() %>"></form>
				<%
					}
				%>
			</tr>
		</table>
				<%
				} else {
				%>
				<h4>カートに商品はありません。</h4>
				<%
				}
				%>


		</div>
	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>