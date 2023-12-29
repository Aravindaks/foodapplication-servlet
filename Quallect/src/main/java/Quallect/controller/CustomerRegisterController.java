package Quallect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Quallect.dao.CustomerRegisterCrud;
import Quallect.dto.CustomerRegister;
@WebServlet("/CustomerRegister")
public class CustomerRegisterController  extends HttpServlet{
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		CustomerRegisterCrud crud=new CustomerRegisterCrud();
		CustomerRegister customer=new CustomerRegister(name,email,pwd,address,Long.parseLong(phone));

		try {
			 CustomerRegister data = crud.save(customer);
			System.out.println(data);
			if(data!=null) {
				RequestDispatcher dis=req.getRequestDispatcher("CustomerLog.jsp");
				dis.forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("msg", "duplicate email");
			RequestDispatcher dis=req.getRequestDispatcher("RestaurantReg.jsp");
			dis.include(req, resp);
		}
	}	
}
