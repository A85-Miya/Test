<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Wear,manage.Brand,manage.Size,manage.Color,manage.Ordercom,manage.Category,manage.Catedetail" %>
<%
Wear wear = (Wear)request.getAttribute("wear");
ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brand_list");
ArrayList<Size> sizeList = (ArrayList<Size>)request.getAttribute("size_list");
ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("category_list");
ArrayList<Catedetail> catedetailList = (ArrayList<Catedetail>)request.getAttribute("catedetail_list");
ArrayList<Color> colorList = (ArrayList<Color>)request.getAttribute("color_list");
ArrayList<Ordercom> ordercomList = (ArrayList<Ordercom>)request.getAttribute("ordercom_list");
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
		tr {
			background: #FFFFFF; /** 行全体の背景色を指定する */
		}
		tr:nth-child(odd) {
			background: #E5E5E5; /** 奇数行の背景色を指定する */
		}
		</style>
	</head>

	<body>


	<div class="box"><%@include file="header.jsp" %></div>

	<div class="box" align="center">

		<form action="<%=request.getContextPath() %>/WearUpdate">
		<table align="center">

			<tr>
				<th></th>
				<th style="background-color:#36484F; color:#FFFFFF">変更前</th>
				<th style="background-color:#36484F; color:#FFFFFF">変更後</th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">JAN</th>
				<th><%=wear.getJancode() %></th>
				<th><%=wear.getJancode() %></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">商品名</th>
				<th><%=wear.getName() %></th>
				<th><input type="text" name="name" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">税込価格</th>
				<th><%=wear.getIntax() %></th>
				<th><input type="text" name="intax" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">税抜価格</th>
				<th><%=wear.getOuttax() %></th>
				<th><input type="text" name="outtax" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">在庫</th>
				<th><%=wear.getPurchase() %></th>
				<th><input type="text" name="purchase" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">入荷数</th>
				<th><%=wear.getOrdervalue() %></th>
				<th><%=wear.getOrdervalue() %></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">卸売会社</th>
					<%
					for (int a = 0; a < ordercomList.size(); a++) {
						if (ordercomList.get(a).getOrdercomid().equals(wear.getOrdercomid())) {
					%>
				<th><%=ordercomList.get(a).getOrdercomname() %></th>
					<%
						}
					}
					%>
					<%
					for (int a = 0; a < ordercomList.size(); a++) {
						if (ordercomList.get(a).getOrdercomid().equals(wear.getOrdercomid())) {
					%>
				<th><%=ordercomList.get(a).getOrdercomname() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">ブランド</th>
					<%
					for (int b = 0; b < brandList.size(); b++) {
						if (brandList.get(b).getBrandid().equals(wear.getBrandid())) {
					%>
				<th><%=brandList.get(b).getBrandname() %></th>
					<%
						}
					}
					%>
					<%
					for (int b = 0; b < brandList.size(); b++) {
						if (brandList.get(b).getBrandid().equals(wear.getBrandid())) {
					%>
				<th><%=brandList.get(b).getBrandname() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">カテゴリ</th>
					<%
					for (int c = 0; c < categoryList.size(); c++) {
						if (categoryList.get(c).getCategoryid().equals(wear.getCategoryid())) {
					%>
				<th><%=categoryList.get(c).getCategoryname() %></th>
					<%
						}
					}
					%>
					<%
					for (int c = 0; c < categoryList.size(); c++) {
						if (categoryList.get(c).getCategoryid().equals(wear.getCategoryid())) {
					%>
				<th><%=categoryList.get(c).getCategoryname() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">服分類</th>
					<%
					for (int d = 0; d < catedetailList.size(); d++) {
						if (catedetailList.get(d).getCatedetailid().equals(wear.getCatedetailid())) {
					%>
				<th><%=catedetailList.get(d).getCatedetailname() %></th>
					<%
						}
					}
					%>
					<%
					for (int d = 0; d < catedetailList.size(); d++) {
						if (catedetailList.get(d).getCatedetailid().equals(wear.getCatedetailid())) {
					%>
				<th><%=catedetailList.get(d).getCatedetailname() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">サイズ</th>
					<%
					for (int e = 0; e < sizeList.size(); e++) {
						if (sizeList.get(e).getSizeid().equals(wear.getSizeid())) {
					%>
				<th><%=sizeList.get(e).getSizename() %></th>
					<%
						}
					}
					%>
					<%
					for (int e = 0; e < sizeList.size(); e++) {
						if (sizeList.get(e).getSizeid().equals(wear.getSizeid())) {
					%>
				<th><%=sizeList.get(e).getSizename() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">カラー</th>
					<%
					for (int f = 0; f < colorList.size(); f++) {
						if (colorList.get(f).getColorid().equals(wear.getColorid())) {
					%>
				<th><%=colorList.get(f).getColorname() %></th>
					<%
						}
					}
					%>
					<%
					for (int f = 0; f < colorList.size(); f++) {
						if (colorList.get(f).getColorid().equals(wear.getColorid())) {
					%>
				<th><%=colorList.get(f).getColorname() %></th>
					<%
						}
					}
					%>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">詳細情報</th>
				<th><%=wear.getComment() %></th>
				<th><textarea name="comment" rows="4" cols="50"></textarea></th>
			</tr>

		</table>

		<input type="submit" value="情報更新">
		<input type="hidden" name="id" value="<%=wear.getId() %>">

		</form>

	</div>

	<div><%@include file="footer.jsp" %></div>
	</body>

</html>