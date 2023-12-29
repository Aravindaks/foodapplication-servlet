<%@page import="Quallect.controller.Cart"%>
<%@page import="Quallect.dto.FoodItems"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
    background-image: url(https://cdn.pixabay.com/photo/2020/04/23/16/23/cafe-5083130_1280.jpg);
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
	position:absolute;
	color:#fff;
	background-color:#2F415D;
	border-radius:20px;
	cursor:pointer;
	font-size:25px;
	font-style:italic;
}
</style>
</head>
<body>
<div id="container">
		<h1> <i>QUALLECT</i></h1>
		<p>Quality Selects at your doorstep!</p>
		<a href="CustomerLog.jsp" id="logout"><i>Logout</i></a>
			
	</div>
<% 
List<FoodItems> items=(List<FoodItems>)request.getAttribute("food");
int customer=(int)request.getAttribute("id");
double total=(double)request.getAttribute("total");
%>

<%for(FoodItems food:items){ %>
 
<%} %>

<h1 style="color:#fff"> The total Amount is  :<%=total %></h1>

<form action="finish" method="post">
  <input type="text" name="value"  style="visibility: hidden;" value="<%=customer%>">
  <input id="submit" type="submit" value="Proceed">
</form>
</body>
</html>