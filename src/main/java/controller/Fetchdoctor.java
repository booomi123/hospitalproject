package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Hospitaldao;
import dto.Doctor11;


@WebServlet("/fetchdoctor")
public class Fetchdoctor extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Hospitaldao dao=new Hospitaldao();
		List<Doctor11> list=dao.fetchdoctoraprovel();
		if(list.isEmpty()){
			resp.getWriter().print("<h1>no doctor signup</h1>");
			req.getRequestDispatcher("adminhomepage.html").include(req, resp);
	}else{
		req.setAttribute("list", list);
		req.getRequestDispatcher("Aproveldoctor.jsp").forward(req, resp);

}
	}
}
