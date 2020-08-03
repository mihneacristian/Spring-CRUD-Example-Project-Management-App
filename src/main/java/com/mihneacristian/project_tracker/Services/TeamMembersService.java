package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import com.mihneacristian.project_tracker.Repositories.TeamMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TeamMembersService {

    @Autowired
    TeamMembersRepository teamMembersRepository;

    @Transactional
    public TeamMembers findByLastName(String lastName) {

        return teamMembersRepository.findByLastName(lastName);
    }

    @Transactional
    public TeamMembers findByFirstName(String firstName) {

        return teamMembersRepository.findByFirstName(firstName);
    }

    @Transactional
    public TeamMembers findByEmailAdddress(String emailAddress) {

        return teamMembersRepository.findByEmailAddress(emailAddress);
    }

    @Transactional
    public TeamMembers saveTeamMember(TeamMembersDTO teamMembersDTO) {

        TeamMembers teamMemberToBeSaved = new TeamMembers(teamMembersDTO);
        TeamMembers teamMemberSaved = teamMembersRepository.save(teamMemberToBeSaved);
        return teamMemberSaved;
    }

    @Transactional
    public void deleteTeamMemberById(Integer id) {

        teamMembersRepository.deleteById(id);
    }
}
