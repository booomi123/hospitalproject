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
@WebServlet("/changedoctorstatuss")
public class Changedoctorstatus extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	Hospitaldao dao=new Hospitaldao();
	Doctor11 s=dao.fetchDoctor(id);
	if(s.isStutas()){
		s.setStutas(false);
	}else{
		s.setStutas(true);
		dao.updateDoctor(s);
		resp.getWriter().print("<h1> updated successfully</h1>");
	   req.setAttribute("list", dao.fetchdoctoraprovel());
	   req.getRequestDispatcher("Aproveldoctor.jsp").include(req, resp);
		
	}

}


}

