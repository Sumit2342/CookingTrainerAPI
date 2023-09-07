package com.cookingAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.cookingAPI.model.Cooking;
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
    public Optional<Cooking> getBlog(@PathVariable int id) {
        if (cookingRepo.existsById(id)) {
            return cookingRepo.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/cookingTrainer/count")
    public long countTotalBlogs() {
        return cookingRepo.count();
    }
    
    @GetMapping("/cookingTrainer/name/{name}")
    public Cooking getBlogByAuthorName(@PathVariable String name) {
        return cookingRepo.findByName(name);
    }
    
    @DeleteMapping("/blogs/name/{name}/")
    public List<Cooking> deleteByAuthorAndTopic(@PathVariable String name) {
        return cookingRepo.deleteByName(name);
    }
    
    @DeleteMapping("/cookingTrainer/{id}")
    public void deleteById(@PathVariable int id) {
        cookingRepo.deleteById(id);
    }
	
}
