<%@page import="java.util.List"%>
<%@page import="Quallect.dto.CustomerRegister"%>
<%@page import="Quallect.dto.FoodItems"%>
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
    background-image: url(https://cdn.pixabay.com/photo/2022/05/17/05/08/biryani-7201670_1280.jpg);
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
</style>
<body>

<div id="container">
		<h1> <i>QUALLECT</i></h1>
		<p>Quality Selects at your doorstep!</p>
		<a href="CustomerLog.jsp" id="logout"><i>Logout</i></a>
			
	</div>
<%List<FoodItems> food=(List<FoodItems>)request.getAttribute("food");
	CustomerRegister customer=(CustomerRegister)request.getAttribute("customer");
%>
 <div>
	 <h1 id="custom"><%=customer.getName() %></h1>
	 </div>
<form action="proceed" method="post">
		<table>
		<tr>	
			<th class="dish">Dish_Name </th>
						<th class="dish">Price </th>
				<th></th>		
		
		</tr>
		
		<%for(FoodItems items: food){ %>
		<tr>
				
			
				<td><input type="text" name="name" value=<%=items.getDish_name()%>
					readonly="readonly"></td>
		
			
			
			
				<td><input type="number" name="price"
					value=<%=items.getPrice()%> readonly="readonly"></td>
					<td><input type="number" name="id"
					value=<%=items.getId()%> readonly="readonly" style="visibility:hidden"></td>
				
			<%} %>
			<tr>
				<input type="text" name="customer" style="visibility:hidden" value="<%=customer.getId()%>">
			
				<td><input id="submit" type="submit" value="Place Order"></td>
			</tr>
		</table>
	</form>



</body>
</html>