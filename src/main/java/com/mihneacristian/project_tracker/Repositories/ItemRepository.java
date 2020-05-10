package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
