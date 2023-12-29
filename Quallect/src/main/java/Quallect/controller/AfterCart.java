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

@WebServlet("/AfterCart")
public class AfterCart extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int customer_id=Integer.parseInt(req.getParameter("customer_id"));
		CustomerRegisterCrud customerCrud=new CustomerRegisterCrud();
		FoodItemsCrud crud= new FoodItemsCrud();
		
		CustomerRegister db = customerCrud.fetchById(customer_id);
		try {
			 List<FoodItems> foodItems = crud.fetchAll();
			 req.setAttribute("db", db);
			 req.setAttribute("foodItems", foodItems);
			 RequestDispatcher dis=req.getRequestDispatcher("MainPageCustomer.jsp");
			 dis.forward(req, resp);
		}catch (Exception e) {
			RequestDispatcher dis = req.getRequestDispatcher("MainPageCustomer.jsp");
			dis.forward(req, resp);
			
		}
		
	}
	}

