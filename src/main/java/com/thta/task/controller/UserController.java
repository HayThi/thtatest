package com.thta.task.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thta.task.Customer;
import com.thta.task.dao.TodoDAO;
import com.thta.task.model.Greeting;

/**
 * /login POST controller is provided by Spring Security
 */
@RestController
public class UserController {

	@Autowired
	public TodoDAO dao;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public String welcome() {
		return new String("welcome");
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/getcustInfo")
	public List<Customer> customerInformation() {
		List<Customer> customers = dao.isData();
		return customers;
	}

	@RequestMapping("/testSecondDatasource")
	public String dSverify() {
		return dao.dsVerification();
	}

}