package com.mihneacristian.project_tracker;

import com.mihneacristian.project_tracker.Services.ProjectService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectTrackerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectTrackerApplication.class, args);

        ProjectService projectService = context.getBean("projectService", ProjectService.class);

        System.out.println("Test: " + projectService.getProjectById(1));
    }
}
