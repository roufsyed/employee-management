package com.rouf.employeeManagement.service.employee;

import com.rouf.employeeManagement.entity.EmployeeEntity;
import com.rouf.employeeManagement.error.EmployeeNotFoundException;
import com.rouf.employeeManagement.model.employee.Employee;
import com.rouf.employeeManagement.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class V2EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			String id = UUID.randomUUID().toString();
			employee.setEmployeeId(id);
		}

		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);

		return employee;
	}


	@Override
	public String removeEmployee(String employeeId) {
		try {
			employeeRepository.deleteById(employeeId);
			return "Employee id : " + employeeId + " removed";
		} catch( Exception e) {
			throw new EmployeeNotFoundException("Employee Not Found with id: " + employeeId);
		}
	}


	@Override
	public List<Employee> displayAllEmployees() {
		List<EmployeeEntity> employeeEntitiesList = employeeRepository.findAll();
		List<Employee> employeeList = employeeEntitiesList.stream()
				.map(employeeEntity -> {
					Employee employee = new Employee();
					BeanUtils.copyProperties(employeeEntity, employee);
					return employee;
				     })
				.collect(Collectors.toList());

		return employeeList;
	}


	@Override
	public Employee displayEmployeeById(String id) {

		List<EmployeeEntity> employeeEntitiesList = employeeRepository.findAll();

		List<Employee> employeeList = employeeEntitiesList.stream()
				.map(employeeEntity -> {
					Employee employee = new Employee();
					BeanUtils.copyProperties(employeeEntity, employee);
					return employee;
				})
				.collect(Collectors.toList());

		for(Employee employee: employeeList) {
			if(employee.getEmployeeId().equals(id)) {
				return employee;
			}
		}

		throw new EmployeeNotFoundException("Employee Not Found with id: " + id);
	}


	@Override
	public String nukeEmployeeList() {
		employeeRepository.deleteAll();
		return "Employee List Nuked.";
	}
}