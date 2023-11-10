package com.rouf.employeeManagement.service.employee;

import com.rouf.employeeManagement.model.employee.Employee;

import java.util.List;


public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public String removeEmployee(String employeeId);

	public List<Employee> displayAllEmployees();
	public Employee displayEmployeeById(String id);

	public String nukeEmployeeList();

}
