/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.consultcalhoun.interviewing;

import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author eben
 */
public class CartTest {
    
    public CartTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    /*@BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    /**
     * Test of getContents method, of class Cart.
     */
    /*@org.junit.jupiter.api.Test
    public void testGetContents() {
        System.out.println("getContents");
        Cart instance = new Cart();
        Map<Sku, CartItem> expResult = null;
        Map<Sku, CartItem> result = instance.getContents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of addItem method, of class Cart.
     */
    @org.junit.jupiter.api.Test
    public void testHappyPath() {
        System.out.println("addItem");

        Sku sku1 = new Sku("cog-small");
        Item item1  = new Item("Small Cog", "Small-sized Cogswell Cog", sku1);
        
        Sku sku2 = new Sku("sprocket-medium");
        Item item2  = new Item("Medium Sprocket", "Medium-sized Spacely Sprocket", sku2);
        
        Cart instance = new Cart();
        instance.addItem(new CartItem(item1, 1));
        
        // TODO: Check item quantities.
        Map<Sku, CartItem> contents = instance.getContents();
        assertEquals(contents.size(), 1, "Contents should contain 1 item; found " + contents.size());
        assertTrue(contents.containsKey(sku1));
        assertFalse(contents.containsKey(sku2));
        
        instance.addItem(new CartItem(item2, 3));
        contents = instance.getContents();
        assertEquals(contents.size(), 2, "Contents should contain 2 items; found " + contents.size());
        assertTrue(contents.containsKey(sku1));
        assertTrue(contents.containsKey(sku2));
        
        instance.removeItem(sku1);
        contents = instance.getContents();
        assertEquals(contents.size(), 1, "Contents should contain 1 item; found " + contents.size());
        assertFalse(contents.containsKey(sku1));
        assertTrue(contents.containsKey(sku2));
    }

    /**
     * Test of removeItem method, of class Cart.
     */
    /*@org.junit.jupiter.api.Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        Sku sku = null;
        Cart instance = new Cart();
        instance.removeItem(sku);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
