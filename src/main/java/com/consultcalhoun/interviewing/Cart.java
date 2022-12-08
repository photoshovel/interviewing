package com.consultcalhoun.interviewing;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author eben
 */
public class Cart {
    private Map<Sku, CartItem> contents = new TreeMap<Sku, CartItem>();
    
    public Cart() {
        
    }
    
    public Map<Sku, CartItem> getContents() {
        return contents;
    }
    
    public void addItem(CartItem item) {
        contents.put(item.getItem().getSku(), item);
    }
    
    public void removeItem(Sku sku) {
        contents.remove(sku);
    }
}
