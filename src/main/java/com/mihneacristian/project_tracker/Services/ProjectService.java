package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import com.mihneacristian.project_tracker.Entities.Project;
import com.mihneacristian.project_tracker.Entities.Status;
import com.mihneacristian.project_tracker.EntityConverter.ProjectEntityConverter;
import com.mihneacristian.project_tracker.Repositories.ProjectRepository;
import com.mihneacristian.project_tracker.Repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    ProjectEntityConverter projectEntityConverter;

    @Transactional
    public Boolean isProjectIdPresent(Integer id) {

        return projectRepository.findById(id).isPresent();
    }

    @Transactional
    public Project getProjectById(Integer id){

        Optional<Project> byId = projectRepository.findProjectByProjectId(id);

        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a project with the id: " + id);
            // todo ELSE throw exception
        }
    }

    @Transactional
    public List<Project> findByName(String title) {

        return projectRepository.findByName(title);
    }

    @Transactional
    public Project saveProject(ProjectDTO projectDTO) {

        Optional<Status> byStatusName = statusRepository.findByStatusName(projectDTO.statusName);

        Status status = null;
        if (!byStatusName.isPresent()) {

            Status newStatus = new Status(projectDTO.statusName);
            status = statusRepository.save(newStatus);
        } else {

            status = byStatusName.get();
        }

        Project projectToBeSaved = new Project(projectDTO, status);
        Project savedProject = projectRepository.save(projectToBeSaved);
        return savedProject;
    }

    @Transactional
    public List<ProjectDTO> getAllProjects() {

        List<Project> all = projectRepository.findAll();
        List<ProjectDTO> dtos = new ArrayList<>();
        //LocalDate now = LocalDate.now();
        //LocalDate then = LocalDate.of(2020, 6, 1);
        for (Project project : all) {
            ProjectDTO temp = new ProjectDTO();
            temp.projectId = project.getProjectId();
            temp.projectName = project.getName();
            temp.teamMemberOfProjectLastName = project.getTeamMemberOfProject().getLastName();
            temp.teamMemberOfProjectFirstName = project.getTeamMemberOfProject().getFirstName();
            temp.teamMemberOfProjectEmailAddress = project.getTeamMemberOfProject().getEmailAddress();
            //temp.projectStatus = project.getStatusOfProject().getStatusName();
            //temp.daysLeft = String.valueOf(Period.between(now, then).getDays() + " days");
            dtos.add(temp);
        }
        return dtos;
    }

    @Transactional
    public Project updateProjectById(Integer id, ProjectDTO projectToBeUpdated) {

        Project project;

        Optional<Project> projectOptional = projectRepository.findById(id);
        if (!projectOptional.isPresent()) {

            throw new RuntimeException("Could not find project with the id: " + id);
        } else {

            project = projectOptional.get();
            project.setName(projectToBeUpdated.projectName);
            project.setDescription(projectToBeUpdated.description);
        }
        return projectRepository.save(project);
    }

    @Transactional
    public void deleteProjectById(Integer id) {

        projectRepository.deleteById(id);
    }
}