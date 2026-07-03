package com.ty.emp_management.controller;

import java.io.IOException;

import com.ty.emp_management.dao.EmployeeDao;
import com.ty.emp_management.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterEmployeeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * read form data using getParameter
		 */
		String empid=req.getParameter("empid"),
				name=req.getParameter("name"),
				email=req.getParameter("email"),
				password=req.getParameter("password"),
				age=req.getParameter("age"),
				gender=req.getParameter("gender"),
				department=req.getParameter("department"),
				salary=req.getParameter("salary");
		
//		System.out.println(empid+" "+name+" "+email+" "+password+" "+gender+" "+salary);
		Employee e = new Employee();
		e.setEmpid(Integer.parseInt(empid));
		e.setName(name);
		e.setEmail(email);  
		e.setPassword(password);
		e.setAge(Integer.parseInt(age));
		e.setGender(gender);
		e.setDepartment(department);
		e.setSalary(Double.parseDouble(salary));
		/*
		 * Call register Method
		 */
		EmployeeDao dao = new EmployeeDao();
		if(dao.saveEmployee(e)) {
			resp.sendRedirect("welcome.jsp");
		}else {
			System.out.println("Data is failed to insert");
		}
	}
}
