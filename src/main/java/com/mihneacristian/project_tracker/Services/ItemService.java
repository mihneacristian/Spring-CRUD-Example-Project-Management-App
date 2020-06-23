package com.mihneacristian.project_tracker.Services;

import com.mihneacristian.project_tracker.DTO.ItemDTO;
import com.mihneacristian.project_tracker.DTO.ProjectDTO;
import com.mihneacristian.project_tracker.Entities.Item;
import com.mihneacristian.project_tracker.Entities.Project;
import com.mihneacristian.project_tracker.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public Optional<Item> findByItemId(Integer id) {

        return itemRepository.findByItemId(id);
    }

    @Transactional
    public List<Item> findByTitle(String title) {

        return itemRepository.findByTitle(title);
    }

    @Transactional
    public List<ItemDTO> getAllItems() {

        List<Item> allItems = itemRepository.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();

        for (Item item :
                allItems) {
            ItemDTO temp = new ItemDTO();
            temp.itemId = item.getItemId();
            temp.title = item.getTitle();
            temp.description = item.getDescription();
            itemDTOS.add(temp);
        }
        return itemDTOS;
    }

    @Transactional
    public void saveNewItem(Item item) {

        itemRepository.save(item);
    }

    @Transactional
    public Item updateItemById(Integer id, ItemDTO itemToBeUpdated) {

        Item item;

        Optional<Item> itemOptional = itemRepository.findById(id);
        if (!itemOptional.isPresent()) {

            throw new RuntimeException("Could not find item with the id: " + id);
        } else {

            item = itemOptional.get();
            item.setTitle(itemToBeUpdated.title);
            item.setDescription(itemToBeUpdated.description);
        }
        return itemRepository.save(item);
    }

    @Transactional
    public void deleteItemById(Integer id) {

        itemRepository.deleteById(id);
    }
}
