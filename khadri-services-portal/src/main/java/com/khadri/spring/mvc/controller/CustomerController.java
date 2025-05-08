package com.khadri.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khadri.spring.customer.form.CustomerForm;
import com.khadri.spring.customer.service.CustomerService;


@Controller
@RequestMapping("/")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public String showCustomerPortal(Model model) {
		model.addAttribute("customerForm", new CustomerForm());
		return "customer-portal";
	}

//	@PostMapping("/customer/save")
//	public String saveCustomer(@ModelAttribute("customerForm") CustomerForm customer,
//			RedirectAttributes redirectAttributes) {
//		CustomerForm savedCustomer = customerService.save(customer);
//		redirectAttributes.addFlashAttribute("addedCustomer", savedCustomer);
//		return "redirect:/customer";
//	}
//
//	@PostMapping("/customer/update")
//	public String updateCustomer(@ModelAttribute("customerForm") CustomerForm customer, Model model) {
//		customerService.update(customer);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "customer-portal";
//	}
//
//	@PostMapping("/customer/delete")
//	public String deleteCustomer(@RequestParam("id") int id, Model model) {
//		customerService.delete(id);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "customer-portal";
//	}
//
//	@GetMapping("/customer/find/by/id")
//	public String findById(@RequestParam("id") int id, Model model) {
//		CustomerForm customer = customerService.findById(id);
//		model.addAttribute("foundCustomer", customer);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "customer-portal";
//	}
//
//	@GetMapping("/customer/find/by/name")
//	public String findByName(@RequestParam("name") String name, Model model) {
//		List<CustomerForm> customers = customerService.findByName(name);
//		model.addAttribute("customersByName", customers);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "customer-portal";
//	}

	
}
