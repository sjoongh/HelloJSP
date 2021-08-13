<%@page import="com.example.emaillist.vo.EmailVo"%>
<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	파라미터 받아오기
	String lastName = request.getParameter("last_name");
	String firstName = request.getParameter("first_name");
	String email = request.getParameter("email");
	//	파라미터 확인
	//	DAO
	EmaillistDao dao = new EmaillistDaoImpl();
	
	//	Vo 객체 생성
	EmailVo vo = new EmailVo();
	vo.setLastName(lastName);
	vo.setFirstName(firstName);
	vo.setEmail(email);
	
	dao.insert(vo);
	
	//	index.jsp로 리다이렉트(페이지 전환: 302)
	response.sendRedirect(request.getContextPath() + "/emaillist/");
%>