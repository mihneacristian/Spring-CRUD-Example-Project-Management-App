package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Optional<Type> findByName(String typeName);
}
