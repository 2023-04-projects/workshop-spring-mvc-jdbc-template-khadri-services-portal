package com.khadri.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khadri.spring.author.form.AuthorForm;
import com.khadri.spring.customer.form.CustomerForm;
import com.khadri.spring.employee.form.EmployeeForm;
import com.khadri.spring.software.form.SoftwareForm;
import com.khadri.spring.student.form.StudentForm;
import com.khadri.spring.task.form.TaskForm;

@Controller
public class HomeController {

	// Show main portal page with empty form model
	@GetMapping("/")
	public String showPortal(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("employeeForm", new EmployeeForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("softwareForm", new SoftwareForm());
		model.addAttribute("taskForm", new TaskForm());

		return "khadri-services-portal"; // your JSP page name
	}
}
