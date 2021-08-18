package com.example.emaillist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class CookieTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		
		if ("delete".equals(actionName)) {
			// 쿠키 삭제
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie: cookies) {
					if (cookie.getName().equals("example")) {
						// 쿠키는 삭제할 수 없다 -> 무효화
						Cookie jcookie = new Cookie("example", ""); // 빈 값으로 만듬
						jcookie.setMaxAge(0); // 지속시간을 0으로 만듬
						resp.addCookie(jcookie);
						break;
					}
				}
			}
		} else {
			// 쿠키 읽어오기
			Cookie[] cookies = req.getCookies();
			// 체크
			if (cookies != null) {
				// 쿠키가 있다!
				for (Cookie cookie: cookies) {
					String name = cookie.getName(); // 쿠키 이름
					String value = cookie.getValue(); // 쿠키 값
					int maxAge = cookie.getMaxAge(); // 쿠키 지속 시간 (초)
					
					System.out.printf("%s - %s, %d%n",
							name, value, maxAge);
					
					if (cookie.getName().equals("example")) {
						// JSP에 값을 전달(Attr)
						req.setAttribute("example", value);
					}
				}
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/cookies/cookie_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 쿠키 세팅
		String value = req.getParameter("example");
		System.out.println("설정할 쿠키 값:" + value);
		
		// 쿠키 생성
		Cookie jcookie = new Cookie("example", value);
		// 쿠키를 브라우저에 설정: 응답객체에 추가
		resp.addCookie(jcookie);
		
		// 응답 전송
		resp.sendRedirect(req.getContextPath() + "/cookies");
	}
	
}
