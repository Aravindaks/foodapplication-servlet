package Quallect.controller;

import java.util.ArrayList;
import java.util.List;

import Quallect.dao.CustomerRegisterCrud;
import Quallect.dao.FoodItemsCrud;
import Quallect.dto.CustomerRegister;
import Quallect.dto.FoodItems;

public class Cart {
	static ArrayList<FoodItems> food=new ArrayList<FoodItems>();
	static ArrayList<Double> total=new ArrayList<Double>();
//
//	public static void Count(Double price) {
//		total.add(price);
//	}
	public static void addcart(CustomerRegister customer, int id) {
		CustomerRegisterCrud customerCrud=new CustomerRegisterCrud();
		FoodItemsCrud foodCrud=new FoodItemsCrud();
		
		FoodItems food1 = foodCrud.fetchById(id);
		food.add(food1);
		customer.setFood(food);
		CustomerRegister customer1 = customerCrud.update(customer);
		List<FoodItems> list = customer1.getFood();
		for(FoodItems foodItems : list) {
			total.add(foodItems.getPrice());
		}
	}
	public static double totalPrice() {
		double t=0;
		for(Double i : total) {
			t = t+i;
		}
		return t;
	}

}
