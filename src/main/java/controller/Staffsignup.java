package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Staff;
@WebServlet("/staffsignup")
public class Staffsignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Hospitaldao dao=new Hospitaldao();
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		String gender=req.getParameter("gender");
		Date dob=Date.valueOf(req.getParameter("dob"));
		
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		if(dao.fetchStaff(phone)==null&&dao.fetchStaff(email)==null
				&&dao.fetchDoctor(phone)==null&&dao.fetchDoctor(email)==null){
			Staff staff=new Staff();
		staff.setName(name);
		staff.setPhone(phone);
		staff.setDob(dob);
		staff.setEmail(email);
		staff.setGander(gender);
		staff.setPassword(password);
		staff.setAge(age);
		
		
		dao.savestaff(staff);
		
		
		resp.getWriter().print("<h1><center>staff account create succesfully wait for admin aprovel</center></h1>");
		resp.getWriter().print("<h1><center>your staff id is:"+staff.getId()+"<center></h1>");
	 req.getRequestDispatcher("login.html").include(req, resp);
	}
		else{
			resp.getWriter().print("<h1><center>phone number or  already  exist <center></h1>");
			 req.getRequestDispatcher("login.html").include(req, resp);
		}

	}
}
