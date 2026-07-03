
<%@page import="com.ty.emp_management.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Employee Details</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<%
Employee emp = (Employee) request.getAttribute("employee");
%>

<div class="container">

    <h1>Employee Details</h1>

    <div class="table-container">

        <table>

            <thead>

                <tr>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th>Salary</th>
                </tr>

            </thead>

            <tbody>

                <tr>

                    <td><%=emp.getEmpid()%></td>
                    <td><%=emp.getName()%></td>
                    <td><%=emp.getEmail()%></td>
                    <td><%=emp.getPassword()%></td>
                    <td><%=emp.getAge()%></td>
                    <td><%=emp.getGender()%></td>
                    <td><%=emp.getDepartment()%></td>
                    <td>₹ <%=emp.getSalary()%></td>

                </tr>

            </tbody>

        </table>

    </div>

    <br>

    <div class="action-buttons">

        <a href="display" class="btn btn-primary">
            View All Employees
        </a>

        <a href="welcome.jsp" class="btn btn-secondary">
            Back to Home
        </a>

    </div>

</div>

</body>

</html>

