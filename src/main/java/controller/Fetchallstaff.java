package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;

import dto.Staff;

@WebServlet("/fetchstaff")
public class Fetchallstaff extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Hospitaldao dao=new Hospitaldao();
		List<Staff> list=dao.fetchstaffaprovel();
		if(list.isEmpty()){
			resp.getWriter().print("<h1>no staff signup</h1>");
			req.getRequestDispatcher("adminhomepage.html").include(req, resp);
		}else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("Aprovelstaff.jsp").forward(req, resp);
		}
	}

}
