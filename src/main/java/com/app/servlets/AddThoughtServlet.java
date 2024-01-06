package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.dao.ThoughtDao;
import com.app.dao.ThoughtDaoImpl;
import com.app.entity.Thought;

@WebServlet("/AddThoughtServlet")
public class AddThoughtServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// title,content fetch
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Thought thought = new Thought(title, content, LocalDateTime.now());
			ThoughtDao dao = new ThoughtDaoImpl();
			dao.saveThought(thought);
			response.sendRedirect("added.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
