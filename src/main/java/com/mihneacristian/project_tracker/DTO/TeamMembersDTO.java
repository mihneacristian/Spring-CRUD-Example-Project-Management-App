package com.mihneacristian.project_tracker.DTO;

import com.mihneacristian.project_tracker.Entities.TeamMembers;

public class TeamMembersDTO {

    public int teamMemberid;
    public String teamMemberLastName;
    public String teamMemberFirstName;
    public String teamMemberEmailAddress;

    public TeamMembersDTO() {
    }

    public TeamMembersDTO(int teamMemberid, String teamMemberLastName, String teamMemberFirstName, String teamMemberEmailAddress) {
        this.teamMemberid = teamMemberid;
        this.teamMemberLastName = teamMemberLastName;
        this.teamMemberFirstName = teamMemberFirstName;
        this.teamMemberEmailAddress = teamMemberEmailAddress;
    }

    public TeamMembersDTO(TeamMembers teamMembersEntity) {
        this.teamMemberid = teamMembersEntity.getMemberId();
        this.teamMemberFirstName = teamMembersEntity.getFirstName();
        this.teamMemberLastName = teamMembersEntity.getLastName();
        this.teamMemberEmailAddress = teamMembersEntity.getEmailAddress();
    }

    public int getTeamMemberid() {
        return teamMemberid;
    }

    public void setTeamMemberid(int teamMemberid) {
        this.teamMemberid = teamMemberid;
    }

    public String getTeamMemberLastName() {
        return teamMemberLastName;
    }

    public void setTeamMemberLastName(String teamMemberLastName) {
        this.teamMemberLastName = teamMemberLastName;
    }

    public String getTeamMemberFirstName() {
        return teamMemberFirstName;
    }

    public void setTeamMemberFirstName(String teamMemberFirstName) {
        this.teamMemberFirstName = teamMemberFirstName;
    }

    public String getTeamMemberEmailAddress() {
        return teamMemberEmailAddress;
    }

    public void setTeamMemberEmailAddress(String teamMemberEmailAddress) {
        this.teamMemberEmailAddress = teamMemberEmailAddress;
    }

    @Override
    public String toString() {
        return "TeamMembersDTO{" +
                "teamMemberid=" + teamMemberid +
                ", teamMemberLastName='" + teamMemberLastName + '\'' +
                ", teamMemberFirstName='" + teamMemberFirstName + '\'' +
                ", teamMemberEmailAddress='" + teamMemberEmailAddress + '\'' +
                '}';
    }
}
