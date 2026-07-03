
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Management System</title>

<link rel="stylesheet" href="style.css">

</head>

<body>

<div class="welcome-box">

    <h1>Employee Management System</h1>

    <p>
        Welcome to the Employee Management Portal.
        Manage employee records efficiently through the options below.
    </p>

    <div class="action-buttons">

        <a href="EmployeeRegistration.html" class="btn btn-primary">
            Register Employee
        </a>

        <a href="display" class="btn btn-success">
            Display All Employees
        </a>

    </div>

    <br><br>

    <h2>Search Employee</h2>

    <form action="displayById">

        <div class="form-group">

            <label>Employee ID</label>

            <input
                type="text"
                name="empid"
                placeholder="Enter Employee ID"
                required>

        </div>

        <button type="submit" class="btn btn-warning full-width">
            Search Employee
        </button>

    </form>

</div>

</body>
</html>

