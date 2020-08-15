package com.mihneacristian.project_tracker.DTO;

import com.mihneacristian.project_tracker.Entities.Project;

public class ProjectDTO {

    public int projectId;
    public String projectName;
    public String description;
    public String statusName;
    public Integer teamMemberId;
    public String teamMemberOfProjectFirstName;
    public String teamMemberOfProjectLastName;
    public String teamMemberOfProjectEmailAddress;

    public ProjectDTO() {
    }

    public ProjectDTO(Project projectEntity) {
        this.projectId = projectEntity.getProjectId();
        this.projectName = projectEntity.getName();
        this.description = projectEntity.getDescription();
        this.teamMemberOfProjectLastName = projectEntity.getTeamMemberOfProject().getLastName();
        this.teamMemberOfProjectFirstName = projectEntity.getTeamMemberOfProject().getFirstName();
        this.teamMemberOfProjectEmailAddress = projectEntity.getTeamMemberOfProject().getEmailAddress();

        if (projectEntity.getTeamMemberOfProject() != null) {

            this.teamMemberId = projectEntity.getTeamMemberOfProject().getMemberId();
        } else {
            this.teamMemberId = 1;
        }

        if (projectEntity.getStatusOfProject() != null) {

            this.statusName = projectEntity.getStatusOfProject().getStatusName();
        } else {

            this.statusName = "Undefined Status";
        }
    }

    public Integer getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Integer teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String getTeamMemberOfProjectFirstName() {
        return teamMemberOfProjectFirstName;
    }

    public void setTeamMemberOfProjectFirstName(String teamMemberOfProjectFirstName) {
        this.teamMemberOfProjectFirstName = teamMemberOfProjectFirstName;
    }

    public String getTeamMemberOfProjectLastName() {
        return teamMemberOfProjectLastName;
    }

    public void setTeamMemberOfProjectLastName(String teamMemberOfProjectLastName) {
        this.teamMemberOfProjectLastName = teamMemberOfProjectLastName;
    }

    public String getTeamMemberOfProjectEmailAddress() {
        return teamMemberOfProjectEmailAddress;
    }

    public void setTeamMemberOfProjectEmailAddress(String teamMemberOfProjectEmailAddress) {
        this.teamMemberOfProjectEmailAddress = teamMemberOfProjectEmailAddress;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", statusName='" + statusName + '\'' +
                ", teamMemberId='" + teamMemberId + '\'' +
                ", teamMemberOfProjectFirstName='" + teamMemberOfProjectFirstName + '\'' +
                ", teamMemberOfProjectLastName='" + teamMemberOfProjectLastName + '\'' +
                ", teamMemberOfProjectEmailAddress='" + teamMemberOfProjectEmailAddress + '\'' +
                '}';
    }
}
