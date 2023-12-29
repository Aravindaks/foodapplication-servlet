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

@WebServlet("/cart")
public class CustomerCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		CustomerRegisterCrud customerCrud=new CustomerRegisterCrud();
		CustomerRegister customer = customerCrud.fetchById(Integer.parseInt(id));
		List<FoodItems> food = customer.getFood();
		req.setAttribute("customer", customer);
		req.setAttribute("food", food);
		RequestDispatcher dis = req.getRequestDispatcher("cart.jsp");
		dis.forward(req, resp);
	}
}
