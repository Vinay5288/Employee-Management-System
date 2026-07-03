
<%@page import="com.ty.emp_management.entity.Employee"%>
<%@page import="java.util.List"%>
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
List<Employee> emp = (List<Employee>) request.getAttribute("employee");
%>

<div class="container">

    <h1>Employee Directory</h1>

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
                    <th colspan="2">Actions</th>
                </tr>

            </thead>

            <tbody>

            <% for(Employee e : emp){ %>

                <tr>

                    <td><%=e.getEmpid()%></td>
                    <td><%=e.getName()%></td>
                    <td><%=e.getEmail()%></td>
                    <td><%=e.getPassword()%></td>
                    <td><%=e.getAge()%></td>
                    <td><%=e.getGender()%></td>
                    <td><%=e.getDepartment()%></td>
                    <td>₹ <%=e.getSalary()%></td>

                    <td>
                        <a href="update-employee.jsp?id=<%=e.getEmpid()%>"
                           class="btn btn-warning">
                            Update
                        </a>
                    </td>

                    <td>
                        <a href="delete?id=<%=e.getEmpid()%>"
                           class="btn btn-danger"
                           onclick="return confirm('Are you sure you want to delete this employee?')">
                            Delete
                        </a>
                    </td>

                </tr>

            <% } %>

            </tbody>

        </table>

    </div>

    <br>

    <div class="action-buttons">

        <a href="welcome.jsp" class="btn btn-secondary">
            ← Back to Home
        </a>

    </div>

</div>

</body>

</html>

