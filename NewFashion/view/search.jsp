<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Brand,manage.Catedetail,manage.Size,manage.Color" %>
<%
ArrayList<Brand> brandList = (ArrayList<Brand>)request.getAttribute("brand_list");
ArrayList<Catedetail> catedetailList = (ArrayList<Catedetail>)request.getAttribute("catedetail_list");
ArrayList<Size> sizeList = (ArrayList<Size>)request.getAttribute("size_list");
ArrayList<Color> colorList = (ArrayList<Color>)request.getAttribute("color_list");
%>

<form action="<%=request.getContextPath() %>/WearSearch">
	<h3>全体検索</h3>

	<select name="brandid">
		<option style="color:#DCDCDC" value="">ブランド</option>
		<%
		for (int a = 0; a < brandList.size(); a++) {
		%>
		<option value="<%=brandList.get(a).getBrandid() %>"><%=brandList.get(a).getBrandname() %></option>
		<%
		}
		%>
	</select>

	<select name="catedetailid">
		<option style="color:#DCDCDC" value="">服分類</option>
		<%
		for (int b = 0; b < catedetailList.size(); b++) {
		%>
		<option value="<%=catedetailList.get(b).getCatedetailid() %>"><%=catedetailList.get(b).getCatedetailname() %></option>
		<%
		}
		%>
	</select>

	<select name="sizeid">
		<option style="color:#DCDCDC" value="">サイズ</option>
		<%
		for (int c = 0; c < sizeList.size(); c++) {
		%>
		<option value="<%=sizeList.get(c).getSizeid() %>"><%=sizeList.get(c).getSizename() %></option>
		<%
		}
		%>
	</select>

	<select name="colorid">
		<option style="color:#DCDCDC" value="">カラー</option>
		<%
		for (int d = 0; d < colorList.size(); d++) {
		%>
		<option value="<%=colorList.get(d).getColorid() %>"><%=colorList.get(d).getColorname() %></option>
		<%
		}
		%>
	</select>

		<input type="submit" value="検索">
</form>