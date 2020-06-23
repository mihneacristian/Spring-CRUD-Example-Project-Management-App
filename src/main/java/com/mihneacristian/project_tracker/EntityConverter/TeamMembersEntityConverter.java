package com.mihneacristian.project_tracker.EntityConverter;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import org.springframework.stereotype.Service;

@Service
public class TeamMembersEntityConverter implements EntityConverter<TeamMembers, TeamMembersDTO> {

    @Override
    public TeamMembersDTO convertToDTO(TeamMembers teamMembersEntity) {
        TeamMembersDTO teamMembersDTO = new TeamMembersDTO();
        teamMembersDTO.teamMemberLastName = teamMembersEntity.getLastName();
        teamMembersDTO.teamMemberFirstName = teamMembersEntity.getFirstName();
        teamMembersDTO.teamMemberEmailAddress = teamMembersEntity.getEmailAddress();
        return teamMembersDTO;
    }

    @Override
    public TeamMembers convertToEntity(TeamMembersDTO teamMembersDTO) {
        TeamMembers teamMembersEntity = new TeamMembers();
        teamMembersEntity.setLastName(teamMembersDTO.teamMemberLastName);
        teamMembersEntity.setFirstName(teamMembersDTO.teamMemberFirstName);
        teamMembersEntity.setEmailAddress(teamMembersDTO.teamMemberEmailAddress);
        return teamMembersEntity;
    }
}
