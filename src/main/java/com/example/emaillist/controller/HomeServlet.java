package com.example.emaillist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="home", urlPatterns="/")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, 
						HttpServletResponse resp) throws ServletException, IOException {
		// 홈페이지로 포워딩
		RequestDispatcher rd = 
			req.getRequestDispatcher("/WEB-INF/views/home.jsp");
		rd.forward(req, resp);
	}

}