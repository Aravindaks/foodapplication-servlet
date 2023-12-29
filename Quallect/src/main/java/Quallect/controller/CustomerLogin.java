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
@WebServlet("/userlogin")
public class CustomerLogin extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		FoodItemsCrud foodcrud=new FoodItemsCrud();

		CustomerRegisterCrud crud=new CustomerRegisterCrud();
		try {
			 CustomerRegister db = crud.fetchByEmail(email);
			if(db.getPwd().equals(pwd)){
				List<FoodItems> foodItems = foodcrud.fetchAll();
				req.setAttribute("foodItems", foodItems);
				req.setAttribute("db", db);
				RequestDispatcher dis=req.getRequestDispatcher("MainPageCustomer.jsp");
				dis.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Password is wrong");
				RequestDispatcher dis=req.getRequestDispatcher("CustomerLog.jsp");
				dis.include(req, resp);
			}

		} catch (Exception e) {
			req.setAttribute("msg", "email is wrong");
			RequestDispatcher dis=req.getRequestDispatcher("CustomerLog.jsp");
			dis.include(req, resp);
		}
	}
}
