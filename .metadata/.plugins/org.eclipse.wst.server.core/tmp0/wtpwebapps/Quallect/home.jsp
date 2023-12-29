<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>

 body{
    background-image: url(https://images.pexels.com/photos/15200485/pexels-photo-15200485.jpeg?cs=srgb&dl=pexels-clayton-de-araujo-15200485.jpg&fm=jpg);
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment:fixed;
}

#container1{
    border: 2px solid black;
    box-shadow: 0px 0px 5px gray;
    margin-left: 400px;
    height: 800px;
    background: rgba(2, 2, 2, 0.3);
    width: 600px;

}
.form button{
    width: 230px;
    margin-bottom: 15px;
    padding: 10px;
    font-size: 15px;
    border-radius: 5px;
    border: 1px solid gainsboro;
    background-color: rgba(250, 244, 244, 0.7);;
    margin-left: 170px;
    text-align: center;
}

.form button{
    width: 253px;
    margin-bottom: 15px;
    color: #fff;
    font-size: 15px;
    font-weight: 400;
    border-radius: 5px;
    border: none;
    padding: 10px;
    background:#166fe5;
    cursor:pointer;
    margin-left: 170px;

}
h1{
    font-family:'Rubik sMoonrocks', sans-serif;    
    color: white;     
    font-weight: lighter; 
    font-size:30px;
    position:relative;
    left:220px;
}

p{
    color: white;
    font-size: 15px;
    position:relative;
    left:190px;
    top:-70px;

}   

hr{
    width: 270px;
    margin-left: 158px;

}
h2{
    font-family:'Rubiks Moonrocks', sans-serif;    
    color: white;     
    font-weight: bold; 
    font-size:15px;
    position:relative;
    left:260px;
}

</style>

</head>
<body>

    <div id="container1">
        <h1>QUALLECT</h1>
         <br><br><br>
        <p>Quality Selects at your doorstep!</p>
        <br>
        <h2>Welcome</h2>
        <br>
        <form class="form"   method="post">
           <button formaction="CustomerLog.jsp" type="submit">Customer</button>
           <button formaction="RestaurantLog.jsp" type="submit">Restaurant Owner</button>
        </form>
        <hr>
        <br>
    
    </div>
</body>
</html>