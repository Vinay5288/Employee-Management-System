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

@WebServlet("/delete")
public class DeleteEmployeeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		EmployeeDao dao = new EmployeeDao();
		if(dao.deleteEmployeeById(Integer.parseInt(id))) {
			System.out.println("Deleted");
			resp.sendRedirect("display");
		}else {
			System.out.println("Data Not Deleted");
		}
	}
}
