package Quallect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Quallect.dao.OwnerRegisterCrud;
import Quallect.dto.OwnerRegister;
@WebServlet("/OwnerRegister")
public class OwnerRegisterController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String restaurantname = req.getParameter("restaurantname");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String location = req.getParameter("location");
		String phone = req.getParameter("phone");
		
		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		
		OwnerRegister owner=new OwnerRegister(name,restaurantname,email,pwd,location,Long.parseLong(phone));

		try {
			OwnerRegister data = ownerCrud.save(owner);
			System.out.println(data);
			if(data!=null) {
				RequestDispatcher dis=req.getRequestDispatcher("RestaurantLog.jsp");
				dis.forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("msg", "duplicate email");
			RequestDispatcher dis=req.getRequestDispatcher("RestaurantReg.jsp");
			dis.include(req, resp);
		}
	}	
}
