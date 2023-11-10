package com.rouf.employeeManagement.service.employee;

import com.rouf.employeeManagement.error.EmployeeNotFoundException;
import com.rouf.employeeManagement.model.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImplementation implements EmployeeService{

	List<Employee> employeeList = new ArrayList<>();

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			String id = UUID.randomUUID().toString();
			employee.setEmployeeId(id);
		}
		employeeList.add(employee);
		return employee;
	}


	@Override
	public String removeEmployee(@RequestBody String employeeId) {
		if (employeeId == null || employeeId.isEmpty()) {
			throw new RuntimeException("Empty body found");
		} else {
			for(Employee employee : employeeList) {
				if(employee.getEmployeeId().equals(employeeId)) {
					employeeList.remove(employee);
					return "Employee id : " + employeeId + " removed";
				}
			}
		}

		throw new EmployeeNotFoundException("Employee Not Found with id: " + employeeId);
	}


	@Override
	public List<Employee> displayAllEmployees() {
		return employeeList;
	}


	@Override
	public Employee displayEmployeeById(String id) {

		for (Employee employee: employeeList) {
			if(employee.getEmployeeId().equals(id)){
				return employee;
			}
		}

		Employee notFoundEmployee = new Employee();
		notFoundEmployee.setEmployeeId("-");
		notFoundEmployee.setName("-");
		notFoundEmployee.setDepartment("-");
		notFoundEmployee.setEmailId("-");

		return notFoundEmployee;
	}


	@Override
	public String nukeEmployeeList() {
		employeeList.clear();
		return "Employee List Nuked.";
	}
}
