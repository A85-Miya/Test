<%@page contentType="text/html; charset=UTF-8" %>

<%
String error = (String)request.getAttribute("error");
%>

<html>

	<head>
		<title>エラー</title>
	</head>

	<body>
		<%@include file="header.jsp" %>


		<div style="text-align:center">
			<h3>●●エラー●●</h3>
			<%=error %>

			<a href="<%=request.getContextPath() %>/GrandMenu">[メニューへ戻る]</a>
		</div>

		<%@include file="footer.jsp" %>
	</body>

</html>