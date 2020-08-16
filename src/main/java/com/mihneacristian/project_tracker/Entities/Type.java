package com.mihneacristian.project_tracker.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    Integer typeId;

    @Column(name = "name", nullable = false)
    String name;

    @OneToMany(mappedBy = "typeOfItem")
    List<Item> items;

    public Type() {
    }

    public Type(String typeOfItem) {

        this.name = typeOfItem;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}
