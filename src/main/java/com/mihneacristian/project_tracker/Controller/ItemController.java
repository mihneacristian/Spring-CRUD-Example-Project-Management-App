package com.mihneacristian.project_tracker.Controller;

import com.mihneacristian.project_tracker.DTO.ItemDTO;
import com.mihneacristian.project_tracker.Entities.Item;
import com.mihneacristian.project_tracker.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping(value = "/item", produces = "application/json")
    public ResponseEntity<List<ItemDTO>> getValue() {

        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseEntity<List<ItemDTO>>(allItems, HttpStatus.OK);
    }

    @PostMapping(value = "/item", consumes = "application/json", produces = "application/json")
    public void createItem(@RequestBody Item item) {

        itemService.saveNewItem(item);
    }
}
