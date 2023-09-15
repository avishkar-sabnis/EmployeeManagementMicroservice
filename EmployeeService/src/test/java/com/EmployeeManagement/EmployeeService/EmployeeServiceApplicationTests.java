package com.EmployeeManagement.EmployeeService;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceApplicationTests {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeDAO employeeDAO;

	@Test
	public void getAllEmployeesTest(){
		Mockito.when(employeeDAO.findAll()).thenReturn(Stream.of(new Employee(5,
				"Avishkar",100.00,10.0,"Consultant")
		).collect(Collectors.toList()));
		assertEquals(1,employeeService.getAllEmployees().size());
	}









}
