package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
