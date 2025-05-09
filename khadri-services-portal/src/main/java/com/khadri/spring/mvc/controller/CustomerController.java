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
import com.khadri.spring.student.form.StudentForm;


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
		return "khadri-services-portal";
	}

//	@PostMapping("/customer/save")
//	public String saveCustomer(@ModelAttribute("customerForm") CustomerForm customer,
//			RedirectAttributes redirectAttributes) {
//		CustomerForm savedCustomer = customerService.save(customer);
//		redirectAttributes.addFlashAttribute("addedCustomer", savedCustomer);
//		return "redirect:/customer";
//	}

//	@PostMapping("/customer/update")
//	public String updateCustomer(@ModelAttribute("customerForm") CustomerForm customer, Model model) {
//		customerService.update(customer);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "khadri-services-portal";
//	}
//
//	@PostMapping("/customer/delete")
//	public String deleteCustomer(@RequestParam("id") int id, Model model) {
//		customerService.delete(id);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "khadri-services-portal";
//	}
//
//	@GetMapping("/customer/find/by/id")
//	public String findById(@RequestParam("id") int id, Model model) {
//		CustomerForm customer = customerService.findById(id);
//		model.addAttribute("foundCustomer", customer);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "khadri-services-portal";
//	}
//
//	@GetMapping("/customer/find/by/name")
//	public String findByName(@RequestParam("name") String name, Model model) {
//		List<CustomerForm> customers = customerService.findByName(name);
//		model.addAttribute("customersByName", customers);
//		model.addAttribute("customerForm", new CustomerForm());
//		return "khadri-services-portal";
//	}
//	@GetMapping("/find/by/address")
//	public String searchByAddress(@RequestParam("course") String address, Model model) {
//	    List<CustomerForm> customer = customerService.findByAddress(address);
//	    model.addAttribute("studentsByAddress", customer);
//	    model.addAttribute("customerForm", new CustomerForm());
//	    return "khadri-services-portal";
//	}
//
//	@GetMapping("/find/by/phoneNumber")
//	public String searchByPhoneNumber(@RequestParam("phoneNumber") int phoneNumber, Model model) {
//	    List<CustomerForm> customer = customerService.findByPhoneNumber(phoneNumber);
//	    model.addAttribute("customerByMarks", customer);
//	    model.addAttribute("customerForm", new CustomerForm());
//	    return "khadri-services-portal";
//	}
//	
}
