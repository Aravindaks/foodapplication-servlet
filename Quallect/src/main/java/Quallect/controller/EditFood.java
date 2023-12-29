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

@WebServlet("/EditFood")
public class EditFood extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String owner_id = req.getParameter("owner_id");
		String id = req.getParameter("id");
		String dish_name = req.getParameter("name");
		String description = req.getParameter("description");
		String price = req.getParameter("price");
		FoodItemsCrud crud=new FoodItemsCrud();
		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		OwnerRegister owner = ownerCrud.fetchById(Integer.parseInt(owner_id));
	
		FoodItems food = new FoodItems(dish_name, description, Double.parseDouble(price));
		
		food.setOwner(owner);
		food.setId(Integer.parseInt(id));
		FoodItems food1 = crud.updateFood(food);
		
		
		
		try {
			List<FoodItems> foodItems = food1.getOwner().getFood();
			OwnerRegister db = food1.getOwner();
			
				req.setAttribute("db", db);
				req.setAttribute("foodItems", foodItems);
				RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
				dis.forward(req, resp);
			
				
			}
		 catch (Exception e) {
			 req.setAttribute("msg", "owner not found");
				RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
				dis.include(req, resp);
		}
		
		
		
	}
}
