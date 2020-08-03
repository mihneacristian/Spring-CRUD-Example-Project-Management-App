package com.mihneacristian.project_tracker.Controller;

import com.mihneacristian.project_tracker.DTO.ItemDTO;
import com.mihneacristian.project_tracker.Entities.Item;
import com.mihneacristian.project_tracker.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/item", produces = "application/json")
    public ResponseEntity<List<ItemDTO>> getAllItems() {

        List<ItemDTO> allItemsDTO = itemService.getAllItems();
        return new ResponseEntity<List<ItemDTO>>(allItemsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/item/id/{itemId}", produces = "application/json")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Integer itemId) {

        Item itemById = itemService.findByItemId(itemId);
        if (itemById != null) {
            Item itemEntity = itemById;
            ItemDTO itemDTO = new ItemDTO(itemEntity);
            return new ResponseEntity<ItemDTO>(itemDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with the id " + itemId + " was found.");
        }
    }

    @PostMapping(value = "/item", consumes = "application/json", produces = "application/json")
    public void createItem(@RequestBody Item item) {

        itemService.saveNewItem(item);
    }
}
