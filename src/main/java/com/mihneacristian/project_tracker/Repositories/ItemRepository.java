package com.mihneacristian.project_tracker.Repositories;

import com.mihneacristian.project_tracker.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByItemId(Integer itemId);

    List<Item> findByTitle(String title);
}
