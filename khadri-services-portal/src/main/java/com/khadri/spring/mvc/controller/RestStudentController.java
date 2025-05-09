package com.khadri.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khadri.spring.student.form.StudentForm;
import com.khadri.spring.student.service.StudentService;


@Controller
@RequestMapping("/rest")
public class RestStudentController {

	private StudentService studentService;

	@Autowired
	public RestStudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(value = "/find/by/id")
	@ResponseBody
	public StudentForm searchById(@RequestParam("id") int id) {
		System.out.println("Entered into RestStudentController:searchById");
		return studentService.findById(id);
	}

	@GetMapping(value = "/find/by/name")
	@ResponseBody
	public List<StudentForm> searchByName(@RequestParam("name") String name) {
		System.out.println("Entered into RestStudentController:searchByName");
		return studentService.findByName(name);
	}

	@GetMapping(value = "/find/by/course")
	@ResponseBody
	public List<StudentForm> searchByCourse(@RequestParam("course") String course) {
		System.out.println("Entered into RestStudentController:searchByCourse");
		return studentService.findByCourse(course);
	}

	@GetMapping(value = "/find/by/marks")
	@ResponseBody
	public List<StudentForm> searchByMarks(@RequestParam("marks") int marks) {
		System.out.println("Entered into RestStudentController:searchByMarks");
		return studentService.findByMarks(marks);
	}

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StudentForm createForm(@RequestBody StudentForm studentForm) {
		return studentService.save(studentForm);
	}

	@PutMapping(value = "/update/id")
	@ResponseBody
	public StudentForm updateForm(@RequestParam("id") int id, @RequestBody StudentForm studentForm) {
		studentForm.setId(id);
		return studentService.update(studentForm);
	}

	@PatchMapping(value = "/update/partial/id")
	@ResponseBody
	public StudentForm updatePartailForm(@RequestParam("id") int id, @RequestBody Map<String, Object> updates) {
		return studentService.update(id, updates);
	}
	
	@DeleteMapping(value = "/delete/id")
	public void deleteForm(@RequestParam("id") int id) {
		  studentService.delete(id);
	}

}
