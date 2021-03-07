package com.company.Sampler.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import com.company.Sampler.beans.Employee;
import com.company.Sampler.exceptionhandlers.EmployeeValidator;

@Controller
@ControllerAdvice
public class EmployeeController {
	 private Map<Long, Employee> employeeMap = new HashMap<>();
	 @Autowired
	 EmployeeValidator employeeValidator;

	 @InitBinder(value = "employee")
	 public void emloyeeInitHandler(WebDataBinder webDataBinder) {
		 webDataBinder.setValidator(employeeValidator);
	 }
	 
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("msg", "Welcome to the Netherlands!");
	}
	@GetMapping("/tests")
	public String test() {
		return "tests";
	}
	@RequestMapping(value= "/userform",method = RequestMethod.GET)
	public String loadUserForm() {
		System.out.println("Entered************");
		return "employeeForm";
	}
	@PostMapping("/addEmployee")
	public String postEmployeeData(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			throw new RuntimeException();
		}
		 model.addAttribute("name", employee.getName());
	     model.addAttribute("id", employee.getId());
	     employeeMap.put(employee.getId(), employee);
		return "result";
	}
	
	 @PostMapping("/api/student")
	    public ResponseEntity<Employee> saveStudent(@RequestBody @Valid Employee student) {
	        return new ResponseEntity<>(student, HttpStatus.CREATED);
	    }
	
}
