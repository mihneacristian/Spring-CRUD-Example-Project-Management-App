package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    Optional<Status> findByStatusName(String statusName);
}
