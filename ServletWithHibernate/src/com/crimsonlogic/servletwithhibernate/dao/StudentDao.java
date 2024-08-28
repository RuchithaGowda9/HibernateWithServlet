package com.crimsonlogic.servletwithhibernate.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crimsonlogic.servletwithhibernate.entity.HibernateUtils;
import com.crimsonlogic.servletwithhibernate.entity.StudentInfo;

public class StudentDao {
	public void insertIntoStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Transaction transaction = null;
		try (Session dbSession = HibernateUtils.getSessionFactory().openSession()) {
			String studentName = request.getParameter("name");
			String email = request.getParameter("email");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			StudentInfo st = new StudentInfo();
			st.setStudentName(studentName);
			st.setStudentEmail(email);
			st.setUsername(userName);
			st.setPassword(password);

			transaction = dbSession.beginTransaction();
			dbSession.save(st);
			transaction.commit();

			request.setAttribute("NOTIFICATION", "User Registered Successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // Consider using a logger instead
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
	}
}
