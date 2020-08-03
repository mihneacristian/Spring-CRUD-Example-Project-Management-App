package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.TeamMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer> {

    TeamMembers findByLastName(String lastName);

    TeamMembers findByFirstName(String firstName);

    TeamMembers findByEmailAddress(String emailAddress);
}
