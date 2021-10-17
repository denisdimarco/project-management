package com.ddm.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ddm.pma.dao.EmployeeRepository;
import com.ddm.pma.dao.ProjectRepository;
import com.ddm.pma.entities.Employee;
import com.ddm.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("employeesList", employees);
	
		return "main/home";
	}
}
