package com.mihneacristian.project_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectTrackerApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectTrackerApplication.class, args);
    }
}
