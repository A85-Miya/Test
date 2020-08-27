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

		<%
		for (int i = 0; i < wearList.size(); i++) {
			if (order.getId().equals(wearList.get(i).getId())) {
		%>

			<h4><%=wearList.get(i).getName() %></h4>

		<%
			}
		}
		%>

			<br>
			<table style="margin:0 auto">
			<form action="<%=request.getContextPath()%>/UpdateCart">
			<tr>
				<td></td>
				<td>変更前</td>
				<td>変更後</td>
			</tr>
			<tr>
				<td>数量</td>
				<td><%=order.getQuantity() %></td>
				<td><select name="quantity">
						<option value=""></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value ="変更完了" >
					<input type="hidden" name="orderid" value="<%=order.getOrderid() %>"></td>
				<td></td>
			</tr>
			</form>
			</table>
		</div>
	</div>

	<div class="box-bottom"><%@include file="bottom.jsp" %></div>


	<div><%@include file="footer.jsp" %></div>
	</body>

</html>