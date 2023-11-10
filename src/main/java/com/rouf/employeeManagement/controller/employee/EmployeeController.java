package com.rouf.employeeManagement.controller.employee;

import com.rouf.employeeManagement.model.employee.Employee;
import com.rouf.employeeManagement.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/v1/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeServiceImplementation")
	EmployeeService employeeService;

	@PostMapping("/add-employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@PostMapping("/remove-employee")
	public String removeEmployee(@RequestBody String employeeId) {
		return employeeService.removeEmployee(employeeId);
	}

	@GetMapping("/get-all-employees")
	public List<Employee> getAllEmployees() {
		return employeeService.displayAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.displayEmployeeById(id);
	}

	@DeleteMapping("/nuke-employee-list")
	public String nukeEmployeeList() {
		return employeeService.nukeEmployeeList();
	}

}
