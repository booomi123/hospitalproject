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

import dto.Doctor11;
@WebServlet("/doctor")
public class Docterssignin extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Hospitaldao dao1=new Hospitaldao();

	String doctorname=req.getParameter("name");
	
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	long phone=Long.parseLong(req.getParameter("phone"));
	String gender=req.getParameter("gender");
	Date dob=Date.valueOf(req.getParameter("dob"));
	String qulification=req.getParameter("qulification");
	String specilization=req.getParameter("specilization");
	int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
	
	if(dao1.fetchStaff(phone)==null&&dao1.fetchStaff(email)==null
			&&dao1.fetchDoctor(phone)==null&&dao1.fetchDoctor(email)==null)
	{
	
	Doctor11 dao=new Doctor11();
	dao.setName(doctorname);
	dao.setAge(age);
	dao.setSpecilization(specilization);
	dao.setQulification(qulification);
	dao.setDob(dob);
	dao.setEmail(email);
	dao.setGander(gender);
	dao.setPassword(password);
	dao.setPhone(phone);
	
	dao1.savedoctor(dao);
	resp.getWriter().print("<h1><center>doctor account create succesfully wait for admin aprovel</center></h1>");
	resp.getWriter().print("<h1><center>your doctor id is:"+dao.getId()+"<center></h1>");
    req.getRequestDispatcher("login.html").include(req, resp);
}
	else{
		resp.getWriter().print("<h1><center>phone number or  already  exist <center></h1>");
		 req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}

