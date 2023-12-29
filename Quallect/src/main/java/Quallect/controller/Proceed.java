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
import Quallect.dto.CustomerRegister;
import Quallect.dto.FoodItems;

@WebServlet("/proceed")
public class Proceed extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customer_id = req.getParameter("customer");
		String food_id=req.getParameter("id");
		String price=req.getParameter("price");
		CustomerRegisterCrud crud=new CustomerRegisterCrud();
		CustomerRegister customer = crud.fetchById(Integer.parseInt(customer_id));
		List<FoodItems> food = customer.getFood();
		double total = Cart.totalPrice();
		req.setAttribute("total", total);
		req.setAttribute("food", food);
		req.setAttribute("id", Integer.parseInt(customer_id));
		RequestDispatcher dis=req.getRequestDispatcher("Proceed.jsp");
		dis.forward(req, resp);
		
	}


}
