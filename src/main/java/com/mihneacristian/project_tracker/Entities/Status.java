package com.mihneacristian.project_tracker.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    Integer statusId;

    @Column(name = "status_name", nullable = false)
    String statusName;

    @OneToMany(mappedBy = "statusOfProject", fetch = FetchType.EAGER)
    List<Project> projects;

    //@OneToMany(mappedBy = "statusOfItem", fetch = FetchType.EAGER)
    //List<Item> items;

    public Status() {
    }

    public Status(String statusName) {

        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /*
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    */

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
