package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.Entities.Item;
import com.mihneacristian.project_tracker.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public Optional<Item> getItemById(Integer id) {

        return itemRepository.findById(id);
    }

    @Transactional
    public void saveNewItem(Item item) {

        itemRepository.save(item);
    }

    @Transactional
    public List<Item> getAllItems() {

        return itemRepository.findAll();
    }

    @Transactional
    public void deleteItemById(Integer id) {

        itemRepository.deleteById(id);
    }
}
