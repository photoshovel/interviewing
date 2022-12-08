/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultcalhoun.interviewing;

/**
 *
 * @author eben
 */
public class Item {
    private String name, description;
    private Sku sku;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }
   
    public Item (String name, String description, Sku sku) {
        this.name = name;
        this.description = description;
        this.sku = sku;
    }
    
}
