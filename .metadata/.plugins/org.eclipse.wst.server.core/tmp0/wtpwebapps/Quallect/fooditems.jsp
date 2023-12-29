<%@page import="Quallect.dto.OwnerRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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

.container1 {
	height: 40px;
/* 	border: 2px solid;
 */	line-height: 5px;
/* 	background-color: rgb(158, 208, 241);
 */	color: #fff;
 	margin-left: 10%;
 
}



#add {
	text-decoration: none;
	position: absolute;
	top: 40px;
	left: 80%;
	font-size: 25px;
	color: #fff;
}
#owner{
	padding-left: 43%;

}

 body{
    background-image: url(https://cdn.pixabay.com/photo/2017/02/15/10/38/background-2068215_1280.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment:fixed;
}
#food input{
position:relative;
left:40%;
	    width: 230px;
    margin-bottom: 15px;
    padding: 10px;
    font-size: 15px;
    border-radius: 5px;
    border: 1px solid gainsboro;
    background-color: rgba(250, 244, 244, 0.7);;
    margin-left: 170px;
    text-align: center;
    outline:none;
	border:none;
    	font-size:18px;
    
}
#description{
position:relative;
left:40%;
	    width: 230px;
    margin-bottom: 15px;
    padding: 10px;
    font-size: 15px;
    border-radius: 5px;
    border: 1px solid gainsboro;
    background-color: rgba(250, 244, 244, 0.7);;
    margin-left: 170px;
    text-align: center;
    outline:none;
	border:none;
	font-size:18px;
}
#food .submit{
	position:relative;
	left:50%;
	width: 100px;
    color:#fff;
    margin-left:110px;
    font-size:20px;
    font-style:italic;
background-image: linear-gradient(240deg, brown, rgb(119, 81, 88),
		rgb(65, 166, 225));    
}
#food div{
	position:relative;
	left:55%;
	width:150px;
	    color:#fff;
	
}
</style>
</head>
<body>
	 <div id="container">
		<h1> <i>QUALLECT</i></h1>
		<p>Quality Selects at your doorstep!</p>
		<a href="RestaurantLog.jsp" id="logout"><i>Logout</i></a>
			
	</div>
	
	
	<% OwnerRegister owner=(OwnerRegister)request.getAttribute("owner"); %>
	<h2 id="owner" class="container1">Restaurant:  <%= owner.getRestaurantname() %></h2>
	<form action="fooditems" method="post" id="form">
	<input type="number" name="owner_id" value="<%= owner.getId()%>" style=visibility:hidden readonly="true">
    <div id="food">
     <div>
		<h3>Add food here.....</h3>
	</div> 
    <input type="text" name="name" required placeholder="Enter Dish_name"><br>

    <textarea id="description" name="description" required placeholder="Enter Description"></textarea><br>

    <input  type="number" name="price" required placeholder="Enter price"><br>
	

    <input class="submit"  type="submit" value="Add"></div>
</form>
	
</body>
</html>