package com.cookingAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import lombok.Getter;
import lombok.Setter;


@Document
@Setter
@Getter
public class Cooking {
	@Id
	
	private int id;
	
	private String name;
	private String email;
	private int age;

}
