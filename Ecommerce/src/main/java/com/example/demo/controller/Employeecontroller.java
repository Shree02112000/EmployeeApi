package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Employeeentity;
import com.example.demo.repository.Employeerepo;
import java.util.List;

@RestController
public class Employeecontroller {
	
	
	@Autowired
	public Employeerepo repo;
	
	@PostMapping("/adduser")
	public Employeeentity adduser(@RequestBody Employeeentity employee ){
		try {
			repo.save(employee);
			return employee;
		}catch(Exception e) {
			e.printStackTrace();
			}
		return null;
	}

	@GetMapping("/getuser")
	public List<Employeeentity> getuser(){
		try {
			return repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	 
	@PutMapping("/updateuser")
	public Employeeentity updateuser(@RequestBody Employeeentity employee ){
		try {
			repo.save(employee);
			return employee;
		}catch(Exception e) {
			e.printStackTrace();
			}
		return null;
	}
	@DeleteMapping("/getdel/{Id}")
	public String del (@PathVariable int Id) {
		@SuppressWarnings("deprecation")
		Employeeentity employee=repo.getOne(Id);
		repo.delete(employee);
		return "Delete";
	}
}


