package com.mihneacristian.project_tracker.EntityConverter;

import com.mihneacristian.project_tracker.DTO.ItemDTO;
import com.mihneacristian.project_tracker.Entities.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemEntityConverter implements EntityConverter<Item, ItemDTO> {

    @Override
    public ItemDTO convertToDTO(Item itemEntity) {

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.itemId = itemEntity.getItemId();
        itemDTO.title = itemEntity.getTitle();
        itemDTO.description = itemEntity.getDescription();
        itemDTO.statusOfItem = itemEntity.getStatusOfItem().getStatusName();
        itemDTO.typeOfItem = itemEntity.getTypeOfItem().getName();

        if (itemEntity.getStatusOfItem() != null && itemEntity.getTypeOfItem() != null) {

            itemDTO.statusOfItem = itemEntity.getStatusOfItem().getStatusName();
            itemDTO.typeOfItem = itemEntity.getTypeOfItem().getName();
        } else if (itemEntity.getStatusOfItem() == null){

            itemDTO.statusOfItem = "Undefined Status";
        } else if (itemEntity.getTypeOfItem() == null) {

            itemDTO.typeOfItem = "Undefined Type";
        }
        return itemDTO;
    }

    @Override
    public Item convertToEntity(ItemDTO itemDTO) {

        Item itemEntity = new Item();

        itemEntity.setTitle(itemDTO.title);
        itemEntity.setDescription(itemDTO.description);
        return itemEntity;
    }
}
