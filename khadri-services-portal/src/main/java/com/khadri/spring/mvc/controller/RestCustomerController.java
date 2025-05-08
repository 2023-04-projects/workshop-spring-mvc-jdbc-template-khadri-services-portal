package com.khadri.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.khadri.spring.customer.form.CustomerForm;
import com.khadri.spring.customer.service.CustomerService;

@Controller
@RequestMapping("/rest/customer")
public class RestCustomerController {

	private CustomerService customerService;

	@Autowired
	public RestCustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/find/by/id")
	@ResponseBody
	public CustomerForm searchById(@RequestParam("id") int id) {
		return customerService.findById(id);
	}

	@GetMapping("/find/by/name")
	@ResponseBody
	public List<CustomerForm> searchByName(@RequestParam("name") String name) {
		return customerService.findByName(name);
	}

	

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public CustomerForm create(@RequestBody CustomerForm customerForm) {
		return customerService.save(customerForm);
	}

	@PutMapping("/update/id")
	@ResponseBody
	public CustomerForm update(@RequestParam("id") int id, @RequestBody CustomerForm customerForm) {
		customerForm.setId(id);
		return customerService.update(customerForm);
	}

	
	@DeleteMapping("/delete/id")
	public void delete(@RequestParam("id") int id) {
		customerService.delete(id);
	}
}
