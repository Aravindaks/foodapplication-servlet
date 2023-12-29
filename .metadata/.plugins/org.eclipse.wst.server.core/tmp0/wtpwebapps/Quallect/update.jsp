<%@page import="Quallect.dto.FoodItems"%>
<%@page import="Quallect.dto.OwnerRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% FoodItems db=(FoodItems)request.getAttribute("db"); %>
	<form action="EditFood" method="post">
	<label for="owner_id">Owner_id</label>
	<input type="number" name="owner_id" value="<%= db.getOwner().getId()%>" readonly="true"><br>
     <label for="Food_id">Food_id:</label>
	<input type="number" name="id" value="<%= db.getId()%>" readonly="true"><br>
    <label for="name">Dish_Name:</label>
    <input type="text" name="name"   value="<%= db.getDish_name()%>" ><br>

    <label for="description">Description:</label>
    <textarea name="description"  value="<%= db.getDescription()%>" ></textarea><br>

    <label for="price">Price:</label>
    <input type="number" name="price" value="<%= db.getPrice()%>" ><br>
	

    <input type="submit" value="UPDATE">
</form>
</body>
</html>