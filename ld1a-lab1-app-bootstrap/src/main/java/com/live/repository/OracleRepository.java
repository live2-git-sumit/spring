package com.live.repository;

import java.util.ArrayList;
import java.util.List;

import com.live.model.Employee;

public class OracleRepository implements EmployeeRepository {

	@Override
	public List<Employee> getEmployee()  {
		System.out.println("Oracle Repository");
		List<Employee> employees = new ArrayList<>();

		Employee employee = new Employee();

		employee.setEmployeeId("1002");
		employee.setEmployeeName("Laxman Oracle");

		employees.add(employee);
		
		return employees;
	}

}
