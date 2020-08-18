package com.mihneacristian.project_tracker.Entities;

import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    Integer projectId;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "member_id")
    TeamMembers teamMemberOfProject;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status statusOfProject;

    public Project() {
    }

    public Project(ProjectDTO projectDTO, TeamMembers member, Status status) {

        this.name = projectDTO.projectName;
        this.description = projectDTO.description;
        this.teamMemberOfProject = member;
        this.statusOfProject = status;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatusOfProject() {
        return statusOfProject;
    }

    public void setStatusOfProject(Status statusOfProject) {
        this.statusOfProject = statusOfProject;
    }

    public TeamMembers getTeamMemberOfProject() {
        return teamMemberOfProject;
    }

    public void setTeamMemberOfProject(TeamMembers teamMemberOfProject) {
        this.teamMemberOfProject = teamMemberOfProject;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teamMemberOfProject=" + teamMemberOfProject +
                ", statusOfProject=" + statusOfProject +
                '}';
    }
}
