package com.mihneacristian.project_tracker.RestControllers;

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
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/items", produces = "application/json")
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

    @PostMapping(value = "add-new-item", consumes = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody ItemDTO itemDTO) {

        Item item = itemService.saveNewItem(itemDTO);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }

    @PutMapping(value = "/update-item/{itemId}", consumes = "application/json")
    public ResponseEntity<Item> updateProjectById(@PathVariable(name = "itemId") Integer itemId, @RequestBody ItemDTO itemDTO) {

        Item p = itemService.findByItemId(itemId);
        if (p != null) {
            Item item = itemService.updateItemById(itemId, itemDTO);//todo save
            return new ResponseEntity<Item>(item, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find item with the id: " + itemId);
        }
    }

    @DeleteMapping("/item/{itemId}")
    public void deleteProjectById(@PathVariable Integer itemId) {

        if (itemService.isItemIdPresent(itemId)) {
            itemService.deleteItemById(itemId);

            //TODO DO NOT THROW EXCEPTION DIRECTLY. RETURN AN EXCEPTION DTO
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No item with the id " + itemId + " was found.");
        }
    }
}
