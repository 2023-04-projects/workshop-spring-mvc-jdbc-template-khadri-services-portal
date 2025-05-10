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
import com.khadri.spring.author.service.AuthorService;
import com.khadri.spring.customer.form.CustomerForm;
import com.khadri.spring.student.form.StudentForm;

@Controller
@RequestMapping("/author")
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	// Show main portal page with empty form model
	@GetMapping("/")
	public String showPortal(Model model) {
		model.addAttribute("studentForm", new StudentForm());
		model.addAttribute("customerForm", new CustomerForm());
		model.addAttribute("authorForm", new AuthorForm());
		return "khadri-services-portal"; // your JSP page name
	}

	// Save a new student
	@PostMapping("/author/save")
	public String saveAuthor(@ModelAttribute("authorForm") AuthorForm author, RedirectAttributes redirectAttributes) {
		AuthorForm addedAuthor = authorService.save(author);
		redirectAttributes.addFlashAttribute("addedAuthor", addedAuthor);
		return "redirect:/";
	}

	// Update existing student
	@PostMapping("/author/update")
	public String updateAuthor(@ModelAttribute("authorForm") AuthorForm author, Model model) {
		authorService.update(author);
		model.addAttribute("authorForm", new AuthorForm()); // reset form
		return "khadri-services-portal";
	}

	// Delete student by ID
	@PostMapping("/author/delete")
	public String deleteAuthor(@RequestParam("id") int id, Model model) {
		authorService.delete(id);
		model.addAttribute("authorForm", new AuthorForm());
		return "khadri-services-portal";
	}

	// Search student by ID
	@GetMapping("/author/find/by/id")
	public String searchById(@RequestParam("id") int id, Model model) {
		System.out.println("Entered into AuthorController:searchById");
		AuthorForm found = authorService.findById(id);
		model.addAttribute("foundAuthor", found);
		model.addAttribute("authorForm", new AuthorForm());
		return "khadri-services-portal";
	}

	@GetMapping("/author/find/by/name")
	public String searchByName(@RequestParam("name") String name, Model model) {
		List<AuthorForm> authors = authorService.findByName(name);
		model.addAttribute("authorsByName", authors);
		model.addAttribute("authorForm", new AuthorForm()); // Keep form model ready
		return "khadri-services-portal";
	}

	@GetMapping("/author/find/by/skillsets")
	public String searchBySkillsets(@RequestParam("skillsets") String skillsets, Model model) {
		List<AuthorForm> authors = authorService.findBySkillsets(skillsets);
		model.addAttribute("authorsBySkillsets", authors);
		model.addAttribute("authorForm", new AuthorForm());
		return "khadri-services-portal";
	}

	@GetMapping("/author/find/by/year")
	public String searchByYear(@RequestParam("year") int year, Model model) {
		List<AuthorForm> authors = authorService.findByYear(year);
		model.addAttribute("authorsByYear", authors);
		model.addAttribute("authorForm", new AuthorForm());
		return "khadri-services-portal";
	}

}
