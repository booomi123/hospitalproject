package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor11;
import dto.Staff;
@WebServlet("/reset")
public class Reset extends HttpServlet {
	@Override
			protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
			{
				int id=Integer.parseInt(req.getParameter("ID"));
				String name=req.getParameter("Name");
				long mobile=Long.parseLong(req.getParameter("mobilenum"));
				Date DOB=Date.valueOf(req.getParameter("Birth"));
				String pwd=req.getParameter("pwd");
				
				Hospitaldao h=new Hospitaldao();
				Staff s=h.fetchStaff(id);
				Doctor11 d=h.fetchDoctor(id);
				
				if(s==null && d==null)
				{
					resp.getWriter().print("<h1> Invalid ID</h1>");
					req.getRequestDispatcher("ForgotPassword.html").include(req, resp);

				}
				else
				{
					if(d!=null )
					{
						if(d.getName().equals(name) && d.getDob().equals(DOB) && d.getPhone()==mobile)
						{
							d.setPassword(pwd);
							h.updateDoctor(d);
							resp.getWriter().print("<h1>Updated Successfully</h1>");
							req.getRequestDispatcher("LogIn.html").include(req, resp);
						}
						else
						{
							resp.getWriter().print("<h1 style='color:yellow'>Invalid Details</h1>");
							req.getRequestDispatcher("ForgotPassword.html").include(req, resp);
						}
					}
					else 
					{
						if(s.getDob().equals(DOB) && s.getName().equals(name) && s.getPhone()==mobile)
						{
							s.setPassword(pwd);
							h.updateStaff(s);
							resp.getWriter().print("<h1>Updated Successfully</h1>");
							req.getRequestDispatcher("LogIn.html").include(req, resp);
						}
						else
						{
							resp.getWriter().print("<h1 style='color:green'>Invalid Details</h1>");
							req.getRequestDispatcher("ForgotPassword.html").include(req, resp);
						}
					}
				}
			}
		}

