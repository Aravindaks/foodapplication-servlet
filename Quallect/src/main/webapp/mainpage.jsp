<%@page import="Quallect.dto.OwnerRegister"%>
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
*{
margin:0%;
padding:0%;
box-sizing:border-box;
}
#container {
margin:0px;
	border: 2px solid;
	height: 80px;
	background-color: rgb(11, 101, 161);
	color: #fff;
	position:fixed;
	width:100%;
	z-index:1;
}

#container h1 {
	padding-left: 43%;
	padding-top:30px;
	line-height: 10px;
}

#container p {
	padding-left: 0%;
	padding-top:10px;
}

#logout {
	text-decoration: none;
	position: absolute;
	top: 40px;
	left: 92%;
	font-size: 25px;
	color: #fff;
}

#container1 {
margin-top:80px;
	height: 40px;
	border: 2px solid;
	line-height: 5px;
	background-color: rgb(158, 208, 241);
	color: #fff;
	position:fixed;
	width:100%;
	z-index:1;
}

#container1 h2 {
	padding-left: 46%;
	padding-top:20px;
}

#add {
	text-decoration: none;
	position: absolute;
	top: 40px;
	left: 80%;
	font-size: 25px;
	color: #fff;
}

#maindiv {
	margin-left:120%;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	justify-content: space-around;
	height: 160px;
	width: 400px;
	border-radius: 15px;
	background-image: linear-gradient(20deg, purple, rgb(119, 81, 88),
		rgb(65, 166, 225));
		border-radius:20px;
}



.name {
	text-align: center;
	padding-top:20px;
	height: 45px;
	color: #ff9;
	font-weight: bold;
	font-size: 20px;
}

p {
	font-size: 20px;
	text-align: center;
}

.button {
	background-color: rgb(158, 208, 241, 0.6);
	color: #000;
	border: none;
	padding: 10px;
	border-radius: 20px;
	width: 70px;
	text-align: center;
	position: relative;
	margin-left: 50px;
	padding: 10px;
	font-weight: bold;
}

.price {
	background-color: rgb(158, 208, 241, 0.6);
	width: 80px;
	color: #fff;
	text-align: center;
	border-radius: 20px;
	position: relative;
	padding: 10px;
	font-weight: bold;
}

#discription {
	border: 2px;
	height: 50px;
	width: 100%;
	text-align: center;
	padding-top:10px;
	color: #fff;
}

.cardbutton {
	display: flex;
	justify-content: space-evenly;
}

a {
	color: white;
	text-decoration: none;
	font-size: 15px;
}

a:hover {
	text-decoration: underline;
}
#restaurant{
position:absolute;
top:150px;
	height:40px;
	position:fixed;
	display:flex;
}
#restaurant h1{
	padding-left:2%;
	color:#0408e679;
}
#maindiv1{
	position:absolute;
	top:150px;
}
</style>
</head>
<body>
	<div id="container">
		<h1>QUALLECT</h1>
		<p>Quality Selects at your doorstep!</p>
		<a href="RestaurantLog.jsp" id="logout">Logout</a>
		<%
		OwnerRegister db = (OwnerRegister) request.getAttribute("db");
		%>

		<a href="add?id=<%=db.getId()%>" id="add">AddItems</a>
	</div>
	<div id="container1">
		<h2>Welcome</h2>
		<hr style="margin-top:15px;">
		<br>
	</div>
	<div id="restaurant">
		<h2>Restaurant:</h2><h1><%=db.getRestaurantname() %></h1>
	</div>

	<div id="maindiv1"> 
	<%
	List<FoodItems> result = (List<FoodItems>) request.getAttribute("foodItems");
	%>
	<table>
		<tr>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
		for (FoodItems food : result) {
		%>
		<tr>
</div>

			<td>
				<div id="maindiv">
					<div class="container">
						<div class="name">
							<h3><%=food.getDish_name()%></h3>
						</div>
						<div id="discription">
							<p><%=food.getDescription()%></p>
						</div>

						<div class="cardbutton">
							<div class="price">
								Rs.<%=food.getPrice()%></div>
							<div class="button">
								<a href="update?id=<%=food.getId()%>">Update</a>
							</div>
							<div class="button">
								<a href="delete?id=<%=food.getId()%>">Delete</a>
							</div>
						</div>
					</div>
					</div>
			</td>
			

		</tr>
		<%
		}
		%>
	</table>













</body>
</html>