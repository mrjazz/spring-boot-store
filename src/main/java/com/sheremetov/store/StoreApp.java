package com.sheremetov.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by denis on 11/12/2016.
 */
@SpringBootApplication
public class StoreApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StoreApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StoreApp.class, args);
    }

}
