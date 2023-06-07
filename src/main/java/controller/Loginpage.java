package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor11;
import dto.Staff;
@WebServlet("/login")
public class Loginpage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
	     String	password=req.getParameter("password");
	
	
	Hospitaldao dao=new Hospitaldao();
	Staff staff;
	Doctor11 doctor;
	staff=dao.fetchStaff(id);
	doctor=dao.fetchDoctor(id);
	
	if(staff==null && doctor==null && id!=999999)
	{
		resp.getWriter().print("<h1 style='color:red'>incorent id</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	else{
		if(staff!=null)
	{
			if(staff.getPassword().equals(password)){
				if(staff.isStatus()){
					
				
				resp.getWriter().print("<h1 style='color:green'>login seccess </h1>");
				req.getRequestDispatcher("staffhome.html").include(req, resp);
				}else{
					resp.getWriter().print("<h1 style='color:red'>wait for admin approvel</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				}
				
			}else{
				resp.getWriter().print("<h1 style='color:red'>incurrent password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
	}
	if(doctor!=null){
		if(doctor.getPassword().equals(password)){
if(doctor.isStutas()){
					
				
				resp.getWriter().print("<h1 style='color:green'>login seccess </h1>");
				req.getRequestDispatcher("doctorhome.html").include(req, resp);
				}else{
					resp.getWriter().print("<h1 style='color:red'>wait for admin approvel</h1>");
					req.getRequestDispatcher("login.html").include(req, resp);
				}
				
			resp.getWriter().print("<h1 style='color:green'>login seccess</h1>");
			req.getRequestDispatcher("doctorhome.html").include(req, resp);
			
		}else{
			resp.getWriter().print("<h1 style='color:red'>incurrent password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
		
	}
	if(id==999999){
		if("999999".equals(password)){
			resp.getWriter().print("<h1 style='color:blue'>login seccess </h1>");
			req.getRequestDispatcher("adminhomepage.html").include(req, resp);
			
		}else{
			resp.getWriter().print("<h1 style='color:red'>incurrent password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
	}
	
	}
	

}
