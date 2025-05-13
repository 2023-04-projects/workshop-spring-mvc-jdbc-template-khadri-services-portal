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

import com.khadri.spring.author.form.AuthorForm;
import com.khadri.spring.customer.form.CustomerForm;
import com.khadri.spring.employee.form.EmployeeForm;
import com.khadri.spring.student.form.StudentForm;
import com.khadri.spring.task.form.TaskForm;
import com.khadri.spring.task.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	private TaskService taskService;

	@Autowired
	TaskController(TaskService taskService){
		this.taskService = taskService;
	}

	@PostMapping("/save")
	public String saveTask(@ModelAttribute("taskForm") TaskForm taskForm,
			RedirectAttributes redirectAttributes) {
		TaskForm resultTaskForm = taskService.save(taskForm);
		redirectAttributes.addFlashAttribute("addedTask", resultTaskForm);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String updateTask(@ModelAttribute("taskForm") TaskForm taskForm, Model model) {
		taskService.update(taskForm);
		model.addAttribute("customerForm", new CustomerForm()); // reset form
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form
		model.addAttribute("taskForm", new TaskForm()); // reset form
		return "khadri-services-portal";
	}

	@PostMapping("/delete")
	public String deleteTask(@RequestParam("id") int id, Model model) {
		taskService.delete(id);
		model.addAttribute("taskForm", new TaskForm()); // reset form
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form

		return "khadri-services-portal";
	}

	@GetMapping("/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into TaskController:searchById");
		TaskForm found = taskService.findById(id);
		model.addAttribute("foundTask", found);
		model.addAttribute("taskForm", new TaskForm()); // reset form
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form

		return "khadri-services-portal";
	}

	@GetMapping("/find/by/priority")
	public String searchByPriority(@RequestParam("priority") String priority, Model model) {
		List<TaskForm> taskForm = taskService.findByPriority(priority);
		model.addAttribute("taskByPriority", taskForm);
		model.addAttribute("taskForm", new TaskForm()); // reset form
		model.addAttribute("customerForm", new CustomerForm()); // Keep form model ready
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form

		return "khadri-services-portal";
	}

	@GetMapping("/find/by/status")
	public String searchByStatus(@RequestParam("status") String status, Model model) {
		List<TaskForm> taskForm = taskService.findByStatus(status);
		model.addAttribute("taskByStatus", taskForm);
		model.addAttribute("taskForm", new TaskForm()); // reset form
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form

		return "khadri-services-portal";
	}

	@GetMapping("/find/by/cost")
	public String searchByCost(@RequestParam("cost") double cost, Model model) {
		List<TaskForm> taskForm = taskService.findByCost(cost);
		model.addAttribute("taskByCost", taskForm);
		model.addAttribute("taskForm", new TaskForm()); // reset form
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("studentForm", new StudentForm()); // reset form
		model.addAttribute("employeeForm", new EmployeeForm()); // reset form
		model.addAttribute("authorForm", new AuthorForm()); // reset form

		return "khadri-services-portal";
	}

}