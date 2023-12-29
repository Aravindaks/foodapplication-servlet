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
@WebServlet("/delete")
public class DeleteFood extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		FoodItemsCrud crud=new FoodItemsCrud();
		FoodItems food = crud.fetchById(id);
		int owner_id = food.getOwner().getId();
		
		OwnerRegisterCrud ownerCrud= new OwnerRegisterCrud();
		OwnerRegister db = ownerCrud.fetchById(owner_id);
		if(food!=null) {
			crud.deleteFood(food);
			
			List<FoodItems> foodItems = db.getFood();
			req.setAttribute("foodItems", foodItems);
			req.setAttribute("db", db);
			RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
			dis.forward(req, resp);		}
	}
}
