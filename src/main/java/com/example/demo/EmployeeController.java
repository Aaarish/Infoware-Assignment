package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
	
	@GetMapping("employees/{page}/{size}")
	public Page<Employee> getEmployees(@PathVariable int page, @PathVariable int size){
		return repo.findAll(PageRequest.of(page, size));
	}
	
	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return repo.findById(id).orElse(null);
	}
	
	@DeleteMapping("employee/delete/{id}")
	public void deleteEmployee(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("employee/update")
	public void updateEmployee(@RequestBody Employee employee) {
		repo.save(employee);
	}
}
