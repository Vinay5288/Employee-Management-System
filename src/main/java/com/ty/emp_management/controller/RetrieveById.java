package com.ty.emp_management.controller;

import java.io.IOException;

import com.ty.emp_management.dao.EmployeeDao;
import com.ty.emp_management.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/displayById")
public class RetrieveById extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		int empId = Integer.parseInt(req.getParameter("empid"));
		Employee emp = dao.fetchById(empId);
		
		req.setAttribute("employee", emp);
		RequestDispatcher dis = req.getRequestDispatcher("display1.jsp");
		dis.forward(req, resp);
	}
}
