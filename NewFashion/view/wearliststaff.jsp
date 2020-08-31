<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Wear,manage.Brand,manage.Size,manage.Color,manage.Catedetail" %>
<%
ArrayList<Wear> wearList = (ArrayList<Wear>)request.getAttribute("wear_list");
ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brand_list");
ArrayList<Size> sizeList = (ArrayList<Size>)request.getAttribute("size_list");
ArrayList<Color> colorList = (ArrayList<Color>)request.getAttribute("color_list");
ArrayList<Catedetail> catedetailList = (ArrayList<Catedetail>)request.getAttribute("catedetail_list");
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


	<div class="box-above2">
		<form action="<%=request.getContextPath() %>/WearSearch">
			<select name="catedetailid">
				<option value="" style="color:#DCDCDC">服分類</option>
					<%
					for(int w = 0; w < catedetailList.size(); w++) {
					%>
				<option value="<%=catedetailList.get(w).getCatedetailid() %>"><%=catedetailList.get(w).getCatedetailname() %></option>
					<%
					}
					%>
			</select>
			<select name="brandid">
				<option value="" style="color:#DCDCDC">ブランド名</option>
					<%
					for(int x = 0; x < brandList.size(); x++) {
					%>
				<option value="<%=brandList.get(x).getBrandid() %>"><%=brandList.get(x).getBrandname() %></option>
					<%
					}
					%>
			</select>
			<select name="sizeid">
				<option value="" style="color:#DCDCDC">サイズ</option>
					<%
					for(int y = 0; y < sizeList.size(); y++) {
					%>
				<option value="<%=sizeList.get(y).getSizeid() %>"><%=sizeList.get(y).getSizename() %></option>
					<%
					}
					%>
			</select>
			<select name="colorid">
				<option value="" style="color:#DCDCDC">カラー</option>
					<%
					for(int z = 0; z < colorList.size(); z++) {
					%>
				<option value="<%=colorList.get(z).getColorid() %>"><%=colorList.get(z).getColorname() %></option>
					<%
					}
					%>
			</select>
			<input type="submit" value="検索">
		</form>
	</div>

	<div class="box">

		<table align="center">

			<tr>
				<th style="background-color:#36484F; color:#FFFFFF">ID</th>
				<th style="background-color:#36484F; color:#FFFFFF">JANコード</th>
				<th style="background-color:#36484F; color:#FFFFFF">商品名</th>
				<th style="background-color:#36484F; color:#FFFFFF">税込価格</th>
				<th style="background-color:#36484F; color:#FFFFFF">税抜価格</th>
				<th style="background-color:#36484F; color:#FFFFFF">在庫</th>
				<th style="background-color:#36484F; color:#FFFFFF">服分類</th>
				<th style="background-color:#36484F; color:#FFFFFF">ブランド</th>
				<th style="background-color:#36484F; color:#FFFFFF">サイズ</th>
				<th style="background-color:#36484F; color:#FFFFFF">カラー</th>
				<th style="background-color:#36484F; color:#FFFFFF"></th>
				<th style="background-color:#36484F; color:#FFFFFF"></th>
			</tr>

			<%
				if (wearList != null) {
					for (int i = 0; i < wearList.size(); i++) {
			%>
			<tr>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getId() %></th>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getJancode() %></th>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getName() %></th>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getIntax() %></th>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getOuttax() %></th>
				<th style="background-color:#DCDCDC"><%=wearList.get(i).getPurchase() %></th>
					<%
					for (int a = 0; a < catedetailList.size(); a++) {
						if (catedetailList.get(a).getCatedetailid().equals(wearList.get(i).getCatedetailid())) {
					%>
				<th style="background-color:#DCDCDC"><%=catedetailList.get(a).getCatedetailname() %></th>
					<%
						}
					}
					%>
					<%
					for (int b = 0; b < brandList.size(); b++) {
						if (brandList.get(b).getBrandid().equals(wearList.get(i).getBrandid())) {
					%>
				<th style="background-color:#DCDCDC"><%=brandList.get(b).getBrandname() %></th>
					<%
						}
					}
					%>
					<%
					for (int c = 0; c < sizeList.size(); c++) {
						if (sizeList.get(c).getSizeid().equals(wearList.get(i).getSizeid())) {
					%>
				<th style="background-color:#DCDCDC"><%=sizeList.get(c).getSizename() %></th>
					<%
						}
					}
					%>
					<%
					for (int d = 0; d < colorList.size(); d++) {
						if (colorList.get(d).getColorid().equals(wearList.get(i).getColorid())) {
					%>
				<th style="background-color:#DCDCDC"><%=colorList.get(d).getColorname() %></th>
					<%
						}
					}
					%>
				<th><input type="submit" value="情報更新">
					<input type="hidden" name="cmd" value="update">
					<input type="hidden" name="id" value="<%=wearList.get(i).getId() %>"></th>

				<th><input type="submit" value="商品削除">
					<input type="hidden" name="cmd" value="delete">
					<input type="hidden" name="id" value="<%=wearList.get(i).getId() %>"></th>
			</tr>
			<%
				}
			}
			%>

		</table>

	</div>

	<div><%@include file="footer.jsp" %></div>
	</body>

</html>