package com.mihneacristian.project_tracker.Entities;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team_members")
public class TeamMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Integer memberId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email_address")
    String emailAddress;


    @OneToMany(mappedBy = "teamMemberOfProject")
    List<Project> projects;

    @OneToMany(mappedBy = "teamMemberOfItem")
    List<Item> items;

    public TeamMembers() {
    }

    public TeamMembers(Integer teamMemberId) {
    }

    public TeamMembers(TeamMembersDTO teamMembersDTO) {
        this.lastName = teamMembersDTO.teamMemberLastName;
        this.firstName = teamMembersDTO.teamMemberFirstName;
        this.emailAddress = teamMembersDTO.teamMemberEmailAddress;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Team_Members{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
