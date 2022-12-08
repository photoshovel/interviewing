/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.consultcalhoun.interviewing;

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
public class SkuTest {
    
    public SkuTest() {
    }
    
    @BeforeAll
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
    }

    /**
     * Test of getId method, of class Sku.
     */
    /*@Test
    public void testGetId() {
        System.out.println("getId");
        Sku instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of setId method, of class Sku.
     */
    @Test
    public void testSetIdToNull() {
        System.out.println("setId");
        String id = "";
        try {
            Sku instance = new Sku(id);
            assertTrue(false, "Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testSetIdToEmptyString() {
        System.out.println("setId");
        String id = "";
        try {
            Sku instance = new Sku(id);
            assertTrue(false, "Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            assertTrue(true);
        }
    }

    /**
     * Test of compareTo method, of class Sku.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object o = new Sku("StuTheSku");
        Sku instance = new Sku("StuTheSku");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Sku.
     */
    @Test
    public void testCompareToNotEqual() {
        System.out.println("compareTo");
        Object o = new Sku("StuTheStu");
        Sku instance = new Sku("StuTheSku");
        int equalsResult = 0;
        int result = instance.compareTo(o);
        assertNotEquals(equalsResult, result);
    }
}
