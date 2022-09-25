package org.svarpy.japi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.svarpy.japi.model.Seeder;
import org.svarpy.japi.service.FirstService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FirstController {
	
	@Autowired
	FirstService firstService;
	
	@GetMapping
	public String home() {
		return "Welcome to JAPI REST API sample Application";
	}
	
	@GetMapping("/seeders")
	public Map<String, Seeder> getAllSeeders() {
		return firstService.getAllSeeders();
	}
	
	@GetMapping("/seeder/{id}")
	public Map<String, Seeder> getSeederById(@PathVariable String id) {
		return firstService.getSeederById(id);
	}
	
	@PostMapping("/add")
	public String addNewSeeder(@RequestBody Seeder seeder) {
		return firstService.addNewSeeder(seeder);
	}
	
	@PutMapping("/update")
	public String updateSeeder(@RequestBody Seeder seeder) {
		return firstService.updateSeeder(seeder);
	}
	
	@DeleteMapping("/delete{id}")
	public String deleteSeeder(@PathVariable String id) {
		return firstService.deleteSeeder(id);
	}
	
}
