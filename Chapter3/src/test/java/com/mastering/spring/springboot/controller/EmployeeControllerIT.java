package com.mastering.spring.springboot.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.util.Date;

import com.mastering.spring.springboot.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mastering.spring.springboot.Application;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {
	@LocalServerPort
	private int port;
	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void retrieveEmployees() throws Exception {
		String expected = "[" + "{id:1,user:\"Jack\",desc:\"Learn Spring MVC\",done:false}" + ","
				+ "{id:2,user:\"Jack\",desc:\"Learn Struts\",done:false}" + "]";
		String uri = "/users/Jack/employees";
		ResponseEntity<String> response = template.getForEntity(createUrl(uri), String.class);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void retrieveEmployee() throws Exception {
		String expected = "{id:1,user:\"Jack\",desc:\"Learn Spring MVC\",done:false}";

		ResponseEntity<String> response = template.getForEntity(createUrl("/users/Jack/employees/1"), String.class);
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	@Test
	public void addEmployee() throws Exception {
		Employee employee = new Employee(-1, "Jill", "Learn Hibernate", new Date(), false);
		URI location = template.postForLocation(createUrl("/users/Jill/employees"), employee);
		assertThat(location.getPath(), containsString("/users/Jill/employees/4"));
	}

	private String createUrl(String uri) {
		return "http://localhost:" + port + uri;
	}
}