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
import com.khadri.spring.employee.form.EmployeeForm;
import com.khadri.spring.employee.service.EmployeeService;
import com.khadri.spring.student.form.StudentForm;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;
	private EmployeeForm employee;
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Save a new employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employeeForm") EmployeeForm employee,
			RedirectAttributes redirectAttributes) {
		EmployeeForm resultemployeeForm = employeeService.save(employee);
		redirectAttributes.addFlashAttribute("addedEmployee", resultemployeeForm);
		return "redirect:/";
	}
	// Update existing employee
		@PostMapping("/update")
		public String updateEmployee(@ModelAttribute("employeeForm") EmployeeForm employee, Model model) {
			employeeService.update(employee);
			model.addAttribute("studentForm", new StudentForm()); 
			model.addAttribute("customerForm", new CustomerForm()); 
			model.addAttribute("employeeForm", new EmployeeForm()); 
			return "khadri-services-portal";
		}
		// Delete employee by ID
		@PostMapping("/delete")
		public String deleteEmployee(@RequestParam("id") int id, Model model) {
			employeeService.delete(id);
			model.addAttribute("studentForm", new StudentForm()); 
			model.addAttribute("customerForm", new CustomerForm()); 
			model.addAttribute("employeeForm", new EmployeeForm()); 			
			return "khadri-services-portal";
		}
		// Search employee by ID
		@GetMapping("/find/by/id")
		public String searchById(@RequestParam("id") int id, Model model) {
			System.out.println("Entered into EmployeeController:searchById");
			EmployeeForm employee = employeeService.findById(id);
			model.addAttribute("foundEmployee", employee);
			model.addAttribute("studentForm", new StudentForm()); 
			model.addAttribute("customerForm", new CustomerForm()); 
			model.addAttribute("employeeForm", new EmployeeForm()); 
			return "khadri-services-portal";
		}
		// search employee by name
		@GetMapping("/find/by/name")
		public String searchByName(@RequestParam("name") String name, Model model) {
		    List<EmployeeForm> employees = employeeService.findByName(name);
		    model.addAttribute("employeeByName", employees);
		    model.addAttribute("studentForm", new StudentForm()); 
			model.addAttribute("customerForm", new CustomerForm()); 
			model.addAttribute("employeeForm", new EmployeeForm()); 
			return "khadri-services-portal";
		}
		// search employee by salary
		@GetMapping("/find/by/salary")
		public String searchBySalary(@RequestParam("salary") double salary, Model model) {
		    List<EmployeeForm> employee = employeeService.findBySalary(salary);
		    model.addAttribute("employeeBySalary", employee);
		    model.addAttribute("studentForm", new StudentForm()); 
			model.addAttribute("customerForm", new CustomerForm()); 
			model.addAttribute("employeeForm", new EmployeeForm()); 
			return "khadri-services-portal";
		}


}
