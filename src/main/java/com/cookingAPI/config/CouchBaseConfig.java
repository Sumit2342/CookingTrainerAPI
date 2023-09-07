package com.cookingAPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchBaseConfig extends AbstractCouchbaseConfiguration{

	@Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "test";
    }

    @Override
    public String getPassword() {
        return "Sumit@2342";
    }

    @Override
    public String getBucketName() {
        return "CookingTrainer";
    }

}
