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
import com.khadri.spring.software.form.SoftwareForm;
import com.khadri.spring.software.service.SoftwareService;
import com.khadri.spring.student.form.StudentForm;

@Controller
@RequestMapping("/software")
public class SoftwareController {

	private SoftwareService softwareService;

	@Autowired
	public SoftwareController(SoftwareService softwareService) {
		this.softwareService = softwareService;
	}

	// Save a new software
	@PostMapping("/save")
	public String saveSoftware(@ModelAttribute("softwareForm") SoftwareForm softwareForm,
			RedirectAttributes redirectAttributes) {
		SoftwareForm resultSoftwareForm = softwareService.save(softwareForm);
		redirectAttributes.addFlashAttribute("addedSoftware", resultSoftwareForm);
		return "redirect:/";
	}

// Update existing software
	@PostMapping("/update")
	public String updateSoftware(@ModelAttribute("softwareForm") SoftwareForm software, Model model) {
		softwareService.update(software);
		model.addAttribute("softwareForm", new SoftwareForm());// reset form
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

	// Delete student by ID
	@PostMapping("/delete")
	public String deleteSoftware(@RequestParam("id") int id, Model model) {
		softwareService.delete(id);
		model.addAttribute("studentForm", new SoftwareForm());
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

//	// Search software by ID
	@GetMapping("/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into SoftwareController:searchById");
		SoftwareForm found = softwareService.findById(id);
		model.addAttribute("foundSoftware", found);
		model.addAttribute("softwareForm", new SoftwareForm());
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/name")
	public String searchByName(@RequestParam("name") String name, Model model) {
		List<SoftwareForm> software = softwareService.findByName(name);
		model.addAttribute("softwareByName", software);
		model.addAttribute("softwareForm", new SoftwareForm()); // Keep form model ready
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/address")
	public String searchByAdderss(@RequestParam("address") String adderss, Model model) {
		List<SoftwareForm> software = softwareService.findByAddress(adderss);
		model.addAttribute("softwareByAdderss", software);
		model.addAttribute("softwareForm", new SoftwareForm());
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

	@GetMapping("/find/by/phoneNumber")
	public String searchByPhoneNumber(@RequestParam("phoneNumber") long phoneNumber, Model model) {
		List<SoftwareForm> software = softwareService.findByPhoneNumber(phoneNumber);
		model.addAttribute("softwareByPhoneNumber", software);
		model.addAttribute("softwareForm", new SoftwareForm());
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		model.addAttribute("employeeForm", new EmployeeForm()); 
		return "khadri-services-portal";
	}

}