package com.mihneacristian.project_tracker.RestControllers;

import com.mihneacristian.project_tracker.DTO.TeamMembersDTO;
import com.mihneacristian.project_tracker.Entities.TeamMembers;
import com.mihneacristian.project_tracker.Services.TeamMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TeamMembersController {

    @Autowired
    TeamMembersService teamMembersService;

    public TeamMembersController(TeamMembersService teamMembersService) {
        this.teamMembersService = teamMembersService;
    }

    @GetMapping(value = "/members", produces = "application/json")
    public ResponseEntity<List<TeamMembersDTO>> getAllMembers() {

        List<TeamMembersDTO> allMembersDTO = teamMembersService.getAllMembers();
        return new ResponseEntity<List<TeamMembersDTO>>(allMembersDTO, HttpStatus.OK);
    }

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

    @PostMapping(value = "add-new-member", consumes = "application/json")
    public ResponseEntity<TeamMembers> createMember(@RequestBody TeamMembersDTO teamMembersDTO) {

        TeamMembers teamMembers = teamMembersService.saveTeamMember(teamMembersDTO);
        return new ResponseEntity<TeamMembers>(teamMembers, HttpStatus.OK);
    }

    @DeleteMapping("/member/{memberId}")
    public void deleteMemberById(@PathVariable Integer memberId) {

        teamMembersService.deleteTeamMemberById(memberId);
    }

    @PutMapping(value = "/update-member/{memberId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TeamMembers> updateMemberById(@PathVariable(name = "memberId") Integer memberId, @RequestBody TeamMembersDTO teamMembersDTO) {

        TeamMembers t = teamMembersService.getMemberById(memberId);
        if (t != null) {
            TeamMembers teamMembers = teamMembersService.updateMemberById(memberId, teamMembersDTO);//todo save
            return new ResponseEntity<TeamMembers>(teamMembers, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find project with the id: " + memberId);
        }
    }
}
