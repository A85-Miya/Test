<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Wear,manage.Brand,manage.Size,manage.Color,manage.Ordercom,manage.Category,manage.Catedetail" %>
<%
ArrayList<Wear> wearList = (ArrayList<Wear>)request.getAttribute("wear_list");
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

		<form action="<%=request.getContextPath() %>/WearInsert">
		<table align="center">

			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">JAN</th>
				<th><input type="text" name="JAN" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">商品名</th>
				<th><input type="text" name="name" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">税込価格</th>
				<th><input type="text" name="intax" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">税抜価格</th>
				<th><input type="text" name="outax" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">在庫</th>
				<th><input type="text" name="purchase" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">入荷数</th>
				<th><input type="text" name="ordervalue" value=""></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">卸売会社</th>
				<th><select name="ordercomid">
					<option value=""></option>
						<%
						for(int a = 0; a < ordercomList.size(); a++) {
						%>
					<option value="<%=ordercomList.get(a).getOrdercomid() %>"><%=ordercomList.get(a).getOrdercomname() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">ブランド</th>
				<th><select name="brandid">
					<option value=""></option>
						<%
						for(int b = 0; b < brandList.size(); b++) {
						%>
					<option value="<%=brandList.get(b).getBrandid() %>"><%=brandList.get(b).getBrandname() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">カテゴリ</th>
				<th><select name="categoryid">
					<option value=""></option>
						<%
						for(int c = 0; c < categoryList.size(); c++) {
						%>
					<option value="<%=categoryList.get(c).getCategoryid() %>"><%=categoryList.get(c).getCategoryname() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">服分類</th>
				<th><select name="catedetailid">
					<option value=""></option>
						<%
						for(int d = 0; d < catedetailList.size(); d++) {
						%>
					<option value="<%=catedetailList.get(d).getCatedetailid() %>"><%=catedetailList.get(d).getCatedetailname() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">サイズ</th>
				<th><select name="sizeid">
					<option value=""></option>
						<%
						for(int e = 0; e < sizeList.size(); e++) {
						%>
					<option value="<%=sizeList.get(e).getSizeid() %>"><%=sizeList.get(e).getSizename() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">カラー</th>
				<th><select name="colorid">
					<option value=""></option>
						<%
						for(int f = 0; f < colorList.size(); f++) {
						%>
					<option value="<%=colorList.get(f).getColorid() %>"><%=colorList.get(f).getColorname() %></option>
						<%
						}
						%>
					</select></th>
			</tr>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">詳細情報</th>
				<th><textarea name="comment" rows="4" cols="50"></textarea></th>
			</tr>

		</table>
		<input type="submit" value="登録">
		</form>

	</div>

	<div><%@include file="footer.jsp" %></div>
	</body>

</html>