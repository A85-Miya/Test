<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Wear,manage.Brand,manage.Size,manage.Color" %>
<%
ArrayList<Wear> wearList = (ArrayList<Wear>)request.getAttribute("wear_list");
ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brand_list");
ArrayList<Size> sizeList = (ArrayList<Size>)request.getAttribute("size_list");
ArrayList<Color> colorList = (ArrayList<Color>)request.getAttribute("color_list");
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
				<th style="background-color:#36484F; color:#FFFFFF">ブランド</th>
				<th style="background-color:#36484F; color:#FFFFFF">サイズ</th>
				<th style="background-color:#36484F; color:#FFFFFF">カラー</th>
			</tr>


				<%
				if (wearList != null) {
					for (int i = 0; i < wearList.size(); i++) {
				%>
			<tr>
				<th style="background-color:#36484F; color:#FFFFFF"><%=wearList.get(i).getId() %></th>
				<th style="background-color:#36484F; color:#FFFFFF"><%=wearList.get(i).getJancode() %></th>
				<th style="background-color:#36484F; color:#FFFFFF">商品名</th>
				<th style="background-color:#36484F; color:#FFFFFF"><%=wearList.get(i).getIntax() %></th>
				<th style="background-color:#36484F; color:#FFFFFF"><%=wearList.get(i).getOuttax() %></th>
				<th style="background-color:#36484F; color:#FFFFFF"><%=wearList.get(i).getPurchase() %></th>
				<th style="background-color:#36484F; color:#FFFFFF">ブランド</th>
				<th style="background-color:#36484F; color:#FFFFFF">サイズ</th>
				<th style="background-color:#36484F; color:#FFFFFF">カラー</th>
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