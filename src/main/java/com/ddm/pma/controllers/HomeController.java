package com.ddm.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ddm.pma.dao.EmployeeRepository;
import com.ddm.pma.dao.ProjectRepository;
import com.ddm.pma.dto.ChartData;
import com.ddm.pma.dto.EmployeeProject;
import com.ddm.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();
		
		//Convertir projectData de objeto a json para poder usarlo en JS
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
	
		return "main/home";
	}
}
