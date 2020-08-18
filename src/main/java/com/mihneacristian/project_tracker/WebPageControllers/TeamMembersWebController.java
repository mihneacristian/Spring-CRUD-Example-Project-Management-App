package com.mihneacristian.project_tracker.WebPageControllers;

import com.mihneacristian.project_tracker.Repositories.TeamMembersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamMembersWebController {

    private final TeamMembersRepository teamMembersRepository;

    public TeamMembersWebController(TeamMembersRepository teamMembersRepository) {
        this.teamMembersRepository = teamMembersRepository;
    }

    @GetMapping("/members")
    public ModelAndView membersPage() {
        ModelAndView modelAndView = new ModelAndView("members");

        return modelAndView;
    }
}
