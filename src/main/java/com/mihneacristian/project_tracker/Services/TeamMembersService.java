package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import com.mihneacristian.project_tracker.Repositories.TeamMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamMembersService {

    @Autowired
    TeamMembersRepository teamMembersRepository;

    @Transactional
    public TeamMembers getMemberById(Integer id){

        Optional<TeamMembers> byId = teamMembersRepository.findByMemberId(id);

        if(byId.isPresent()){
            return byId.get();
        } else {
            throw new RuntimeException("Could not find a member with the id: " + id);
            // todo ELSE throw exception
        }
    }

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

    @Transactional
    public List<TeamMembersDTO> getAllMembers() {

        List<TeamMembers> all = teamMembersRepository.findAll();
        List<TeamMembersDTO> dtos = new ArrayList<>();
        for (TeamMembers member : all) {
            TeamMembersDTO temp = new TeamMembersDTO();
            temp.teamMemberid = member.getMemberId();
            temp.teamMemberLastName = member.getLastName();
            temp.teamMemberFirstName = member.getFirstName();
            temp.teamMemberEmailAddress = member.getEmailAddress();
            dtos.add(temp);
        }
        return dtos;
    }

    @Transactional
    public TeamMembers updateMemberById(Integer id, TeamMembersDTO memberToBeUpdated) {

        TeamMembers teamMembers;

        Optional<TeamMembers> teamMembersOptional = teamMembersRepository.findById(id);
        if (!teamMembersOptional.isPresent()) {

            throw new RuntimeException("Could not find member with the id: " + id);
        } else {

            teamMembers = teamMembersOptional.get();
            teamMembers.setFirstName(memberToBeUpdated.teamMemberFirstName);
            teamMembers.setLastName(memberToBeUpdated.teamMemberLastName);
            teamMembers.setEmailAddress(memberToBeUpdated.teamMemberEmailAddress);
        }
        return teamMembersRepository.save(teamMembers);
    }
}
