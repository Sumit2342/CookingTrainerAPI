package com.cookingAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cookingAPI.model.Cooking;
import com.cookingAPI.model.CookingTrainerUpdates;
import com.cookingAPI.repo.CookingRepository;


@RestController

public class CookingController {
	@Autowired
	private CookingRepository cookingRepo; 

	@RequestMapping("/")
	public String index() {
		return "Welcome to Cooking Trainer CRUD application!!";
	}
	
	@PostMapping("/cookingTrainer")
	public String addCookingTrainer(@RequestBody Cooking newCookingTrainer) {
		cookingRepo.save(newCookingTrainer);
		return "trainer successfully added";
	}
	
	@GetMapping("/cookingTrainer/{id}")
    public Optional<Cooking> getCookingTrainer(@PathVariable int id) {
        if (cookingRepo.existsById(id)) {
            return cookingRepo.findById(id);
        } else
            return Optional.empty();
    }
    
   
    
    @GetMapping("/cookingTrainer/name/{name}")
    public Cooking getCookingTrainerByName(@PathVariable String name) {
        return cookingRepo.findByName(name);
    }
    
    @DeleteMapping("/cookingTrainer/name/{name}/")
    public List<Cooking> deleteByName(@PathVariable String name) {
        return cookingRepo.deleteByName(name);
    }
    
    @DeleteMapping("/cookingTrainer/{id}")
    public void deleteById(@PathVariable int id) {
        cookingRepo.deleteById(id);
    }
	
    @PutMapping("/cookingTrainer/{idToBeUpdated}")
    public Cooking updateCookingTrainer(@PathVariable int idToBeUpdated, @RequestBody Cooking cookingTrainerUpdates) {
        
    	Cooking existingTrainer = cookingRepo.findById(idToBeUpdated).orElse(null);
        if (existingTrainer != null) {
            // Update fields with new values
            existingTrainer.setName(cookingTrainerUpdates.getName());
            existingTrainer.setEmail(cookingTrainerUpdates.getEmail());
            existingTrainer.setAge(cookingTrainerUpdates.getAge());

            // Save the updated product
            return cookingRepo.save(existingTrainer);
        } else {
            throw new IllegalArgumentException("Trainer not found with ID: " + cookingTrainerUpdates.getId());
        }
    }
}
