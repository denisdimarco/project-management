package com.ddm.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddm.pma.dao.ProjectRepository;
import com.ddm.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRep;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		return "new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		proRep.save(project);
		
		return "redirect:/projects/new";
	}
}
