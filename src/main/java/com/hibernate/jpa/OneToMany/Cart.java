package com.hibernate.jpa.OneToMany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Item> itemList=new ArrayList<>();

    public Cart(String name) {
        this.name = name;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
