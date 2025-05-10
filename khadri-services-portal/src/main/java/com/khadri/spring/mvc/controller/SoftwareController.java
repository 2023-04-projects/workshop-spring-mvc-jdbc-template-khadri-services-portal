package com.khadri.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khadri.spring.software.form.SoftwareForm;
import com.khadri.spring.software.service.SoftwareService;

@Controller
@RequestMapping("/software")
public class SoftwareController {

	private SoftwareService softwareService;

	@Autowired
	public SoftwareController(SoftwareService softwareService) {
		this.softwareService = softwareService;
	}

	// Save a new student
	@PostMapping("/save")
	public String saveSoftware(@ModelAttribute("softwareForm") SoftwareForm softwareForm,
			RedirectAttributes redirectAttributes) {
		SoftwareForm resultSoftwareForm = softwareService.save(softwareForm);
		redirectAttributes.addFlashAttribute("addedSoftware", resultSoftwareForm);
		return "redirect:/";
	}

//	// Update existing student
//	@PostMapping("/update")
//	public String updateStudent(@ModelAttribute("studentForm") StudentForm student, Model model) {
//		studentService.update(student);
//		model.addAttribute("studentForm", new StudentForm()); // reset form
//		return "khadri-services-portal";
//	}
//
//	// Delete student by ID
//	@PostMapping("/delete")
//	public String deleteStudent(@RequestParam("id") int id, Model model) {
//		studentService.delete(id);
//		model.addAttribute("studentForm", new StudentForm());
//		return "khadri-services-portal";
//	}
//
//	// Search student by ID
//	@GetMapping("/find/by/id")
//	public String searchById(@RequestParam("id") int id, Model model) {
//		System.out.println("Entered into StudentController:searchById");
//		StudentForm found = studentService.findById(id);
//		model.addAttribute("foundStudent", found);
//		model.addAttribute("studentForm", new StudentForm());
//		return "khadri-services-portal";
//	}
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