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
@WebServlet("/ForgotPwdOwner")
public class ForgotPwdOwner extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String pwd1 = req.getParameter("pwd1");
		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		OwnerRegister owner=new OwnerRegister();
		try {
			  OwnerRegister db = ownerCrud.fetchByEmail(email);
			if(pwd.equals(pwd1)) {
				owner.setPwd(pwd1);
				owner.setId(db.getId());
				owner.setEmail(email);
				owner.setName(db.getName());
				owner.setPhone(db.getPhone());
				owner.setLocation(db.getLocation());
				owner.setRestaurantname(db.getRestaurantname());
				owner.setFood(db.getFood());
				ownerCrud.update(owner);
				RequestDispatcher dis=req.getRequestDispatcher("RestaurantLog.jsp");
				dis.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "both password should be same");
				RequestDispatcher dis=req.getRequestDispatcher("RestaurantForgotPwd.jsp");
				dis.include(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("msg", "email wrong");
			RequestDispatcher dis=req.getRequestDispatcher("RestaurantForgotPwd.jsp");
			dis.include(req, resp);
		}
		}
}
