package com.examples.attsw.exercise.core.controller;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.examples.attsw.exercise.core.model.Employee;
import com.examples.attsw.exercise.core.service.IEmployeeService;

public class EmployeeControllerTest {

	public EmployeeController employeeController;
	private List<Employee> employees;
	private IEmployeeService iEmployeeService;

	@Before
	public void setUp() throws Exception {
		iEmployeeService = Mockito.mock(IEmployeeService.class);
		employeeController = new EmployeeController(iEmployeeService);
		employees = new LinkedList<Employee>();
		Mockito.when(iEmployeeService.getEmployees()).thenReturn(employees);
	}

	@Test
	public void testGetAllEmployeeWhenThereAreNoEmployee() {
		assertGetAllEmployee("");
	}

	@Test
	public void testGetAllEmployeeWhenThereIsOneEmployee() {
		Employee employee = new Employee("nameTest");
		employees.add(employee);
		assertGetAllEmployee(employee.getName());
	}

	private void assertGetAllEmployee(String expected) {
		String allEmployee = employeeController.getAllEmployee();
		assertEquals(expected, allEmployee);
	}

}
