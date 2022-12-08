/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consultcalhoun.interviewing;

/**
 *
 * @author eben
 */
public class Sku implements Comparable {
    private String id;
    
    public Sku (String id) {
        if (id == null) {
            throw new IllegalArgumentException("Null argument value not supported");
        }
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Empty string argument value not supported");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Null argument value not supported");
        }
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Empty string argument value not supported");
        }
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new UnsupportedOperationException("Unable to compare to null objects");
        if (!(o instanceof Sku)) throw new UnsupportedOperationException("Can only compare to another instance of Sku");
        
        return id.compareTo(((Sku)o).getId());
    }
}
