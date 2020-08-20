<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,manage.Category,manage.Catemenu" %>

<%
ArrayList<Category> categoryList = (ArrayList<Category>)request.getAttribute("category_list");
ArrayList<Catemenu> catemenuList = (ArrayList<Catemenu>)request.getAttribute("catemenu_list");
%>

<html>

	<head>
		<title></title>
		<style>

		</style>
	</head>

	<body>

	<h4 style="text-align:center">カテゴリ</h4>
	<hr style="background-color:#A7CE02"/>

	<table style="margin:0 auto">

	<%
	for (int i = 0; i < categoryList.size(); i++) {
	%>
	<tr>
		<td><a href="<%=request.getContextPath() %>/Test?cmd=<%=categoryList.get(i).getCategoryid() %>">
															<%= categoryList.get(i).getCategoryname() %></a></td>
	</tr>
	<%
	}
	%>

	</table>

	</body>

</html>