package Quallect.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Quallect.dao.FoodItemsCrud;
import Quallect.dao.OwnerRegisterCrud;
import Quallect.dto.FoodItems;
import Quallect.dto.OwnerRegister;
@WebServlet("/ownerlogin")
public class OwnerLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		FoodItemsCrud foodcrud=new FoodItemsCrud();

		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		try {
			OwnerRegister db=ownerCrud.fetchByEmail(email);
			if(db.getPwd().equals(pwd)){
//				List<FoodItems> foodItems = foodcrud.fetchById(db.getId());
				List<FoodItems> foodItems = db.getFood();
				req.setAttribute("foodItems", foodItems);
				req.setAttribute("db", db);
				RequestDispatcher dis=req.getRequestDispatcher("mainpage.jsp");
				dis.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "Password is wrong");
				RequestDispatcher dis=req.getRequestDispatcher("RestaurantLog.jsp");
				dis.include(req, resp);
			}

		} catch (Exception e) {
			req.setAttribute("msg", "email is wrong");
			RequestDispatcher dis=req.getRequestDispatcher("RestaurantLog.jsp");
			dis.include(req, resp);
		}

	}
}
