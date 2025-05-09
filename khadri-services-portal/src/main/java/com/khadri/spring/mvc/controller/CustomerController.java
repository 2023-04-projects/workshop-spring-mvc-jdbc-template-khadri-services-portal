package com.khadri.spring.mvc.controller;

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
@RequestMapping("/customer")
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
//	// Delete student by ID
//	@PostMapping("/delete")
//	public String deleteStudent(@RequestParam("id") int id, Model model) {
//		studentService.delete(id);
//		model.addAttribute("studentForm", new StudentForm());
//		return "khadri-services-portal";
//	}
//
	@GetMapping("/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into CustomerController:searchById");
		CustomerForm found = customerService.findById(id);
		model.addAttribute("foundCustomer", found);
		model.addAttribute("customerForm", new CustomerForm());
		return "khadri-services-portal";
	}
//
//	@GetMapping("/find/by/name")
//	public String searchByName(@RequestParam("name") String name, Model model) {
//		List<StudentForm> students = studentService.findByName(name);
//		model.addAttribute("studentsByName", students);
//		model.addAttribute("studentForm", new StudentForm()); // Keep form model ready
//		return "khadri-services-portal";
//	}
//
//	@GetMapping("/find/by/course")
//	public String searchByCourse(@RequestParam("course") String course, Model model) {
//		List<StudentForm> students = studentService.findByCourse(course);
//		model.addAttribute("studentsByCourse", students);
//		model.addAttribute("studentForm", new StudentForm());
//		return "khadri-services-portal";
//	}
//
//	@GetMapping("/find/by/marks")
//	public String searchByMarks(@RequestParam("marks") int marks, Model model) {
//		List<StudentForm> students = studentService.findByMarks(marks);
//		model.addAttribute("studentsByMarks", students);
//		model.addAttribute("studentForm", new StudentForm());
//		return "khadri-services-portal";
//	}

}