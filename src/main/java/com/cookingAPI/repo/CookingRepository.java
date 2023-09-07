package com.cookingAPI.repo;

import java.util.List;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cookingAPI.model.Cooking;

@Repository
public interface CookingRepository extends CrudRepository<Cooking,Integer> {
	 Cooking findByName(String name);
	    
	    List<Cooking> deleteByName(String name);
}
