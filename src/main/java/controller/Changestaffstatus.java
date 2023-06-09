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
@WebServlet("/changestaffstatus")
public class Changestaffstatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		Hospitaldao dao=new Hospitaldao();
		Staff staff=dao.fetchStaff(id);
		if(staff.isStatus()){
			staff.setStatus(false);
		}else{
			staff.setStatus(true);
			dao.updateStaff(staff);
			resp.getWriter().print("<h1> updated successfully</h1>");
		req.setAttribute("list", dao.fetchstaffaprovel());
		req.getRequestDispatcher("Aprovelstaff.jsp").include(req, resp);
			
		}

	}

}
