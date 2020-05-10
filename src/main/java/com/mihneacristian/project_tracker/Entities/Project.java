package com.mihneacristian.project_tracker.Entities;

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

    @Column(name = "short_name", nullable = false)
    String shortname;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status statusOfProject;

    public Integer getProjectId(Integer id) {
        return id;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", description='" + description + '\'' +
                ", statusOfProject=" + statusOfProject +
                '}';
    }
}
