<%@page contentType="text/html; charset=UTF-8" %>

<html>

	<head>
		<title>商品管理システム</title>
		<style>
		.img-slide{
			width:980px;
			margin:50px auto;
			position:relative;
			text-align:center;
		}
		.img-slide img{
			position:absolute;
			background-color:#FFFFFF;
			box-shadow:5px 5px 5px #DDDDDD;
			border:1px solid #DDDDDD;
			pading:8px;
		}
		.img1{
			-webkit-animation:slide 16s ease 0s infinite normal
		}
		.img2{
			-webkit-animation:slide 16s ease -4s infinite normal
		}
		.img3{
			-webkit-animation:slide 16s ease -8s infinite normal
		}
		.img4{
			-webkit-animation:slide 16s ease -12s infinite normal
		}
		@-webkit-keyframes slide{
			0% {top:20px; left:200px; width:480px; z-index:4;}
			20% {top:20px; left:200px; width:480px; z-index:4;}
			25% {top:50px; left:480px; width:400px; z-index:3;}
			45% {top:50px; left:480px; width:400px; z-index:3;}
			50% {top:50px; left:200px; width:400px; z-index:1;}
			70% {top:50px; left:200px; width:400px; z-index:1;}
			75% {top:50px; left:0px; width:400px; z-index:3;}
			95% {top:50px; left:0px; width:400px; z-index:3;}
			100% {top:20px; left:200px; width:480px; z-index:4;}
		}
		</style>
	</head>

	<body>

		<div class="img-slide">

		<a href="<%=request.getContextPath() %>/Test">
			<img src="one.jpg" alt="特集１" class="img1" width="250" height="250"></a>
		<a href="<%=request.getContextPath() %>/Test">
			<img src="ops.jpg" alt="特集２" class="img2" width="250" height="250"></a>
		<a href="<%=request.getContextPath() %>/Test">
			<img src="summer.jpg" alt="特集３" class="img3" width="250" height="250"></a>
		<a href="<%=request.getContextPath() %>/Test">
			<img src="twin.jpg" alt="特集４" class="img4" width="250" height="250"></a>

		</div>

	</body>

</html>