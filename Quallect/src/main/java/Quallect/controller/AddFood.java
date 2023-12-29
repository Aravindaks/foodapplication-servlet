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
@WebServlet("/add")
public class AddFood extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		OwnerRegisterCrud ownerCrud=new OwnerRegisterCrud();
		OwnerRegister db = ownerCrud.fetchById(id);
		if(db!=null) {
			req.setAttribute("owner", db);
			RequestDispatcher dis = req.getRequestDispatcher("fooditems.jsp");
			dis.forward(req, resp);
		}
		else {
			req.setAttribute("msg", "owner not found");
			RequestDispatcher dis = req.getRequestDispatcher("mainpage.jsp");
			dis.include(req, resp);
		}
		}
}
