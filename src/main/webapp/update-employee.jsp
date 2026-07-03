```jsp
<%@page import="com.ty.emp_management.entity.Employee"%>
<%@page import="com.ty.emp_management.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Update Employee</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<%
    int empid = Integer.parseInt(request.getParameter("id"));
    EmployeeDao dao = new EmployeeDao();
    Employee emp = dao.fetchById(empid);
%>

<div class="container form-container">

    <h1>Update Employee</h1>

    <form action="updateEmployee">

        <div class="form-group">
            <label>Employee ID</label>
            <input type="text"
                   name="empid"
                   value="<%=emp.getEmpid()%>"
                   readonly>
        </div>

        <div class="form-group">
            <label>Employee Name</label>
            <input type="text"
                   name="name"
                   value="<%=emp.getName()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Email Address</label>
            <input type="email"
                   name="email"
                   value="<%=emp.getEmail()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password"
                   name="password"
                   value="<%=emp.getPassword()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Age</label>
            <input type="number"
                   name="age"
                   value="<%=emp.getAge()%>"
                   required>
        </div>

        <div class="form-group">

            <label>Gender</label>

            <div class="radio-group">

                <label>
                    <input type="radio"
                           name="gender"
                           value="male"
                           <%= "male".equalsIgnoreCase(emp.getGender()) ? "checked" : "" %>>
                    Male
                </label>

                <label>
                    <input type="radio"
                           name="gender"
                           value="female"
                           <%= "female".equalsIgnoreCase(emp.getGender()) ? "checked" : "" %>>
                    Female
                </label>

            </div>

        </div>

        <div class="form-group">
            <label>Salary</label>
            <input type="text"
                   name="salary"
                   value="<%=emp.getSalary()%>"
                   required>
        </div>

        <div class="form-group">
            <label>Department</label>
            <input type="text"
                   name="department"
                   value="<%=emp.getDepartment()%>"
                   required>
        </div>

        <button type="submit"
                class="btn btn-success full-width">
            Update Employee
        </button>

    </form>

    <br>

    <div class="action-buttons">

        <a href="display" class="btn btn-primary">
            Employee List
        </a>

        <a href="welcome.jsp" class="btn btn-secondary">
            Home
        </a>

    </div>

</div>

</body>

</html>
```
