<%@page import="Quallect.dto.FoodItems"%>
<%@page import="java.util.List"%>
<%@page import="Quallect.dto.CustomerRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body{
    background-image: url(https://cdn.pixabay.com/photo/2014/06/04/16/41/thank-you-362164_1280.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment:fixed;
}
#container {
/* 	border: 2px solid;
 */	height: 80px;
/* 	background-color: rgb(11, 101, 161);
 */	color: #fff;
}

#container h1 {
	padding-left: 40%;
	line-height: 10px;
}

#container p {
	padding-left: 39%;
}

#logout {
	text-decoration: none;
	position: absolute;
	top: 40px;
	left: 92%;
	font-size: 25px;
	color: #fff;
}
.dish{
font-size: 25px;
	color: #fff;
}
input{
background-color:#2F415D;
    text-align: center;
font-size:20px;
color:#fff;
outline:none;
border:none;
}
#custom{
	color:#fff;
}
#submit{
	width:150px;
	position:relative;
	left:65%;
	color:#681DA9;
	background-color:#fff;
	border-radius:20px;
	cursor:pointer;
}
#add {
	text-decoration: none;
	position: absolute;
	top: 40px;
	left: 80%;
	font-size: 25px;
	color: #fff;
}
</style>
<body>
<%String str=(String)request.getAttribute("msg"); %>
		<%CustomerRegister customer=(CustomerRegister)request.getAttribute("db"); 
			   List<FoodItems> result = (List<FoodItems>) request.getAttribute("foodItems");
		%>
<div id="container">
		<h1> <i>QUALLECT</i></h1>
		<p>Quality Selects at your doorstep!</p>
		<a href="CustomerLog.jsp" id="logout"><i>Logout</i></a>
					<a href="AfterCart?customer_id=<%=customer.getId()%>" id="add">Home</a>
			
	</div>


<h1 style="color:#fff"><%=str %></h1>

</body>
</html>