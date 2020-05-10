package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
