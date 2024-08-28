package com.crimsonlogic.servletwithhibernate.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crimsonlogic.servletwithhibernate.dao.StudentDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao = new StudentDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		studentDao.insertIntoStudent(request, response);
	}
}
