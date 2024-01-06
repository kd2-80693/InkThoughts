package com.app.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.dao.ThoughtDao;
import com.app.dao.ThoughtDaoImpl;
import com.app.entity.Thought;
import com.app.utils.HibernateUtils;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ThoughtDao dao = new ThoughtDaoImpl();
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Long thoughtId = Long.parseLong(request.getParameter("thoughtId").trim());
			dao.update(new Thought(title , content , LocalDateTime.now()), thoughtId);
			response.sendRedirect("all_thoughts.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
