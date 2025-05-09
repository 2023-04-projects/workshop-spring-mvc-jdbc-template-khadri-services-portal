package com.khadri.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// Save a new student
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customerForm") CustomerForm customerForm,
			RedirectAttributes redirectAttributes) {
		CustomerForm resultcustomerForm = customerService.save(customerForm);
		redirectAttributes.addFlashAttribute("addedCustomer", resultcustomerForm);
		return "redirect:/";
	}


	@PostMapping("/update")
	public String updateCustomer(@ModelAttribute("customerForm") CustomerForm customerForm, Model model) {
		customerService.update(customerForm);
		model.addAttribute("customerForm", new CustomerForm()); // reset form
		return "khadri-services-portal";
	}
	@PostMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id, Model model) {
	customerService.delete(id);
		model.addAttribute("customerForm", new CustomerForm());
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into CustomerController:searchById");
		CustomerForm found = customerService.findById(id);
		model.addAttribute("foundCustomer", found);
		model.addAttribute("customerForm", new CustomerForm());
		return "khadri-services-portal";
	}
	

	@GetMapping("/find/by/name")
	public String searchByName(@RequestParam("name") String name, Model model) {
		List<CustomerForm> customerForm = customerService.findByName(name);
		model.addAttribute("customerByName", customerForm);
		model.addAttribute("customerForm", new CustomerForm()); // Keep form model ready
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/address")
	public String searchByAddress(@RequestParam("address") String address, Model model) {
		List<CustomerForm> customerForm = customerService.findByAddress(address);
		model.addAttribute("customerByAddress", customerForm);
		model.addAttribute("customerForm", new CustomerForm());
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/phoneNumber")
	public String searchByPhoneNumber(@RequestParam("phoneNumber") int phoneNumber, Model model) {
		List<CustomerForm> customerForm = customerService.findByPhoneNumber(phoneNumber);
		model.addAttribute("customerByPhoneNumber", customerForm);
		model.addAttribute("customerForm", new CustomerForm());
		return "khadri-services-portal";
	}

}