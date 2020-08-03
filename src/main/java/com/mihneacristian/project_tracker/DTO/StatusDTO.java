package com.mihneacristian.project_tracker.DTO;

public class StatusDTO {

    public int statusId;
    public String statusName;
    public String statusOfProject;

    public StatusDTO() {
    }

    public StatusDTO(int statusId, String statusName, String statusOfProject) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusOfProject = statusOfProject;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusOfProject() {
        return statusOfProject;
    }

    public void setStatusOfProject(String statusOfProject) {
        this.statusOfProject = statusOfProject;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                ", statusOfProject='" + statusOfProject + '\'' +
                '}';
    }
}
