package com.thta.task.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thta.task.Customer;

@Repository
public class TodoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplateOne;

	@Autowired
	private JdbcTemplate jdbcTemplateTwo;

	public List<Customer> isData() {
		List<Customer> customers = new ArrayList<Customer>();
		List<Map<String, Object>> rows = jdbcTemplateOne.queryForList("SELECT * FROM CUSTOMER");
		for (Map<String, Object> row : rows) {
			Customer customer = new Customer();
			customer.setCustNo((int) row.get("custNo"));
			customer.setCustName((String) row.get("custName"));
			customer.setCountry((String) row.get("Country"));
			customers.add(customer);
		}

		return customers;

	}

	public String dsVerification() {
		String status = "";
		String query = jdbcTemplateTwo.queryForObject("SELECT COUNT(*) FROM DUAL;", String.class);
		if (query.equals("1")) {
			status = "Datasource connection successful..!";
		} else {
			status = "Datasource connection failed..!";
		}

		return status;
	}
}
