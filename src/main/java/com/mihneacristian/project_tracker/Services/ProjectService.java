package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import com.mihneacristian.project_tracker.Entities.Project;
import com.mihneacristian.project_tracker.Entities.Status;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import com.mihneacristian.project_tracker.EntityConverter.ProjectEntityConverter;
import com.mihneacristian.project_tracker.Repositories.ProjectRepository;
import com.mihneacristian.project_tracker.Repositories.StatusRepository;
import com.mihneacristian.project_tracker.Repositories.TeamMembersRepository;
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
    TeamMembersRepository teamMembersRepository;

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
        Optional<TeamMembers> byMemberId = teamMembersRepository.findByMemberId(projectDTO.teamMemberId);

        TeamMembers teamMembers = null;
        if (!byMemberId.isPresent()) {

            TeamMembers newMember = new TeamMembers(projectDTO.teamMemberId);
            teamMembers = teamMembersRepository.save(newMember);
        } else {
            teamMembers = byMemberId.get();
        }

        Status status = null;
        if (!byStatusName.isPresent()) {

            Status newStatus = new Status(projectDTO.statusName);
            status = statusRepository.save(newStatus);
        } else {

            status = byStatusName.get();
        }

        Project projectToBeSaved = new Project(projectDTO, teamMembers, status);
        Project savedProject = projectRepository.save(projectToBeSaved);
        return savedProject;
    }

    @Transactional
    public List<ProjectDTO> getAllProjects() {

        List<Project> all = projectRepository.findAll();
        List<ProjectDTO> dtos = new ArrayList<>();
        for (Project project : all) {
            ProjectDTO temp = new ProjectDTO();
            temp.projectId = project.getProjectId();
            temp.projectName = project.getName();
            temp.description = project.getDescription();
            temp.statusName = project.getStatusOfProject().getStatusName();
            temp.teamMemberId = project.getTeamMemberOfProject().getMemberId();
            temp.teamMemberOfProjectLastName = project.getTeamMemberOfProject().getLastName();
            temp.teamMemberOfProjectFirstName = project.getTeamMemberOfProject().getFirstName();
            temp.teamMemberOfProjectEmailAddress = project.getTeamMemberOfProject().getEmailAddress();
            dtos.add(temp);
        }
        return dtos;
    }

    @Transactional
    public Project updateProjectById(Integer id, ProjectDTO projectToBeUpdated) {

        Project project;
        Status status;
        TeamMembers teamMembers;

        Optional<Status> statusOptional = statusRepository.findByStatusName(projectToBeUpdated.statusName);

        Optional<TeamMembers> teamMembersOptional = teamMembersRepository.findByMemberId(projectToBeUpdated.teamMemberId);

        Optional<Project> projectOptional = projectRepository.findById(id);
        if (!projectOptional.isPresent()) {

            throw new RuntimeException("Could not find project with the id: " + id);
        } else {

            project = projectOptional.get();

            status = statusOptional.get();
            status.setStatusName(projectToBeUpdated.statusName);

            teamMembers = teamMembersOptional.get();
            teamMembers.setMemberId(projectToBeUpdated.teamMemberId);

            project.setName(projectToBeUpdated.projectName);
            project.setDescription(projectToBeUpdated.description);
            project.setStatusOfProject(status);
            project.setTeamMemberOfProject(teamMembers);
        }
        return projectRepository.save(project);
    }

    @Transactional
    public void deleteProjectById(Integer id) {

        projectRepository.deleteById(id);
    }
}