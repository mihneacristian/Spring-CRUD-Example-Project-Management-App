package com.mihneacristian.project_tracker.Controller;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import com.mihneacristian.project_tracker.Services.TeamMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class TeamMembersController {

    @Autowired
    TeamMembersService teamMembersService;

    @GetMapping(value = "/member/firstName/{firstName}", produces = "application/json")
    public ResponseEntity<TeamMembersDTO> getTeamMemberByFirstName(@PathVariable String firstName) {

        TeamMembers teamMemberDTO = teamMembersService.findByFirstName(firstName);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            TeamMembersDTO teamMembersDTO = new TeamMembersDTO(teamMember);
            return new ResponseEntity<TeamMembersDTO>(teamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with first name: " + firstName + " was found.");
        }
    }

    @GetMapping(value = "member/lastName/{lastName}", produces = "application/json")
    public ResponseEntity<TeamMembersDTO> getTeamMemberByLastName(@PathVariable String lastName) {

        TeamMembers teamMemberDTO = teamMembersService.findByLastName(lastName);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            TeamMembersDTO teamMembersDTO = new TeamMembersDTO(teamMember);
            return new ResponseEntity<TeamMembersDTO>(teamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with last name: " + lastName + " was found.");
        }
    }

    @GetMapping(value = "member/emailAddress/{emailAddress}", produces = "application/json")
    public ResponseEntity<TeamMembersDTO> getTeamMemberByEmailAddress(@PathVariable String emailAddress) {

        TeamMembers teamMemberDTO = teamMembersService.findByEmailAdddress(emailAddress);
        if (teamMemberDTO != null) {
            TeamMembers teamMember = teamMemberDTO;
            TeamMembersDTO teamMembersDTO = new TeamMembersDTO(teamMember);
            return new ResponseEntity<TeamMembersDTO>(teamMembersDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No team member with the email address: " + emailAddress + " was found.");
        }
    }
}
