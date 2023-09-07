package com.cookingAPI.model;

import org.springframework.data.couchbase.core.mapping.Field;

import lombok.Data;

import java.util.List;

@Data
public class CookingTrainerUpdates {
	 @Field
	    String topic;
}
