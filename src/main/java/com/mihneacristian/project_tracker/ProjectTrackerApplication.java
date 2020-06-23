package com.mihneacristian.project_tracker;

import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import com.mihneacristian.project_tracker.Entities.Comment;
import com.mihneacristian.project_tracker.Entities.Project;
import com.mihneacristian.project_tracker.Entities.Status;
import com.mihneacristian.project_tracker.Entities.Type;
import com.mihneacristian.project_tracker.Repositories.CommentRepository;
import com.mihneacristian.project_tracker.Repositories.ProjectRepository;
import com.mihneacristian.project_tracker.Repositories.StatusRepository;
import com.mihneacristian.project_tracker.Services.CommentService;
import com.mihneacristian.project_tracker.Services.ProjectService;
import com.mihneacristian.project_tracker.Services.StatusService;
import com.mihneacristian.project_tracker.Services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectTrackerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectTrackerApplication.class, args);

        /*
        ProjectService projectService = (ProjectService) context.getBean("projectService", ProjectService.class);

        StatusService statusService = (StatusService) context.getBean("statusService", StatusService.class);

        TypeService typeService = (TypeService) context.getBean("typeService", TypeService.class);
         */

        /*
        ProjectService projectService = (ProjectService) context.getBean("projectService", ProjectService.class);
        ProjectDTO dto = new ProjectDTO();
        dto.projectName = "Tsdfsdfsdfdsfsest";
        dto.description = "Test";
        projectService.updateProjectById(5, dto);

         */

        CommentRepository commentRepository = (CommentRepository) context.getBean("commentRepository", CommentRepository.class);
        //System.out.println(commentService.getCommentById(1));

        //System.out.println(commentRepository.countAllComments());
        //System.out.println(commentRepository.selectMaxCommentId());

        StatusRepository statusRepository = (StatusRepository) context.getBean("statusRepository", StatusRepository.class);
        //System.out.println(statusRepository.getByStatusName("Done"));


    }
}
