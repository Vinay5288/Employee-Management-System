package com.ty.emp_management.controller;

import java.io.IOException;
import java.util.List;

import com.ty.emp_management.dao.EmployeeDao;
import com.ty.emp_management.entity.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class RetrieveEmployeeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchEmployee();
		/*
		 * To print data in console
		 */
//		for(Employee emp : list) {
//			System.out.println(emp.getAge());
//		}
		
		/*
		 * Send data to front End
		 */
		
		req.setAttribute("employee", list);
		RequestDispatcher dis = req.getRequestDispatcher("display.jsp");
		dis.forward(req, resp);
	}
}
