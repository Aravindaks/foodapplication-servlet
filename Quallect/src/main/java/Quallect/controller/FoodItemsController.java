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

@WebServlet("/fooditems")
public class FoodItemsController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String owner_id = req.getParameter("owner_id");
		String dish_name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		OwnerRegister db = ownerCrud.fetchById(Integer.parseInt(owner_id));
		FoodItems food = new FoodItems(dish_name, description, Double.parseDouble(price));
		FoodItemsCrud crud=new FoodItemsCrud();
		
		FoodItems food1 = crud.save(food);
		food1.setOwner(db);
		FoodItems foodItems1 = crud.updateFood(food1);
		
		try {

			List<FoodItems> foodItems = db.getFood();
			req.setAttribute("foodItems", foodItems);
			req.setAttribute("db", db);
			RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
			dis.forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("msg", "insertion is not possible");
			RequestDispatcher dis = req.getRequestDispatcher("fooditems.jsp");
			dis.include(req, resp);
		}

	}
}
