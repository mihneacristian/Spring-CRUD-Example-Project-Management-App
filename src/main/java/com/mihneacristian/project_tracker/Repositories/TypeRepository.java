package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findByName(String typeName);
}
