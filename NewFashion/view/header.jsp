<%@page contentType="text/html; charset=UTF-8" %>

<html>
<head>

<style>

	.box2{

	}
	.left{
		width:25%;
		text-align:center;
		background-color:#FFFFFF;
	}
	.right{
		width:75%;
		text-align:right;
		margin:30px 0px 0px;
		background-color:#FFFFFF;
	}
	.bottom{
		width:100%;
		height:10px;
		background-color:#FFFFFF;
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

	<div class="box2 clearfix">

	<div class="left float-left">
		<a href="<%=request.getContextPath() %>/GrandMenu">
			<img src="menutop.jpg"  alt="ヘッダー" width="250" height="60"></a></div>

		<div class="right float-left">

			<a href="<%=request.getContextPath() %>/view/logincustomer.jsp">ログイン</a>

			<form action="<%=request.getContextPath() %>/FreeSearch">
			フリーワード検索
			<input type="text" name="search" value="">
			<input type="submit" value="検索">

			</form>
		</div>



	</div>

	<div class="bottom"></div>



	<hr style="height:5; background-color:#A7CE02">


</body>

</html>