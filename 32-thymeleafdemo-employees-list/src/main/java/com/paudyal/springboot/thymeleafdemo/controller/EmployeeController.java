package com.paudyal.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paudyal.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> theEmployee;
	
	@PostConstruct
	private void loadData() {
		
		Employee empl = new Employee(1, "Leslie", "Andrews", "les@luv2code.com");
		Employee empl1 = new Employee(2, "Mary", "Add", "luv2adjhs");
		Employee empl2 = new Employee(3, "Nischal", "Paudyal", "les@l");

		
		theEmployee = new ArrayList<>();
		
		theEmployee.add(empl);
		theEmployee.add(empl1);
		theEmployee.add(empl2);
		
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", theEmployee);
		return "list-employees";
	}
	
}
