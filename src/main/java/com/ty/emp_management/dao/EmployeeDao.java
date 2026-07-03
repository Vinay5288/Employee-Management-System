package com.ty.emp_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ty.emp_management.dbconnection.DBConnection;
import com.ty.emp_management.entity.Employee;

public class EmployeeDao {
	/*
	 * Method to save the record
	 */
	Connection con = DBConnection.getConnection();

	public boolean saveEmployee(Employee e) {
		String insertQuery="insert into employee values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, e.getEmpid());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setInt(5, e.getAge());
			ps.setString(6, e.getGender());
			ps.setString(7, e.getDepartment());
			ps.setDouble(8, e.getSalary());
			int row = ps.executeUpdate();
			return row>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	public List<Employee> fetchEmployee(){
		String query = "select * from employee";
		List<Employee> list = new ArrayList<Employee>();
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setEmpid(rs.getInt("empid"));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setAge(rs.getInt(5));
				emp.setGender(rs.getString(6));
				emp.setDepartment(rs.getString(7));
				emp.setSalary(rs.getDouble(8));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Employee fetchById(int id) {
		String sql = "select * from employee where empid = ?";
		Employee emp =new Employee();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp.setEmpid(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPassword(rs.getString(4));
				emp.setAge(rs.getInt(5));
				emp.setGender(rs.getString(6));
				emp.setDepartment(rs.getString(7));
				emp.setSalary(rs.getDouble(8));
			}
			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateEmployee(Employee emp) {
		String sql = "update employee set name=?, email=?, password=?, age=?, gender=?, department=?, salary=? where empid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getGender());
			ps.setString(6, emp.getDepartment());
			ps.setDouble(7, emp.getSalary());
			ps.setInt(8, emp.getEmpid());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	public boolean deleteEmployeeById(int id) {
		String sql = "Delete from Employee where empid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
