package com.mihneacristian.project_tracker.EntityConverter;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import org.springframework.stereotype.Service;

@Service
public class TeamMembersEntityConverter implements EntityConverter<TeamMembers, TeamMembersDTO> {

    @Override
    public TeamMembersDTO convertToDTO(TeamMembers teamMembers) {
        TeamMembersDTO teamMembersDTO = new TeamMembersDTO();
        teamMembersDTO.teamMemberLastName = teamMembers.getLastName();
        teamMembersDTO.teamMemberFirstName = teamMembers.getFirstName();
        teamMembersDTO.teamMemberEmailAddress = teamMembers.getEmailAddress();
        return teamMembersDTO;
    }

    @Override
    public TeamMembers convertToEntity(TeamMembersDTO teamMembersDTO) {
        TeamMembers teamMembers = new TeamMembers();
        teamMembers.setLastName(teamMembersDTO.teamMemberLastName);
        teamMembers.setFirstName(teamMembersDTO.teamMemberFirstName);
        teamMembers.setEmailAddress(teamMembersDTO.teamMemberEmailAddress);
        return teamMembers;
    }
}
