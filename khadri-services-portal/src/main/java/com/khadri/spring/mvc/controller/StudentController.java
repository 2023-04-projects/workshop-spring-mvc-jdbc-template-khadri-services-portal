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

import com.khadri.spring.student.service.StudentService;
import com.khadri.spring.student.form.StudentForm;

@Controller
@RequestMapping("/")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// Show main portal page with empty form model
	@GetMapping("/")
	public String showPortal(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		return "khadri-services-portal"; // your JSP page name
	}

	// Save a new student
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("studentForm") StudentForm student,
			RedirectAttributes redirectAttributes) {
		StudentForm addedStudent = studentService.save(student);
		redirectAttributes.addFlashAttribute("addedStudent", addedStudent); 
		return "redirect:/";
	}

	// Update existing student
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute("studentForm") StudentForm student, Model model) {
		studentService.update(student);
		model.addAttribute("studentForm", new StudentForm()); // reset form
		return "student-portal";
	}

	// Delete student by ID
	@PostMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id, Model model) {
		studentService.delete(id);
		model.addAttribute("studentForm", new StudentForm());
		return "student-portal";
	}

	// Search student by ID
	@GetMapping("/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into StudentController:searchById");
		StudentForm found = studentService.findById(id);
		model.addAttribute("foundStudent", found);
		model.addAttribute("studentForm", new StudentForm());
		return "student-portal";
	}
	
	@GetMapping("/find/by/name")
	public String searchByName(@RequestParam("name") String name, Model model) {
	    List<StudentForm> students = studentService.findByName(name);
	    model.addAttribute("studentsByName", students);
	    model.addAttribute("studentForm", new StudentForm()); // Keep form model ready
	    return "student-portal";
	}
	
	@GetMapping("/find/by/course")
	public String searchByCourse(@RequestParam("course") String course, Model model) {
	    List<StudentForm> students = studentService.findByCourse(course);
	    model.addAttribute("studentsByCourse", students);
	    model.addAttribute("studentForm", new StudentForm());
	    return "student-portal";
	}

	@GetMapping("/find/by/marks")
	public String searchByMarks(@RequestParam("marks") int marks, Model model) {
	    List<StudentForm> students = studentService.findByMarks(marks);
	    model.addAttribute("studentsByMarks", students);
	    model.addAttribute("studentForm", new StudentForm());
	    return "student-portal";
	}

}