package Quallect.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Quallect.dao.CustomerRegisterCrud;
import Quallect.dao.OwnerRegisterCrud;
import Quallect.dto.CustomerRegister;
import Quallect.dto.OwnerRegister;
@WebServlet("/ForgotPwdCustomer")
public class ForgotPwdCustomer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String pwd1 = req.getParameter("pwd1");
		CustomerRegisterCrud customerCrud=new CustomerRegisterCrud();
		CustomerRegister customer=new CustomerRegister();
		try {
			 CustomerRegister db = customerCrud.fetchByEmail(email);
			if(pwd.equals(pwd1)) {
				customer.setPwd(pwd1);
				customer.setId(db.getId());
				customer.setEmail(email);
				customer.setAddress(db.getAddress());
				customer.setName(db.getName());
				customer.setPhone(db.getPhone());
				customerCrud.update(customer);
				RequestDispatcher dis=req.getRequestDispatcher("CustomerLog.jsp");
				dis.forward(req, resp);
			}
			else {
				req.setAttribute("msg", "both password should be same");
				RequestDispatcher dis=req.getRequestDispatcher("Forgotpwd.jsp");
				dis.include(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("msg", "email wrong");
			RequestDispatcher dis=req.getRequestDispatcher("Forgotpwd.jsp");
			dis.include(req, resp);
		}
	}
}
