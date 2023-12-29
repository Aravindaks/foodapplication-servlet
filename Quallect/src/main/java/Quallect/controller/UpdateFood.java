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
import Quallect.dto.FoodItems;
@WebServlet("/update")
public class UpdateFood extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		FoodItemsCrud foodcrud=new FoodItemsCrud();
		FoodItems db = foodcrud.fetchByIdNo(id);
		if(db!=null) {
			req.setAttribute("db", db);
			RequestDispatcher dis = req.getRequestDispatcher("update.jsp");
			dis.forward(req, resp);
		}
		else {
			req.setAttribute("msg", "owner not found");
			RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
			dis.include(req, resp);
		}
	}
}
