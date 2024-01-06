package com.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.ThoughtDao;
import com.app.dao.ThoughtDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long deleteId = Long.parseLong(request.getParameter("thought_id").trim());
		ThoughtDao dao = new ThoughtDaoImpl();
		dao.delete(deleteId);
		response.sendRedirect("all_thoughts.jsp");
	}

}
