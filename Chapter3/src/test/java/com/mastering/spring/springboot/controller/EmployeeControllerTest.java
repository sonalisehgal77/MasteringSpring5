package com.mastering.spring.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.mastering.spring.springboot.bean.Employee;
import com.mastering.spring.springboot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mastering.spring.springboot.bean.Employee;
import com.mastering.spring.springboot.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	private static final int CREATED_EMPLOYEE_ID = 4;

	@Autowired
	private MockMvc mvc;
	@MockBean
	private EmployeeService service;

	@Test
	public void retrieveTodos() throws Exception {
		List<Employee> mockList = Arrays.asList(new Employee(1, "Jack", "Learn Spring MVC", new Date(), false),
				new Employee(2, "Jack", "Learn Struts", new Date(), false));
		when(service.retrieveEmployees(anyString())).thenReturn(mockList);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/users/Jack/todos").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String expected = "[" + "{id:1,user:\"Jack\",desc:\"Learn Spring MVC\",done:false}" + ","
				+ "{id:2,user:\"Jack\",desc:\"Learn Struts\",done:false}" + "]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void retrieveEmployee() throws Exception {
		Employee mockEmployee = new Employee(1, "Jack", "Learn Spring MVC", new Date(), false);
		when(service.retrieveEmployee(anyInt())).thenReturn(mockEmployee);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("/users/Jack/employees/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String expected = "{id:1,user:\"Jack\",desc:\"Learn Spring MVC\",done:false}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void createTodo() throws Exception {
		Employee mockEmployee = new Employee(CREATED_EMPLOYEE_ID, "Jack", "Learn Spring MVC", new Date(), false);
		String todo = "{\"user\":\"Jack\",\"desc\":\"Learn Spring MVC\",\"done\":\"false\"}";

		when(service.addEmployee(anyString(), anyString(), isNull(), anyBoolean())).thenReturn(mockEmployee);
		mvc.perform(
				MockMvcRequestBuilders.post("/users/Jack/employees").content(todo).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(header().string("location", containsString("/users/Jack/employees/" + CREATED_EMPLOYEE_ID)));
	}
}