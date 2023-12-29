package Quallect.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Quallect.dao.CustomerRegisterCrud;
import Quallect.dao.FoodItemsCrud;
import Quallect.dto.CustomerRegister;
import Quallect.dto.FoodItems;
@WebServlet("/finish")
public class Finish extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String value = req.getParameter("value");
		
		Cart.total.clear();
		Cart.food.clear();
	
		CustomerRegisterCrud dao=new  CustomerRegisterCrud();
		CustomerRegister customer = dao.fetchById(Integer.parseInt(value));
		customer.setFood(null);
		CustomerRegister customer1 = dao.update(customer);
		FoodItemsCrud foodcrud=new FoodItemsCrud();
		List<FoodItems> foodItems = foodcrud.fetchAll();
		req.setAttribute("foodItems", foodItems);
		req.setAttribute("db", customer1);
		req.setAttribute("msg", " Order is sucessfully completed");
	  RequestDispatcher r=req.getRequestDispatcher("end.jsp");
	  r.forward(req, resp);
	}
}
