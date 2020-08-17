package com.mihneacristian.project_tracker.DTO;

import com.mihneacristian.project_tracker.Entities.Item;

public class ItemDTO {

    public int itemId;
    public String title;
    public String description;
    public String statusOfItem;
    public String typeOfItem;
    public Integer teamMemberId;

    public Integer getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(Integer teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public String teamMemberOfProjectFirstName;
    public String teamMemberOfProjectLastName;
    public String teamMemberOfProjectEmailAddress;

    public ItemDTO() {
    }

    public ItemDTO(Item itemEntity) {
        this.itemId = itemEntity.getItemId();
        this.title = itemEntity.getTitle();
        this.description = itemEntity.getDescription();
        this.statusOfItem = itemEntity.getStatusOfItem().getStatusName();
        this.typeOfItem = itemEntity.getTypeOfItem().getName();
        this.teamMemberId = itemEntity.getTeamMemberOfItem().getMemberId();
        this.teamMemberOfProjectFirstName = itemEntity.getTeamMemberOfItem().getFirstName();
        this.teamMemberOfProjectLastName = itemEntity.getTeamMemberOfItem().getLastName();
        this.teamMemberOfProjectEmailAddress = itemEntity.getTeamMemberOfItem().getEmailAddress();
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusOfItem() {
        return statusOfItem;
    }

    public void setStatusOfItem(String statusOfItem) {
        this.statusOfItem = statusOfItem;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public String getTeamMemberOfProjectFirstName() {
        return teamMemberOfProjectFirstName;
    }

    public void setTeamMemberOfProjectFirstName(String teamMemberOfProjectFirstName) {
        this.teamMemberOfProjectFirstName = teamMemberOfProjectFirstName;
    }

    public String getTeamMemberOfProjectLastName() {
        return teamMemberOfProjectLastName;
    }

    public void setTeamMemberOfProjectLastName(String teamMemberOfProjectLastName) {
        this.teamMemberOfProjectLastName = teamMemberOfProjectLastName;
    }

    public String getTeamMemberOfProjectEmailAddress() {
        return teamMemberOfProjectEmailAddress;
    }

    public void setTeamMemberOfProjectEmailAddress(String teamMemberOfProjectEmailAddress) {
        this.teamMemberOfProjectEmailAddress = teamMemberOfProjectEmailAddress;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusOfItem='" + statusOfItem + '\'' +
                ", typeOfItem='" + typeOfItem + '\'' +
                ", teamMemberId=" + teamMemberId +
                ", teamMemberOfProjectFirstName='" + teamMemberOfProjectFirstName + '\'' +
                ", teamMemberOfProjectLastName='" + teamMemberOfProjectLastName + '\'' +
                ", teamMemberOfProjectEmailAddress='" + teamMemberOfProjectEmailAddress + '\'' +
                '}';
    }
}
